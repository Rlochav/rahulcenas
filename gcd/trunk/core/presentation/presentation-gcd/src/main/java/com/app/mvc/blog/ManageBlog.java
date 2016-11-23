package com.app.mvc.blog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.DocumentDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.post.dto.PostDTO;
import com.app.posts.service.PostService;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.DateUtil;

@Controller
public class ManageBlog extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private PostService postService;
	@Autowired
	private GetCityDealz getCityDealz;
	private PostDTO postDTO;

	private InputStream inputStream;
	private OutputStream outputStream;

	private MultipartFile upload;

	@RequestMapping(value = "createPost")
	public ModelAndView display() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		if (userInfo != null && "1001".equals(userInfo.getUserType())) {
			return new ModelAndView("../../WelcomePage");
		}
		ModelAndView mav = new ModelAndView("blog/createPost");
		PostDTO postDTO = new PostDTO();
		mav.addObject("postDTO", postDTO);
		try {
			String postId = getRequestParam("postId");
			if (postId != null)
				postDTO = postService.getPostDetailsById(userInfo, postId);
			mav.addObject("postDTO", postDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "loadAllPost")
	public String loadAllPost(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			modelMap.put("postDTO", postService.loadMyAllPost(userInfo).getPostDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "blog/allPost";
	}

	@RequestMapping(value = "/savePost")
	public String createPost(@ModelAttribute("postDTO") PostData postDTO, BindingResult bindingResult, ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		PostDTO dto = new PostDTO();
		try {
			if (postDTO.getAttachedImage() != null) {
				double bytes = postDTO.getAttachedImage().getSize();
				double kilobytes = (bytes / 1024);
				double megabytes = (kilobytes / 1024);

				if (megabytes > 10)
					bindingResult.rejectValue("userId", "common.msg.000005");
			}

			if (getRequestParam("postId") != null && !getRequestParam("postId").trim().isEmpty())
				postDTO.setPostId(getRequestParam("postId"));
			if (getRequestParam("title") != null && !getRequestParam("title").trim().isEmpty())
				postDTO.setPostTitle(getRequestParam("title"));
			if (getRequestParam("post") != null && !getRequestParam("post").trim().isEmpty())
				postDTO.setPostText(getRequestParam("post"));
			dto = postService.createPost(userInfo, postDTO);

			if (postDTO.getAttachedImage() != null) {

			}
		} catch (BaseException e) {
			dto = new PostDTO();
			e.printStackTrace();
			if (e instanceof BaseException) {
				BaseException bEx = (BaseException) e;
				dto.setJsonMessage(bEx.getMsgCode());
			} else if (e.getCause() instanceof BusinessException) {
				BusinessException bEx = (BusinessException) e.getCause();
				dto.setJsonMessage(bEx.getMsgCode());
			} else {
				dto.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return "redirect:/loadAllPost";
	}

	@RequestMapping(value = "/uplaodImage")
	public ResponseEntity<byte[]> uploadImage(HttpServletRequest request) {
		DocumentDTO documentDTO = new DocumentDTO();
		byte[] bytes = null;
		try {
			UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
					: null;

			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Set set = multipartRequest.getFileMap().entrySet();

			Iterator i = set.iterator();
			while (i.hasNext()) {
				Map.Entry me = (Map.Entry) i.next();
				String fileName = (String) me.getKey();
				MultipartFile multipartFile = (MultipartFile) me.getValue();
				documentDTO.setMerchantId(userInfo.getUserIndex() + "");
				documentDTO.setDocType("10");

				documentDTO.setFileSavedAs(DateUtil.getDateTimeStamp() + "_" + multipartFile.getOriginalFilename());
				documentDTO.setOrignalFileName(multipartFile.getOriginalFilename());
				documentDTO.setContentType(multipartFile.getContentType());
				documentDTO.setParentFolderPath(AppPropertyBuilder.getProperty("DMS.location.blog", "01"));
				DocumentDTO docDto = getCityDealz.saveDocumentDetails(userInfo, documentDTO);
				uploadFiles(userInfo, multipartFile, docDto.getFileSavedAs());
				bytes = multipartFile.getBytes();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(bytes,responseHeaders,  HttpStatus.CREATED);
	}

	public boolean uploadFiles(UserInfo userInfo, MultipartFile multipartFile, String saveAsFileName) {
		File fileObj = null;
		File dirObj = null;

		boolean booSuccessFg;
		try {
			dirObj = new File(AppPropertyBuilder.getProperty("DMS.location.blog", "01"));
			if (!(dirObj.exists())) {
				dirObj.mkdirs();
			}

			if (dirObj.exists() && dirObj.isDirectory()) {
				fileObj = new File(dirObj.getAbsolutePath() + File.separator + saveAsFileName);
			}
			if (!fileObj.exists()) {
				fileObj.createNewFile();
			}
			inputStream = multipartFile.getInputStream();
			outputStream = new FileOutputStream(fileObj);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			booSuccessFg = true;
		} catch (Exception e) {
			booSuccessFg = false;
			try {
				fileObj.delete();
			} catch (Exception e1) {
				try {
					fileObj.deleteOnExit();
				} catch (Exception ex) {
				}
			}
			fileObj = null;
			e.printStackTrace();
		}
		return booSuccessFg;
	}

	@RequestMapping(value = "deletePost")
	@ResponseBody
	public PostDTO deletePost() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			postDTO = null;
			if (postDTO == null)
				postDTO = new PostDTO();
			if (getRequestParam("postId") != null && !getRequestParam("postId").trim().isEmpty())
				postDTO.setPostId(getRequestParam("postId"));
			postDTO = postService.deletePost(userInfo, postDTO);
		} catch (BaseException e) {
			postDTO = new PostDTO();
			e.printStackTrace();
			if (e instanceof BaseException) {
				BaseException bEx = (BaseException) e;
				postDTO.setJsonMessage(bEx.getMsgCode());
			} else if (e.getCause() instanceof BusinessException) {
				BusinessException bEx = (BusinessException) e.getCause();
				postDTO.setJsonMessage(bEx.getMsgCode());
			} else {
				postDTO.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return postDTO;
	}

	public PostDTO getPostDTO() {
		return postDTO;
	}

	public void setPostDTO(PostDTO postDTO) {
		this.postDTO = postDTO;
	}

	/**
	 * @return the upload
	 */
	public MultipartFile getUpload() {
		return upload;
	}

	/**
	 * @param upload
	 *            the upload to set
	 */
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}

}
