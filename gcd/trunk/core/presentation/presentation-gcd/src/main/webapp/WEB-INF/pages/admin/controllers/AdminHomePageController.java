package com.app.admin.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.app.common.dto.CommonFormDTO;
import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.CategoryDTO;
import com.app.getcitydealz.dto.NeighborhoodDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
@SessionAttributes({ "SESSION_ATTR_USER_INFO" })
public class AdminHomePageController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private GetCityDealz getCityDealz;
	private UserInfo userInfo;

	@RequestMapping(value = "/admin")
	public ModelAndView adminHomePageDisplay(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("admin/adminHomePage");
		try {
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelMap.put("message", getRequestParam("message"));
		return mav;
	}

	@RequestMapping(value = "/adminDoLogin")
	public String adminDoLogin(ModelMap model) {
		if (userInfo == null)
			userInfo = new UserInfo();
		try {
			if (getRequestParam("userId") != null && !getRequestParam("userId").trim().isEmpty())
				userInfo.setUserId(getRequestParam("userId"));

			if (getRequestParam("password") != null && !getRequestParam("password").trim().isEmpty())
				userInfo.setPassword(getRequestParam("password"));

			userInfo.setIpAddress(getClientIpAddr(getRequest()));
			userInfo = getCityDealz.adminDoLogin(userInfo);
			if (userInfo != null)
				model.put(AppWebConstant.SESSION_ATTR_USER_INFO, userInfo);
			return "redirect:/component/adminDashboard";
		} catch (Exception e) {
			if (e instanceof BaseException) {
				e.printStackTrace();
				model.put("message", ((BaseException) e).getMsgCode());
			} else if (e instanceof BusinessException) {
				e.printStackTrace();
				model.put("message", (((BusinessException) e).getMessage()));
			} else {
				e.printStackTrace();
				model.put("message",
						"Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return "redirect:/admin";
	}

	@RequestMapping(value = "/component/adminDashboard")
	public ModelAndView adminDashboardDisplay() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		CommonFormDTO formDTO = new CommonFormDTO();
		ModelAndView mav = new ModelAndView("admin/adminDashboard");
		Map<String, String> cityMap = null;
		try {
			cityMap = getCityDealz.getCityMap(userInfo);
			mav.addObject("cityMap", cityMap);
			mav.addObject("chooseCityForm", formDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cityMap == null)
				cityMap = new HashMap<String, String>();
		}
		return mav;
	}

	@RequestMapping(value = "/component/merchantmgmt")
	public String merchantManagementDisplay(@ModelAttribute("chooseCityForm") CommonFormDTO formDTO, ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		modelMap.put("message", getRequestParam("message"));
		if (formDTO.getPath1() != null && formDTO.getPath1().trim().equals("-1"))
			return "redirect:/component/adminDashboard";
		if (formDTO.getPath1() != null) {
			try {
				userInfo.setCityId(formDTO.getPath1());
				userInfo.setCityText(getCityDealz.getCityText(formDTO.getPath1()));
			} catch (BaseException e) {
				e.printStackTrace();
			}
		}
		return "admin/merchantManagement/merchantMgmt";
	}

	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo
	 *            the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	private static String getClientIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip + (request.getRemoteHost() == null ? "" : "/" + request.getRemoteHost());
	}
}
