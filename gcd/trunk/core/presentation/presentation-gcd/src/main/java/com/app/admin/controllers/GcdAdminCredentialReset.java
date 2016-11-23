package com.app.admin.controllers;

import static org.springframework.util.StringUtils.isEmpty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.common.interceptor.SupportClass;
import com.app.commonexception.BaseException;
import com.app.getcitydealz.dto.CategoryDTO;
import com.app.getcitydealz.dto.MerchantDTO;
import com.app.getcitydealz.dto.NeighborhoodDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.model.user.UserMaster;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.EmailUtility;

@Controller
@RequestMapping("/admin")
public class GcdAdminCredentialReset extends AppWebHandler {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1840136174660348324L;
	@Autowired
	private GetCityDealz getCityDealz;
	@Autowired
	private MerchantService merchantService;
	private String jsonMesage;

	@RequestMapping("/reset")
	public ModelAndView displayFGTPwd(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("admin/resetCredential");
		UserInfo userInfo = new UserInfo();
		String query = getRequestParam("query");
		if (query == null || !"password".equals(query))
			return new ModelAndView("redirect:/merchant-signin");

		modelMap.addAttribute("formAction", "resetPasword");
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		UserMaster userMaster = new UserMaster();
		modelMap.put("userMaster", userMaster);
		try {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());
			mav.addObject("query", query);

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/remind")
	public ModelAndView displayFGTUserId(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("admin/resetCredential");
		UserInfo userInfo = new UserInfo();
		String query = getRequestParam("query");
		if (query == null || !"username".equals(query))
			return new ModelAndView("redirect:/merchant-signin");

		modelMap.addAttribute("formAction", "resetUserName");
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		UserMaster userMaster = new UserMaster();
		modelMap.put("userMaster", userMaster);
		try {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());
			mav.addObject("query", query);
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/resetUserName")
	public String remind(UserMaster userMaster, BindingResult bindingResult, ModelMap model, RedirectAttributes redirectAttributes) throws BaseException {
		UserInfo userInfo = new UserInfo();
		try {
			if (isEmpty(userMaster.getEmailId())) {
				redirectAttributes.addFlashAttribute("query", getRequestParam("query"));
				bindingResult.rejectValue("emailId", "common.msg.000002");
				return "admin/resetCredential";
			}
			String subject = "";
			String template = null;
			MerchantDTO dto = merchantService.getAdminDetailsByEmailId(userMaster.getEmailId());
			if (dto == null) {
				redirectAttributes.addFlashAttribute("query", getRequestParam("query"));
				bindingResult.rejectValue("emailId", "common.msg.000004");
				return "admin/resetCredential";
			}
			List<String> mEmailId = Arrays.asList(getRequestParam("emailId"));
			Map<String, Object> holderMap = new HashMap<String, Object>();
			holderMap.put("userid", dto.getUserId());
			holderMap.put("urls", dto.getLoginUrl());
			subject = "Your GetCityDealz username";
			template = "usernameTemplate.vm";

			if (holderMap.size() > 0) {
				EmailUtility.postMailType2("01", mEmailId, null, null, subject, template, holderMap, 3);
				bindingResult.rejectValue("emailId", "common.msg.000003");
				redirectAttributes.addFlashAttribute("query", getRequestParam("query"));
				return "admin/resetCredential";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			model.addAttribute("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				model.addAttribute("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				model.addAttribute("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		}
		return "admin/resetCredential";
	}

	@RequestMapping(value = "/resetPasword")
	public String resetPasword(UserMaster userMaster, BindingResult bindingResult, ModelMap model, RedirectAttributes redirectAttributes) throws BaseException {
		UserInfo userInfo = new UserInfo();
		try {
			if (isEmpty(userMaster.getEmailId())) {
				redirectAttributes.addFlashAttribute("query", getRequestParam("query"));
				bindingResult.rejectValue("emailId", "common.msg.000002");
				return "admin/resetCredential";
			}
			String subject = "";
			String template = null;
			MerchantDTO dto = merchantService.getAdminDetailsByEmailId(userMaster.getEmailId());
			if (dto == null) {
				redirectAttributes.addFlashAttribute("query", getRequestParam("query"));
				bindingResult.rejectValue("emailId", "common.msg.000004");
				return "admin/resetCredential";
			}
			List<String> mEmailId = Arrays.asList(getRequestParam("emailId"));
			Map<String, Object> holderMap = new HashMap<String, Object>();

			holderMap.put("password", dto.getPassword());
			holderMap.put("urls", dto.getLoginUrl());
			subject = "Your GetCityDealz password reset request";
			template = "credentialToken.vm";

			if (holderMap.size() > 0) {
				EmailUtility.postMailType2("01", mEmailId, null, null, subject, template, holderMap, 3);
				bindingResult.rejectValue("emailId", "common.msg.000003");
				redirectAttributes.addFlashAttribute("query", getRequestParam("query"));
				return "admin/resetCredential";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			model.addAttribute("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				model.addAttribute("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				model.addAttribute("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		}
		return "admin/resetCredential";
	}

	/**
	 * @return the jsonMesage
	 */
	public String getJsonMesage() {
		return jsonMesage;
	}

	/**
	 * @param jsonMesage
	 *            the jsonMesage to set
	 */
	public void setJsonMesage(String jsonMesage) {
		this.jsonMesage = jsonMesage;
	}
}
