package com.app.admin.controllers;

import static org.springframework.util.CollectionUtils.isEmpty;
import static org.springframework.util.StringUtils.isEmpty;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.DocumentDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.DateUtil;
import com.app.utility.common.IntUtil;
import com.app.utility.common.StringUtil;

@Controller
@RequestMapping("/component")
public class GcdMetaController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -152160061568719913L;

	@Autowired
	private GetCityDealz getCityDealz;
	private InputStream inputStream;
	private OutputStream outputStream;

	@RequestMapping(value = "/gcd-meta-handler")
	public ModelAndView displayMetaPage() {
		ModelAndView mav = new ModelAndView("admin/gcdMetaMgmt");
		return mav;
	}

	@RequestMapping(value = "/editNav")
	public ModelAndView editMetaPage() {
		ModelAndView mav = new ModelAndView("admin/editGcdMeta");
		mav.addObject("type", getRequestParam("tyep"));
		mav.addObject("edit", getRequestParam("edit"));
		try {
			String btnName = "Add";
			if (!isEmpty(getRequestParam("navId"))) {
				com.app.common.dto.GcdMetaDTO dto = getCityDealz.getMetaById(IntUtil.getInteger(getRequestParam("navId")));
				mav.addObject("dto", dto);
				mav.addObject("edit", dto.getIsEditable());
				btnName = "Edit";
			}
			mav.addObject("btnName", btnName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/nav1")
	public ModelAndView displayMetaSocial() {
		ModelAndView mav = new ModelAndView("admin/gcd-meta-header-social");
		mav.addObject("type", "1");
		try {
			com.app.common.dto.GcdMetaDTO dto = getCityDealz.getMetaByType(1);
			if (dto != null && !isEmpty(dto.getGcdMetaDTOs())) {
				mav.addObject("dtos", dto.getGcdMetaDTOs());
				mav.addObject("size", dto.getGcdMetaDTOs().size());
			} else {
				mav.addObject("size", 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/nav2")
	public ModelAndView displayMetaMasterCtg() {
		ModelAndView mav = new ModelAndView("admin/gcd-meta-header-social");
		mav.addObject("type", "2");
		try {
			com.app.common.dto.GcdMetaDTO dto = getCityDealz.getMetaByType(2);
			if (dto != null && !isEmpty(dto.getGcdMetaDTOs())) {
				mav.addObject("dtos", dto.getGcdMetaDTOs());
				mav.addObject("size", dto.getGcdMetaDTOs().size());
			} else {
				mav.addObject("size", 0);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mav;
	}

	@RequestMapping(value = "/nav3")
	public ModelAndView displayMetaFooter() {
		ModelAndView mav = new ModelAndView("admin/gcd-meta-header-social");
		mav.addObject("type", "3");
		try {
			com.app.common.dto.GcdMetaDTO dto = getCityDealz.getMetaByType(3);
			if (dto != null && !isEmpty(dto.getGcdMetaDTOs())) {
				mav.addObject("dtos", dto.getGcdMetaDTOs());
				mav.addObject("size", dto.getGcdMetaDTOs().size());
			} else {
				mav.addObject("size", 0);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mav;
	}

	@RequestMapping(value = "/nav4")
	public ModelAndView displayMetaPageContent() {
		ModelAndView mav = new ModelAndView("admin/gcd-meta-header-social");
		mav.addObject("type", "4");
		return mav;
	}

	@RequestMapping(value = "/nav5")
	public ModelAndView displayMetaRightHandRailsContent() {
		ModelAndView mav = new ModelAndView("admin/gcd-meta-header-social");
		mav.addObject("type", "5");
		return mav;
	}

	@RequestMapping(value = "/saveMetaNav")
	public String saveMetaNav(@ModelAttribute("metaDTO") GcdMetaDTO metaDTO, ModelMap modelMap, RedirectAttributes redirectAttributes) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		com.app.common.dto.GcdMetaDTO gmDto = new com.app.common.dto.GcdMetaDTO();
		try {
			if (!isEmpty(metaDTO.getId()))
				gmDto.setId(metaDTO.getId());
			if (!isEmpty(metaDTO.getImageAlt()))
				gmDto.setImageAlt(metaDTO.getImageAlt());
			if (!isEmpty(metaDTO.getText()))
				gmDto.setText(metaDTO.getText());
			if (!isEmpty(metaDTO.getUrl()))
				gmDto.setUrl(metaDTO.getUrl());
			gmDto.setShowOnPage(metaDTO.getShowOnPage() == null ? "0" : "1");
			if (!isEmpty(metaDTO.getType()))
				gmDto.setType(metaDTO.getType());
			if (!isEmpty(metaDTO.getAlign()))
				gmDto.setAlign(metaDTO.getAlign());
			if (!isEmpty(metaDTO.getPageText()))
				gmDto.setPageText(metaDTO.getPageText());
			if (!isEmpty(metaDTO.getElementId()))
				gmDto.setElementId(metaDTO.getElementId());
			if (!isEmpty(metaDTO.getElementClass()))
				gmDto.setElementClass(metaDTO.getElementClass());
			
			gmDto.setIsEditable(metaDTO.getIsEditable() == null ? "false" : metaDTO.getIsEditable());

			/*if ("3".equals(metaDTO.getType()) && gmDto.getIsEditable().equals("true")) {
				gmDto.setUrl("http://gcddev.com/common/" + StringUtil.getWithoutSpecial(metaDTO.getImageAlt()));
			}*/

			gmDto = getCityDealz.saveMetaNav(userInfo, gmDto);

			if (metaDTO.getImage() != null && !metaDTO.getImage().isEmpty()) {
				DocumentDTO documentDTO = new DocumentDTO();
				documentDTO.setMerchantId(gmDto.getId() + "");
				documentDTO.setDocType("12");
				documentDTO.setLogoId(gmDto.getImagePath());
				documentDTO.setFileSavedAs(DateUtil.getDateTimeStamp() + "_" + metaDTO.getImage().getOriginalFilename());
				documentDTO.setOrignalFileName(metaDTO.getImage().getOriginalFilename());
				documentDTO.setContentType(metaDTO.getImage().getContentType());
				documentDTO.setParentFolderPath(AppPropertyBuilder.getProperty("DMS.location.navs", "01"));
				DocumentDTO dto = getCityDealz.saveDocumentDetails(userInfo, documentDTO);
				uploadFiles(userInfo, metaDTO.getImage(), dto.getFileSavedAs());
			}
			redirectAttributes.addFlashAttribute("message", "Icon Saved Successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof BaseException) {
				BaseException bEx = (BaseException) e;
			} else if (e.getCause() instanceof BusinessException) {
				BusinessException bEx = (BusinessException) e.getCause();
			} else {
			}
		}
		return "redirect:/component/nav" + gmDto.getType();
	}

	public boolean uploadFiles(UserInfo userInfo, MultipartFile multipartFile, String saveAsFileName) throws IOException {
		File fileObj = null;
		File dirObj = null;

		boolean booSuccessFg;
		try {
			dirObj = new File(AppPropertyBuilder.getProperty("DMS.location.navs", "01"));
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
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.flush();
				outputStream.close();
			}
		}
		return booSuccessFg;
	}
}
