package com.app.admin.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.doc.controller.FileUploadForm;
import com.app.getcitydealz.dto.DocumentDTO;
import com.app.getcitydealz.dto.MerchantCategoryDTO;
import com.app.getcitydealz.dto.MerchantDTO;
import com.app.getcitydealz.dto.SocialConnectionsDTO;
import com.app.getcitydealz.merchant.MerchantService;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.DateUtil;
import com.app.utility.common.IntUtil;

@Controller
public class ManageMerchantController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private GetCityDealz getCityDealz;
	private InputStream inputStream;
	private OutputStream outputStream;
	private MerchantDTO mDto;

	@RequestMapping(value = "/component/merchantList")
	public ModelAndView manageMerchantDisplay() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/merchantManagement/manageMerchant");
		try {
			String start = getRequestParam("start");
			String page = null;
			if (start == null) {
				start = "0";
			}
			page = ((IntUtil.getInteger(start) / 20) + 1) + "";
			mav.addObject("page", page);
			mav.addObject("start", start);

			MerchantDTO merchantDTO = merchantService.getAllMerchantList(userInfo, start);
			if (merchantDTO != null) {
				mav.addObject("merchantDTO", merchantDTO.getMerchantDTOs());
				mav.addObject("count", merchantDTO.getCounts());
			}
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/merchantInfo")
	public ModelAndView infoMerchantDisplay() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/merchantManagement/merchantInfo");
		String merchantId = getRequestParam("merchantId");
		try {
			DocumentDTO documentDTO = getCityDealz.getDocumentDetailsByMerchantId(merchantId);
			mav.addObject("documentDTO", documentDTO.getDocumentDTOs());
			MerchantDTO merchantDTO = merchantService.getMerchantDetailsById(userInfo, merchantId);
			SocialConnectionsDTO connectionsDTO = merchantService.getMySocialConnections(merchantId);
			mav.addObject("merchantDTO", merchantDTO);
			mav.addObject("connectionsDTO", connectionsDTO);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/editMerchantInfo")
	public ModelAndView ieditMerchantInfoDisplay(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		MerchantFields formDTO = new MerchantFields();
		Map<String, String> masterCategory = null;
		Map<String, String> categoryMap = null;
		Map<String, String> subCategory1Map = null;
		Map<String, String> subCategory2Map = null;
		Map<String, String> neighborhoodMap = null;
		ModelAndView mav = new ModelAndView("admin/merchantManagement/editMerchantInfo");
		try {
			String mershantId = getRequestParam("merchantId");
			masterCategory = merchantService.getMasterCategory(userInfo);
			categoryMap = merchantService.getCategory(userInfo);
			neighborhoodMap = merchantService.getNeighborhoodMap(userInfo);

			if (mershantId == null || mershantId.trim().isEmpty())
				mershantId = userInfo.getUserIndex() + "";
			MerchantDTO merchantDTO = merchantService.getMerchantDetailById(mershantId);
			if (merchantDTO.getCategory1() != null)
				subCategory1Map = merchantService.getSubCategoryMap(mershantId, merchantDTO.getCategory1());
			if (merchantDTO.getCategory2() != null)
				subCategory2Map = merchantService.getSubCategoryMap(mershantId, merchantDTO.getCategory2());

			modelMap.addAttribute("merchantDTO", merchantDTO);
			mav.addObject("masterCategory", masterCategory);
			mav.addObject("subCategory1", subCategory1Map);
			mav.addObject("neighborhoodMap", neighborhoodMap);
			mav.addObject("subCategory2", subCategory2Map);
			mav.addObject("categoryMap", categoryMap);
			mav.addObject("selectedSubCategory1", merchantService.getSelectedSubCategories(mershantId, merchantDTO.getCategory1()));
			mav.addObject("selectedSubCategory2", merchantService.getSelectedSubCategories(mershantId, merchantDTO.getCategory2()));
			mav.addObject("myProfileForm", formDTO);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/updateMerchantInfo")
	public String updateMyProfile(@ModelAttribute("myProfileForm") MerchantFields merchantFields, ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		String merchantId = getRequestParam("merchantId");
		try {

			MerchantDTO merchantDTO = new MerchantDTO();
			merchantDTO.setMerchantId(merchantId);
			merchantDTO.setUserId(merchantFields.getUserId());
			merchantDTO.setMerchantName(merchantFields.getMerchantName());
			merchantDTO.setEmailId(merchantFields.getEmailId());
			merchantDTO.setPassword(merchantFields.getPassword());
			merchantDTO.setGetCityDealzName(merchantFields.getGetCityDealzName());
			merchantDTO.setContactPhone(merchantFields.getContactPhone());
			merchantDTO.setContactAlternatePhone(merchantFields.getContactAlternatePhone());
			merchantDTO.setWebsiteUrl(merchantFields.getWebsiteUrl());
			merchantDTO.setCityId(merchantFields.getCityId());
			merchantDTO.setState(merchantFields.getState());
			merchantDTO.setZipCode(merchantFields.getZipCode());
			merchantDTO.setDifferentBillingAddress(merchantFields.isDifferentBillingAddress());
			merchantDTO.setSalesPerson(merchantFields.getSalesPerson());
			merchantDTO.setGoogleAnalyticsId(merchantFields.getGoogleAnalyticsId());
			merchantDTO.setContactFirstName(merchantFields.getContactFirstName());
			merchantDTO.setContactLastName(merchantFields.getContactLastName());
			merchantDTO.setAddress1(merchantFields.getAddress1());
			merchantDTO.setAddress2(merchantFields.getAddress2());
			merchantDTO.setAddress3(merchantFields.getAddress3());
			merchantDTO.setBlogTemplateId(merchantFields.getBlogTemplateId());
			merchantDTO.setMasterCategory(merchantFields.getMasterCategory());
			merchantDTO.setNeighborhoodName(merchantFields.getNeighborhoodName());

			if (merchantFields.getMerchantFeature() != null && !merchantFields.getMerchantFeature().trim().isEmpty()) {
				String[] features = merchantFields.getMerchantFeature().split(",");
				merchantDTO.setmFeatureList(Arrays.asList(features));
			}

			MerchantCategoryDTO m1 = null;
			if (merchantFields.getCategory1() != null && !merchantFields.getCategory1().trim().isEmpty() && merchantFields.getMasterCategory() != null
					&& !merchantFields.getMasterCategory().trim().isEmpty() && merchantFields.getSubCategory1() != null
					&& !merchantFields.getSubCategory1().trim().isEmpty()) {
				m1 = new MerchantCategoryDTO();
				m1.setCategoryId(merchantFields.getCategory1());
				m1.setMasterCategory(merchantFields.getMasterCategory());
				m1.setSubCatgoryId(merchantFields.getSubCategory1());
			}

			MerchantCategoryDTO m2 = null;
			if (merchantFields.getCategory2() != null && !merchantFields.getCategory2().trim().isEmpty() && merchantFields.getMasterCategory() != null
					&& !merchantFields.getMasterCategory().trim().isEmpty() && merchantFields.getSubCategory2() != null
					&& !merchantFields.getSubCategory2().trim().isEmpty()) {
				m2 = new MerchantCategoryDTO();
				m2.setCategoryId(merchantFields.getCategory2());
				m2.setMasterCategory(merchantFields.getMasterCategory());
				m2.setSubCatgoryId(merchantFields.getSubCategory2());
			}
			merchantDTO.setMerchantCategories(new ArrayList<MerchantCategoryDTO>());
			if (m1 != null)
				merchantDTO.getMerchantCategories().add(m1);
			if (m2 != null)
				merchantDTO.getMerchantCategories().add(m2);

			merchantDTO.setSubscriptionLevel(merchantFields.getSubscriptionLevel());

			mDto = merchantService.updateMyProfile(userInfo, merchantDTO);
			DocumentDTO documentDTO = new DocumentDTO();
			documentDTO.setMerchantId(merchantId);
			documentDTO.setDocType("2");
			documentDTO.setFileSavedAs(DateUtil.getDateTimeStamp() + "_" + merchantFields.getLogo().getOriginalFilename());
			documentDTO.setOrignalFileName(merchantFields.getLogo().getOriginalFilename());
			documentDTO.setContentType(merchantFields.getLogo().getContentType());
			documentDTO.setParentFolderPath(AppPropertyBuilder.getProperty("DMS.location", "01"));
			DocumentDTO dto = getCityDealz.saveDocumentDetails(userInfo, documentDTO);
			uploadFiles(userInfo, merchantFields.getLogo(), dto.getFileSavedAs());

		} catch (Exception e) {
			mDto = new MerchantDTO();
			if (e instanceof BaseException)
				mDto.setJsonMessage(((BaseException) e).getMsgCode());
			else if (e instanceof BusinessException)
				mDto.setJsonMessage(((BusinessException) e).getMessage());
			else
				mDto.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
		}
		return "redirect:/component/merchantInfo?merchantId=" + merchantId;
	}

	public boolean uploadFiles(UserInfo userInfo, MultipartFile multipartFile, String saveAsFileName) {
		File fileObj = null;
		File dirObj = null;

		boolean booSuccessFg;
		try {
			dirObj = new File(AppPropertyBuilder.getProperty("DMS.location", "01"));
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

	@RequestMapping(value = "/component/updateSocialConnection", method = RequestMethod.GET)
	public String socialConnectionsDisplay(ModelMap modelMap) {
		try {
			modelMap.put("socialDTO", merchantService.getMySocialConnections(getRequestParam("merchantId")));
			modelMap.put("merchantId", getRequestParam("merchantId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/merchantManagement/editSocialConnection";
	}

	@RequestMapping(value = "/component/editMerchantMedia", method = RequestMethod.GET)
	public String editMerchantMedia(ModelMap modelMap) {
		try {
			DocumentDTO documentDTO = getCityDealz.getDocumentDetailsByMerchantId(getRequestParam("merchantId"));
			modelMap.put("documentDTO", documentDTO.getDocumentDTOs());
			modelMap.put("merchantId", getRequestParam("merchantId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/merchantManagement/updateMerchantMedia";
	}

	@RequestMapping(value = "/component/uploadMediaFiles", method = RequestMethod.POST)
	public String uploadMediaFiles(@ModelAttribute("uploadForm") FileUploadForm uploadForm, ModelMap map) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		String merchantId = getRequestParam("merchantId");
		List<String> docTitle = uploadForm.getDocTitle();
		List<String> showOnPages = uploadForm.getShowOnPages();
		List<MultipartFile> files = uploadForm.getFiles();
		List<String> fileNames = new ArrayList<String>();
		int i = 0;
		DocumentDTO documentDTO = null;
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
						documentDTO.setMerchantId(merchantId);
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
						DocumentDTO docDto = getCityDealz.getDocumentDetailsByMerchantId(userInfo.getUserIndex() + "");
						map.put("documentDTO", documentDTO.getDocumentDTOs());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		}
		map.addAttribute("files", fileNames);
		return "redirect:/component/merchantInfo?merchantId=" + merchantId;
	}

	@RequestMapping(value = "/component/deactivateMerchant")
	@ResponseBody
	public MerchantDTO deactivateMerchant() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		MerchantDTO merchantDTO = null;
		try {
			merchantDTO = getCityDealz.deactivateMerchant(userInfo, getRequestParam("merchantId"));
		} catch (Exception e) {
			merchantDTO = new MerchantDTO();
			e.printStackTrace();
			if (e instanceof BaseException)
				merchantDTO.setJsonMessage(((BaseException) e).getMsgCode());
			else if (e instanceof BusinessException)
				merchantDTO.setJsonMessage(((BusinessException) e).getMessage());
			else
				merchantDTO
						.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
		}
		return merchantDTO;
	}
}
