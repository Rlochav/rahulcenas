package com.app.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.SubscriptionLevelDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
public class SubscriptionLevelController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	public GetCityDealz getCityDealz;

	@RequestMapping(value = "/component/subscriptionLevel")
	public ModelAndView display() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/subscriptionLevel");
		try {
			SubscriptionLevelDTO levelDTO = getCityDealz.getAllLevelDetails(userInfo);
			if (levelDTO != null)
				mav.addObject("levels", levelDTO.getSubscriptionLevelDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/editsubscriptionLevel")
	public ModelAndView editSubscriptionDisplay() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/editsubscriptionLevel");
		String btnName = "Add New";
		try {
			if (getRequestParam("subsId") != null && !getRequestParam("subsId").trim().isEmpty()) {
				SubscriptionLevelDTO levelDTO = getCityDealz.getLevelDetailsById(userInfo, getRequestParam("subsId"));
				btnName = "Update";
				if (levelDTO != null)
					mav.addObject("levels", levelDTO);
			}
			mav.addObject("btnName", btnName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/jsonSaveSubscriptionDetails")
	@ResponseBody
	public SubscriptionLevelDTO saveSubscriptionLevelDetails() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		SubscriptionLevelDTO levelDTO = new SubscriptionLevelDTO();
		try {
			if (getRequestParam("levelId") != null && !getRequestParam("levelId").trim().isEmpty())
				levelDTO.setLevelId((getRequestParam("levelId")));

			if (getRequestParam("levelName") != null && !getRequestParam("levelName").trim().isEmpty())
				levelDTO.setLevelName((getRequestParam("levelName")));

			if (getRequestParam("levelFullYearPrice") != null && !getRequestParam("levelFullYearPrice").trim().isEmpty())
				levelDTO.setLevelFullYearPrice((getRequestParam("levelFullYearPrice")));

			if (getRequestParam("quarterPaymentPrice") != null && !getRequestParam("quarterPaymentPrice").trim().isEmpty())
				levelDTO.setQuarterPaymentPrice((getRequestParam("quarterPaymentPrice")));

			levelDTO = getCityDealz.saveSubscriptionLevelDetails(userInfo, levelDTO);
		} catch (Exception e) {
			levelDTO = new SubscriptionLevelDTO();
			e.printStackTrace();
			if (e instanceof BaseException) {
				BaseException bEx = (BaseException) e;
				levelDTO.setJsonMessage(bEx.getMsgCode());
			} else if (e.getCause() instanceof BusinessException) {
				BusinessException bEx = (BusinessException) e.getCause();
				levelDTO.setJsonMessage(bEx.getMsgCode());
			} else {
				levelDTO.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return levelDTO;
	}
}
