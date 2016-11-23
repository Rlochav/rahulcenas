package com.app.mvc.merchant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.doc.controller.FileUploadForm;
import com.app.getcitydealz.dto.DocumentDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.DateUtil;

@Controller
public class ManageMediaController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -773535633342230571L;
	@Autowired
	private GetCityDealz getCityDealz;
	private InputStream inputStream;
	private OutputStream outputStream;
	private DocumentDTO documentDTO;

	@RequestMapping(value = "/manageMedia")
	public String manageMediaDisplay(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			if (userInfo != null && "1001".equals(userInfo.getUserType())) {
				return "../../WelcomePage";
			}
			String message = getRequestParam("message");
			DocumentDTO documentDTO = getCityDealz.getDocumentDetailsByMerchantId(userInfo.getUserIndex() + "");
			modelMap.put("documentDTO", documentDTO.getDocumentDTOs());
			modelMap.put("message", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "merchant/manageMedia";
	}

	@RequestMapping(value = "/deleteMediaFile")
	@ResponseBody
	public DocumentDTO deleteMediaFile() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			String merchantId = getRequestParam("merchantId");
			if (merchantId == null || merchantId.trim().isEmpty())
				merchantId = userInfo.getUserIndex() + "";
			if (getRequestParam("docId") != null && !getRequestParam("docId").trim().isEmpty())
				documentDTO = getCityDealz.deleteMediaFile(merchantId, getRequestParam("docId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return documentDTO;
	}

	@RequestMapping(value = "/updateMediaTitle")
	@ResponseBody
	public DocumentDTO updateSavedMedia() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			if (documentDTO == null)
				documentDTO = new DocumentDTO();
			if (getRequestParam("merchantId") != null && !getRequestParam("merchantId").trim().isEmpty())
				documentDTO.setMerchantId(getRequestParam("merchantId"));
			if (documentDTO.getMerchantId() == null || documentDTO.getMerchantId().trim().isEmpty())
				documentDTO.setMerchantId(userInfo.getUserIndex() + "");
			if (getRequestParam("title") != null && !getRequestParam("title").trim().isEmpty())
				documentDTO.setDocumentTitle(getRequestParam("title"));
			if (getRequestParam("docId") != null && !getRequestParam("docId").trim().isEmpty())
				documentDTO.setDocId(getRequestParam("docId"));

			documentDTO = getCityDealz.updateDocumentDetails(userInfo, documentDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return documentDTO;
	}

	@RequestMapping(value = "/uploadMediaFiles", method = RequestMethod.POST)
	public String uploadMediaFiles(@ModelAttribute("uploadForm") FileUploadForm uploadForm, ModelMap map) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		List<String> docTitle = uploadForm.getDocTitle();
		List<String> showOnPages = uploadForm.getShowOnPages();
		List<MultipartFile> files = uploadForm.getFiles();
		List<String> fileNames = new ArrayList<String>();
		int i = 0;

		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

				try {
					if (multipartFile.getSize() > 0) {
						String fileName = multipartFile.getOriginalFilename();
						fileNames.add(fileName);
						inputStream = multipartFile.getInputStream();
						if (documentDTO == null)
							documentDTO = new DocumentDTO();
						if (docTitle != null && docTitle.size() >= i && docTitle.get(i) != null)
							documentDTO.setDocumentTitle(docTitle.get(i));

						if (showOnPages != null && showOnPages.size() >= i && showOnPages.get(i) != null)
							documentDTO.setShowOnPage(showOnPages.get(i).equals("on") ? "1" : "0");
						else
							documentDTO.setShowOnPage("0");
						i++;
						documentDTO.setMerchantId(userInfo.getUserIndex() + "");
						documentDTO.setOrignalFileName(fileName);
						documentDTO.setContentType(multipartFile.getContentType());
						documentDTO.setParentFolderPath(AppPropertyBuilder.getProperty("DMS.location", "01"));
						documentDTO.setDocType(uploadForm.getDocType());
						documentDTO.setFileSavedAs(DateUtil.getDateTimeStamp() + "_" + fileName);
						documentDTO.setOrignalFileName(fileName);
						documentDTO = getCityDealz.saveDocumentDetails(userInfo, documentDTO);

						File dir = new File(AppPropertyBuilder.getProperty("DMS.location", "01"));
						if (!dir.exists())
							dir.mkdir();
						File newFile = new File(dir, documentDTO.getFileSavedAs());
						if (!newFile.exists()) {
							newFile.createNewFile();
						}
						outputStream = new FileOutputStream(newFile);
						int read = 0;
						byte[] bytes = new byte[1024];

						while ((read = inputStream.read(bytes)) != -1) {
							outputStream.write(bytes, 0, read);
						}
					}
				} catch (Exception e) {
					if (e instanceof BaseException) {
						e.printStackTrace();
						map.put("message", ((BaseException) e).getMsgCode());
					} else if (e instanceof BusinessException) {
						e.printStackTrace();
						map.put("message", ((BusinessException) e).getMessage());
					} else {
						e.printStackTrace();
						map.put("message",
								"Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
					}
				} finally {
					try {
						DocumentDTO documentDTO = getCityDealz.getDocumentDetailsByMerchantId(userInfo.getUserIndex() + "");
						map.put("documentDTO", documentDTO.getDocumentDTOs());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		}
		map.addAttribute("files", fileNames);
		return "redirect:/manageMedia";
	}

	/**
	 * @return the inputStream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * @param inputStream
	 *            the inputStream to set
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * @return the outputStream
	 */
	public OutputStream getOutputStream() {
		return outputStream;
	}

	/**
	 * @param outputStream
	 *            the outputStream to set
	 */
	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

}
