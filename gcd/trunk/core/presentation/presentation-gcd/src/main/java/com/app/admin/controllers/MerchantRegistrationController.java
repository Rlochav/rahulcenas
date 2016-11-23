package com.app.admin.controllers;

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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.common.interceptor.SupportClass;
import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.CityDTO;
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
import com.app.utility.common.EmailUtility;

@Controller
public class MerchantRegistrationController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5685639178346478296L;

	@Autowired
	private MerchantService merchantService;
	@Autowired
	private GetCityDealz getCityDealz;
	private MerchantDTO mDto;
	private InputStream inputStream;
	private OutputStream outputStream;

	@RequestMapping(value = "/component/merchantRegistration")
	public ModelAndView display(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		MerchantDTO formDTO = new MerchantDTO();
		ModelAndView mav = new ModelAndView("admin/merchantManagement/mMgmtAddMerchant");
		Map<String, String> masterCategory = null;
		Map<String, String> categoryMap = null;
		Map<String, String> subcLevelMap = null;
		Map<String, String> featureMap = null;
		Map<String, String> neighborhoodMap = null;
		Map<String, String> salesPersonMap = null;
		mav.addObject("message", getRequestParam("message"));
		try {
			salesPersonMap = merchantService.getSalesPersonMap(userInfo);
			neighborhoodMap = merchantService.getNeighborhoodMap(userInfo);
			featureMap = merchantService.getFeatureMap(userInfo);
			masterCategory = merchantService.getMasterCategory(userInfo);
			categoryMap = merchantService.getCategory(userInfo);
			subcLevelMap = merchantService.getSubscriptionLevel(userInfo);
			mav.addObject("masterCategory", masterCategory);
			mav.addObject("categoryMap", categoryMap);
			mav.addObject("subcLevelMap", subcLevelMap);
			mav.addObject("featureMap", featureMap);
			mav.addObject("neighborhoodMap", neighborhoodMap);
			mav.addObject("salesPersonMap", salesPersonMap);
			mav.addObject("addNewMerchantForm", formDTO);
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
			if (featureMap == null)
				featureMap = new HashMap<String, String>();
		}
		return mav;
	}

	@RequestMapping(value = "/component/verifyEmailUserId")
	@ResponseBody
	public String verifyRegisterForm() {
		String message = null;
		try {
			String userId = getRequestParam("userId");
			String emailId = getRequestParam("emailId");
			message = merchantService.verifyRegisterForm(userId, emailId);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof BaseException)
				message = ((BaseException) e).getMsgCode();
			else if (e instanceof BusinessException)
				message = ((BusinessException) e).getMessage();
			else
				message = "Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator";
		}
		return message;
	}

	@RequestMapping(value = "/component/doRegister")
	public String doRegister(@ModelAttribute("addNewMerchantForm") MerchantFields merchantFields, ModelMap modelMap, RedirectAttributes redirectAttributes) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			MerchantDTO merchantDTO = new MerchantDTO();
			merchantDTO.setMerchantName(merchantFields.getMerchantName());
			merchantDTO.setEmailId(merchantFields.getEmailId());
			merchantDTO.setPassword(merchantFields.getPassword());
			merchantDTO.setGetCityDealzName(merchantFields.getGetCityDealzName());
			merchantDTO.setContactAlternatePhone(merchantFields.getContactAlternatePhone());
			merchantDTO.setWebsiteUrl(merchantFields.getWebsiteUrl());
			merchantDTO.setCity(userInfo.getCityId());
			merchantDTO.setContactPhone(merchantFields.getBusinessPhone());
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
			merchantDTO.setNeighborhoodAddress(merchantFields.getNeighborhoodAddress());
			merchantDTO.setNeighborhoodCity(merchantFields.getNeighborhoodCity());
			merchantDTO.setNeighborhoodZip(merchantFields.getNeighborhoodZip());
			merchantDTO.setNeighborhoodState(merchantFields.getNeighborhoodState());
			merchantDTO.setBusinessHours(merchantFields.getBusinessHours());
			merchantDTO.setCityToDisplay(merchantFields.getCityToDisplay());

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

			/*if (!isEmpty(merchantFields.getCategory1()) && !isEmpty(merchantFields.getCategory2())
					&& merchantFields.getCategory2().equals(merchantFields.getCategory1()) && !isEmpty(merchantFields.getMasterCategory())
					&& !isEmpty(merchantFields.getSubCategory1())) {
				m1 = new MerchantCategoryDTO();
				m1.setCategoryId(merchantFields.getCategory1());
				m1.setMasterCategory(merchantFields.getMasterCategory());
				m1.setSubCatgoryId(merchantFields.getSubCategory1() + "," + merchantFields.getSubCategory2());
			}*/
			merchantDTO.setMerchantCategories(new ArrayList<MerchantCategoryDTO>());
			if (m1 != null)
				merchantDTO.getMerchantCategories().add(m1);
			if (m2 != null)
				merchantDTO.getMerchantCategories().add(m2);

			merchantDTO.setSubscriptionLevel(merchantFields.getSubscriptionLevel());

			merchantDTO.setbAddress1(merchantFields.getbAddress1());
			merchantDTO.setbAddress2(merchantFields.getbAddress2());
			merchantDTO.setbAddress3(merchantFields.getbAddress3());

			merchantDTO.setbCity(userInfo.getCityId());
			merchantDTO.setbState(merchantFields.getbState());

			mDto = merchantService.doRegisterMerchant(userInfo, merchantDTO, merchantFields.getLocationDTOs());
			if (merchantFields.getLogo() != null && merchantFields.getLogo().getSize() > 0) {
				DocumentDTO documentDTO = new DocumentDTO();
				documentDTO.setMerchantId(mDto.getMerchantId());
				documentDTO.setDocType("2");
				documentDTO.setFileSavedAs(DateUtil.getDateTimeStamp() + "_" + merchantFields.getLogo().getOriginalFilename());
				documentDTO.setOrignalFileName(merchantFields.getLogo().getOriginalFilename());
				documentDTO.setContentType(merchantFields.getLogo().getContentType());
				documentDTO.setParentFolderPath(AppPropertyBuilder.getProperty("DMS.location", "01"));
				DocumentDTO dto = getCityDealz.saveDocumentDetails(userInfo, documentDTO);
				uploadFiles(userInfo, merchantFields.getLogo(), dto.getFileSavedAs());

			}
			redirectAttributes.addFlashAttribute("message", "Merchant information saved sucessfully.Please check your spam mail and whitelist GetCityDealz");
			Map<String, Object> holderMap = new HashMap<String, Object>();
			holderMap.put("MerchantName", merchantDTO.getMerchantName());

			holderMap.put("CityName", getCityDealz.getCityDetails(merchantDTO.getCity()).getCityName());
			holderMap.put("ContactFirstName", merchantDTO.getContactFirstName());
			String standardUrl = AppPropertyBuilder.getProperty("standardUrl.subdomain.url", "01");
			CityDTO cityDTO = new SupportClass().getCityDTO(userInfo.getCityId());

			holderMap.put("URL", "http://" + cityDTO.getCityCode() + standardUrl);
			holderMap.put("Password", merchantDTO.getPassword());
			holderMap.put("Username", merchantDTO.getGetCityDealzName());
			List<String> rec = Arrays.asList(merchantDTO.getEmailId());
			boolean f = EmailUtility.postMailType2("01", rec, null, null, "Get City Dealz", "emailTemplate.vm", holderMap, 2);

		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof BaseException)
				modelMap.put("message", ((BaseException) e).getMsgCode());
			else if (e instanceof BusinessException)
				modelMap.put("message", ((BusinessException) e).getMessage());
			else
				modelMap.put("message",
						"Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			return "redirect:/component/merchantRegistration";
		}
		return "redirect:/component/merchantList?order=desc";
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

	@RequestMapping(value = "/mRegistrationSuccessfully")
	public String merchantRegistrationSuccess(Model model) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		String defaultPws = generatePassword(true, true, true, false, 15);
		try {
			if (mDto != null)
				mDto.setPassword(defaultPws);
			/*
			 * boolean flag = EmailUtility.sendMailType1(mDto.getEmailId(),
			 * "GetCityDealz--Login Credential", "User ID: " + mDto.getEmailId()
			 * + "\nPassword: " + defaultPws);
			 */
			// System.out.println("Email Send :" + flag);
			// mDto = merchantService.doRegisterMerchant(userInfo, mDto);
			model.addAttribute("emailId", mDto.getEmailId());
			model.addAttribute("password", mDto.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "merchant/merchantRegSuccess";
	}

	public String generatePassword(boolean isLowerAlpha, boolean isUpperAlpha, boolean isDigits, boolean isSpclChars, Integer lengthOfPassword) {
		String[] sarr = { "abcdefghijkmnopqrstuvwxyz", "ABCDEFGHJKLMNPQRSTUVWXYZ", "23456789", "~!@#$%^&*_+-=?" };
		String s = new String();
		String pw = new String();
		s = ((isLowerAlpha) ? sarr[0] : "") + ((isUpperAlpha) ? sarr[1] : "") + ((isDigits) ? sarr[2] : "") + ((isSpclChars) ? sarr[3] : "");
		for (int i = 0; i < lengthOfPassword; i++) {
			pw += s.charAt((int) Math.floor(Math.random() * s.length()));
		}
		return pw;
	}

	/**
	 * @return the mDto
	 */
	public MerchantDTO getmDto() {
		return mDto;
	}

	/**
	 * @param mDto
	 *            the mDto to set
	 */
	public void setmDto(MerchantDTO mDto) {
		this.mDto = mDto;
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
