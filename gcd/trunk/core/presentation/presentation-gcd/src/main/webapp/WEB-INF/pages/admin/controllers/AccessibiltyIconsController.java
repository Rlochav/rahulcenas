package com.app.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.IconsDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
public class AccessibiltyIconsController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	public GetCityDealz getCityDealz;

	@RequestMapping(value = "/component/icons")
	public ModelAndView display() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/accessibiltyIcons");
		try {
			IconsDTO iconsDTO = getCityDealz.getAllIconsDetails(userInfo);
			if (iconsDTO != null)
				mav.addObject("icons", iconsDTO.getIconsDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/editicons")
	public ModelAndView editModedisplay() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/editaccessibiltyIcons");
		String btnName = "Add New";
		try {
			if (getRequestParam("iconId") != null && !getRequestParam("iconId").trim().isEmpty()) {
				IconsDTO iconsDTO = getCityDealz.getIconsDetailsById(userInfo, getRequestParam("iconId"));
				btnName = "Update";
				if (iconsDTO != null)
					mav.addObject("icons", iconsDTO);
			}
			mav.addObject("btnName", btnName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/jsonSaveIconDetails")
	@ResponseBody
	public IconsDTO saveIconDetails() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		IconsDTO iconsDTO = new IconsDTO();
		try {
			if (getRequestParam("iconId") != null && !getRequestParam("iconId").trim().isEmpty())
				iconsDTO.setIconId(getRequestParam("iconId"));
			if (getRequestParam("iconName") != null && !getRequestParam("iconName").trim().isEmpty())
				iconsDTO.setIconName(getRequestParam("iconName"));
			if (getRequestParam("iconUrl") != null && !getRequestParam("iconUrl").trim().isEmpty())
				iconsDTO.setIconUrl(getRequestParam("iconUrl"));

			iconsDTO = getCityDealz.saveIconsDetails(userInfo, iconsDTO);
		} catch (Exception e) {
			iconsDTO = new IconsDTO();
			e.printStackTrace();
			if (e instanceof BaseException) {
				BaseException bEx = (BaseException) e;
				iconsDTO.setJsonMessage(bEx.getMsgCode());
			} else if (e.getCause() instanceof BusinessException) {
				BusinessException bEx = (BusinessException) e.getCause();
				iconsDTO.setJsonMessage(bEx.getMsgCode());
			} else {
				iconsDTO.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return iconsDTO;
	}
}
