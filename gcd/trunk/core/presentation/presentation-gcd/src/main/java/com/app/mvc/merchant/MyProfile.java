package com.app.mvc.merchant;

import static org.springframework.util.StringUtils.isEmpty;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.admin.controllers.MerchantFields;
import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.DocumentDTO;
import com.app.getcitydealz.dto.MerchantCategoryDTO;
import com.app.getcitydealz.dto.MerchantDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.DateUtil;

@Controller
public class MyProfile extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8427543797255818099L;

	@Autowired
	private MerchantService merchantService;
	@Autowired
	private GetCityDealz getCityDealz;
	private MerchantDTO mDto;
	private InputStream inputStream;
	private OutputStream outputStream;

	@RequestMapping(value = "/jsonGetSubCategoryByCtgId")
	@ResponseBody
	public Map<String, String> getSubCategoryMapByCategoryId() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		Map<String, String> retMap = null;
		try {
			if (getRequestParam("categoryId") != null && !getRequestParam("categoryId").trim().equals("-1"))
				retMap = merchantService.getSubCategoryMapByCategoryId(userInfo, getRequestParam("categoryId"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (retMap == null)
				retMap = new HashMap<String, String>();
		}
		return retMap;
	}

	@RequestMapping(value = "/myProfile", method = RequestMethod.GET)
	public ModelAndView display(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = null;
		if (userInfo != null && "1001".equals(userInfo.getUserType())) {
			Map<String, String> masterCategory = null;
			Map<String, String> categoryMap = null;
			Map<String, String> subCategory1Map = null;
			Map<String, String> subCategory2Map = null;
			Map<String, String> neighborhoodMap = null;
			Map<String, String> featureMap = null;
			mav = new ModelAndView("admin/merchantManagement/editMerchantInfo");
			try {
				String mershantId = getRequestParam("merchantId");
				masterCategory = merchantService.getMasterCategory(userInfo);
				categoryMap = merchantService.getCategory(userInfo);
				neighborhoodMap = merchantService.getNeighborhoodMap(userInfo);

				if (mershantId == null || mershantId.trim().isEmpty())
					mershantId = userInfo.getUserIndex() + "";
				MerchantDTO merchantDTO = merchantService.getMerchantDetailById(mershantId, null);
				if (merchantDTO.getCategory1() != null)
					subCategory1Map = merchantService.getSubCategoryMap(mershantId, merchantDTO.getCategory1());
				if (merchantDTO.getCategory2() != null)
					subCategory2Map = merchantService.getSubCategoryMap(mershantId, merchantDTO.getCategory2());

				modelMap.addAttribute("merchantDTO", merchantDTO);
				featureMap = merchantService.getFeatureMap(userInfo);
				mav.addObject("featureMap", featureMap);
				mav.addObject("masterCategory", masterCategory);
				mav.addObject("neighborhoodMap", neighborhoodMap);
				mav.addObject("categoryMap", categoryMap);

				boolean flag = false;
				StringBuilder s1 = new StringBuilder();
				StringBuilder s2 = new StringBuilder();
				List<MerchantCategoryDTO> categoryDTOs = merchantService.getSelectedSubCategories(mershantId, merchantDTO.getCategory1(), 1);
				if (!CollectionUtils.isEmpty(categoryDTOs)) {
					for (MerchantCategoryDTO dto : categoryDTOs) {
						if (merchantDTO.getCategory1() != null && merchantDTO.getCategory1().equals(dto.getCategoryId()) && !"2".equals(dto.getCategoryType())) {
							s1.append(dto.getSubCatgoryId());
							s1.append(",");
						}

						if (merchantDTO.getCategory2() != null && merchantDTO.getCategory2().equals(dto.getCategoryId())) {
							s2.append(dto.getSubCatgoryId());
							s2.append(",");
						}

						if (dto.getCategoryType() != null && dto.getCategoryType().equals("2") && merchantDTO.getCategory2() == null) {
							s2.append(dto.getSubCatgoryId());
							s2.append(",");
							flag = true;
						}
					}
					String a = null;
					String b = null;
					if (s1.length() > 0) {
						a = s1.toString().substring(0, s1.toString().length() - 1);
						mav.addObject("selectedSubCategory1", a);
					}
					if (s2.length() > 0) {
						b = s2.toString().substring(0, s2.toString().length() - 1);
						mav.addObject("selectedSubCategory2", b);
					}
				}

				if (flag) {
					merchantDTO.setCategory2(merchantDTO.getCategory1());
				}

				if (merchantDTO.getCategory1() != null)
					subCategory1Map = merchantService.getSubCategoryMap(userInfo.getUserIndex() + "", merchantDTO.getCategory1());
				if (merchantDTO.getCategory2() != null)
					subCategory2Map = merchantService.getSubCategoryMap(userInfo.getUserIndex() + "", merchantDTO.getCategory2());
				mav.addObject("subCategory1", subCategory1Map);
				mav.addObject("subCategory2", subCategory2Map);
				mav.addObject("myProfileForm", merchantDTO);
			} catch (BaseException e) {
				e.printStackTrace();
			}
			return mav;
		} else {
			MerchantFields formDTO = new MerchantFields();
			mav = new ModelAndView("merchant/merchantProfile");
			Map<String, String> masterCategory = null;
			Map<String, String> categoryMap = null;
			Map<String, String> subCategory1Map = null;
			Map<String, String> subCategory2Map = null;
			Map<String, String> neighborhoodMap = null;
			Map<String, String> featureMap = null;

			try {
				masterCategory = merchantService.getMasterCategory(userInfo);
				categoryMap = merchantService.getCategory(userInfo);
				neighborhoodMap = merchantService.getNeighborhoodMap(userInfo);
				String mershantId = getRequestParam("merchantId");
				if (mershantId == null || mershantId.trim().isEmpty())
					mershantId = userInfo.getUserIndex() + "";
				MerchantDTO merchantDTO = merchantService.getMerchantDetailById(mershantId, null);

				modelMap.addAttribute("merchantDTO", merchantDTO);
				mav.addObject("masterCategory", masterCategory);
				mav.addObject("neighborhoodMap", neighborhoodMap);
				/*
				 * mav.addObject("selectedSubCategory1",
				 * merchantService.getSelectedSubCategories(mershantId,
				 * merchantDTO.getCategory1()));
				 * mav.addObject("selectedSubCategory2",
				 * merchantService.getSelectedSubCategories(mershantId,
				 * merchantDTO.getCategory2()));
				 */

				boolean flag = false;
				StringBuilder s1 = new StringBuilder();
				StringBuilder s2 = new StringBuilder();
				List<MerchantCategoryDTO> categoryDTOs = merchantService.getSelectedSubCategories(mershantId, merchantDTO.getCategory1(), 1);
				if (!CollectionUtils.isEmpty(categoryDTOs)) {
					for (MerchantCategoryDTO dto : categoryDTOs) {
						if (merchantDTO.getCategory1() != null && merchantDTO.getCategory1().equals(dto.getCategoryId()) && !"2".equals(dto.getCategoryType())) {
							s1.append(dto.getSubCatgoryId());
							s1.append(",");
						}

						if (merchantDTO.getCategory2() != null && merchantDTO.getCategory2().equals(dto.getCategoryId())) {
							s2.append(dto.getSubCatgoryId());
							s2.append(",");
						}

						if (dto.getCategoryType() != null && dto.getCategoryType().equals("2") && merchantDTO.getCategory2() == null) {
							s2.append(dto.getSubCatgoryId());
							s2.append(",");
							flag = true;
						}
					}
					String a = null;
					String b = null;
					if (s1.length() > 0) {
						a = s1.toString().substring(0, s1.toString().length() - 1);
						mav.addObject("selectedSubCategory1", a);
					}
					if (s2.length() > 0) {
						b = s2.toString().substring(0, s2.toString().length() - 1);
						mav.addObject("selectedSubCategory2", b);
					}
				}

				if (flag) {
					merchantDTO.setCategory2(merchantDTO.getCategory1());
				}

				if (merchantDTO.getCategory1() != null)
					subCategory1Map = merchantService.getSubCategoryMap(userInfo.getUserIndex() + "", merchantDTO.getCategory1());
				if (merchantDTO.getCategory2() != null)
					subCategory2Map = merchantService.getSubCategoryMap(userInfo.getUserIndex() + "", merchantDTO.getCategory2());

				featureMap = merchantService.getFeatureMap(userInfo);
				mav.addObject("featureMap", featureMap);
				mav.addObject("subCategory2", subCategory2Map);
				mav.addObject("subCategory1", subCategory1Map);
				mav.addObject("categoryMap", categoryMap);
				mav.addObject("myProfileForm", formDTO);
			} catch (Exception e) {
				mDto = new MerchantDTO();
				if (e instanceof BaseException)
					mDto.setJsonMessage(((BaseException) e).getMsgCode());
				else if (e instanceof BusinessException)
					mDto.setJsonMessage(((BusinessException) e).getMessage());
				else
					mDto.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			} finally {
				if (masterCategory == null)
					masterCategory = new HashMap<String, String>();
				if (categoryMap == null)
					categoryMap = new HashMap<String, String>();
				if (neighborhoodMap == null)
					neighborhoodMap = new HashMap<String, String>();
			}
		}
		return mav;
	}

	@RequestMapping(value = "/updateMyProfile")
	public String updateMyProfile(@ModelAttribute("myProfileForm") MerchantFields merchantFields, ModelMap modelMap, RedirectAttributes redirectAttributes) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			MerchantDTO merchantDTO = new MerchantDTO();
			merchantDTO.setMerchantId(userInfo.getUserIndex() + "");
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
			merchantDTO.setBusinessHours(merchantFields.getBusinessHours());
			merchantDTO.setCityToDisplay(merchantFields.getCityToDisplay());

			merchantDTO.setNeighborhoodAddress(merchantFields.getNeighborhoodAddress());
			merchantDTO.setNeighborhoodCity(merchantFields.getNeighborhoodCity());
			merchantDTO.setNeighborhoodZip(merchantFields.getNeighborhoodZip());
			merchantDTO.setNeighborhoodState(merchantFields.getNeighborhoodState());

			if (merchantFields.getMerchantFeature() != null && !merchantFields.getMerchantFeature().trim().isEmpty()) {
				String[] features = merchantFields.getMerchantFeature().split(",");
				merchantDTO.setmFeatureList(Arrays.asList(features));
			}

			MerchantCategoryDTO m1 = null;
			if (!isEmpty(merchantFields.getCategory1()) && !isEmpty(merchantFields.getMasterCategory()) && !isEmpty(merchantFields.getSubCategory1())) {
				m1 = new MerchantCategoryDTO();
				m1.setCategoryId(merchantFields.getCategory1());
				m1.setMasterCategory(merchantFields.getMasterCategory());
				m1.setSubCatgoryId(merchantFields.getSubCategory1());
				m1.setCategoryType("1");
			}

			MerchantCategoryDTO m2 = null;
			if (!isEmpty(merchantFields.getCategory2()) && !isEmpty(merchantFields.getMasterCategory()) && !isEmpty(merchantFields.getSubCategory2())) {
				m2 = new MerchantCategoryDTO();
				m2.setCategoryId(merchantFields.getCategory2());
				m2.setMasterCategory(merchantFields.getMasterCategory());
				m2.setSubCatgoryId(merchantFields.getSubCategory2());
				m2.setCategoryType("2");
			}

			/*
			 * MerchantCategoryDTO m1 = null; if
			 * (!isEmpty(merchantFields.getCategory1()) &&
			 * !merchantFields.getCategory1
			 * ().equals(merchantFields.getCategory2()) &&
			 * !isEmpty(merchantFields.getMasterCategory()) &&
			 * !isEmpty(merchantFields.getSubCategory1())) { m1 = new
			 * MerchantCategoryDTO();
			 * m1.setCategoryId(merchantFields.getCategory1());
			 * m1.setMasterCategory(merchantFields.getMasterCategory());
			 * m1.setSubCatgoryId(merchantFields.getSubCategory1()); }
			 * 
			 * MerchantCategoryDTO m2 = null; if
			 * (!isEmpty(merchantFields.getCategory2()) &&
			 * !merchantFields.getCategory2
			 * ().equals(merchantFields.getCategory1()) &&
			 * !isEmpty(merchantFields.getMasterCategory()) &&
			 * !isEmpty(merchantFields.getSubCategory2())) { m2 = new
			 * MerchantCategoryDTO();
			 * m2.setCategoryId(merchantFields.getCategory2());
			 * m2.setMasterCategory(merchantFields.getMasterCategory());
			 * m2.setSubCatgoryId(merchantFields.getSubCategory2()); }
			 * 
			 * if (!isEmpty(merchantFields.getCategory1()) &&
			 * !isEmpty(merchantFields.getCategory2()) &&
			 * merchantFields.getCategory2
			 * ().equals(merchantFields.getCategory1()) &&
			 * !isEmpty(merchantFields.getMasterCategory()) &&
			 * !isEmpty(merchantFields.getSubCategory1())) { m1 = new
			 * MerchantCategoryDTO();
			 * m1.setCategoryId(merchantFields.getCategory1());
			 * m1.setMasterCategory(merchantFields.getMasterCategory());
			 * m1.setSubCatgoryId(merchantFields.getSubCategory1() + "," +
			 * merchantFields.getSubCategory2()); }
			 */
			merchantDTO.setMerchantCategories(new ArrayList<MerchantCategoryDTO>());

			if (m1 != null)
				merchantDTO.getMerchantCategories().add(m1);
			if (m2 != null)
				merchantDTO.getMerchantCategories().add(m2);

			merchantDTO.setSubscriptionLevel(merchantFields.getSubscriptionLevel());

			mDto = merchantService.updateMyProfile(userInfo, merchantDTO, merchantFields.getLocationDTOs());
			redirectAttributes.addFlashAttribute("message", "Details updated successfully");
			if (merchantFields.getLogo() != null && !merchantFields.getLogo().isEmpty()) {
				DocumentDTO documentDTO = new DocumentDTO();
				documentDTO.setMerchantId(userInfo.getUserIndex() + "");
				documentDTO.setDocType("2");
				documentDTO.setLogoId(merchantFields.getLogoId());
				documentDTO.setFileSavedAs(DateUtil.getDateTimeStamp() + "_" + merchantFields.getLogo().getOriginalFilename());
				documentDTO.setOrignalFileName(merchantFields.getLogo().getOriginalFilename());
				documentDTO.setContentType(merchantFields.getLogo().getContentType());
				documentDTO.setParentFolderPath(AppPropertyBuilder.getProperty("DMS.location", "01"));
				DocumentDTO dto = getCityDealz.saveDocumentDetails(userInfo, documentDTO);
				uploadFiles(userInfo, merchantFields.getLogo(), dto.getFileSavedAs());
			}
		} catch (Exception e) {
			mDto = new MerchantDTO();
			if (e instanceof BaseException)
				mDto.setJsonMessage(((BaseException) e).getMsgCode());
			else if (e instanceof BusinessException)
				mDto.setJsonMessage(((BusinessException) e).getMessage());
			else
				mDto.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
		}
		return "redirect:/myProfile";
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
}
