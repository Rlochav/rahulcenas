package com.app.admin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
public class AdminUserController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3007292007028449289L;

	@Autowired
	private GetCityDealz getCityDealz;

	@RequestMapping("/component/adminUsers")
	public String displayAdminProfiles(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			List<UserInfo> userInfos = getCityDealz.getUserMasters(userInfo);
			modelMap.put("usermasters", userInfos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/adminUsers";
	}

	@RequestMapping("/component/editAdminDetails")
	public String userDetailsById(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			String btnName = "Add";
			UserInfo info = getCityDealz.getAdminDetailsById(getRequestParam("userId"));
			if (info != null)
				btnName = "Edit";
			else {
				info = new UserInfo();
			}
			modelMap.put("btnName", btnName);
			modelMap.put("usermasters", info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/editAdminDetails";
	}

	@RequestMapping("/component/saveAdminDetails")
	public String saveAdminDetails(@ModelAttribute("usermaster") UserInfo usermaster, RedirectAttributes redirectAttributes) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			usermaster = getCityDealz.saveAdminDetails(usermaster);
			redirectAttributes.addFlashAttribute("message", "Details Updated Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/component/adminUsers";
	}

	@RequestMapping("/component/validateAdminUserIdEmailId")
	@ResponseBody
	public String validateAdminUserIdEmailId() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		String message = null;
		try {
			message = getCityDealz.validateAdminUserIdEmailId(getRequestParam("userId"), getRequestParam("emailId"), getRequestParam("userIndex"));
		} catch (Exception e) {
			if (e instanceof BaseException) {
				e.printStackTrace();
				return ((BaseException) e).getMsgCode();
			} else if (e instanceof BusinessException) {
				e.printStackTrace();
				return ((BaseException) e).getMsgCode();
			} else {
				e.printStackTrace();
				return "";
			}
		}
		return message;
	}
}
