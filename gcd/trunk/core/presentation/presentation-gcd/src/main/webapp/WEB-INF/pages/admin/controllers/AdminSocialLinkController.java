package com.app.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.SocialConnectionsDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
public class AdminSocialLinkController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	public GetCityDealz getCityDealz;

	@RequestMapping(value = "/component/socialLinks")
	public ModelAndView display(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/adminsociallinks");
		try {
			SocialConnectionsDTO connectionsDTO = getCityDealz.getAdminSConnDetails(userInfo);
			if (connectionsDTO != null)
				modelMap.put("conn", connectionsDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/jsonSaveSConnDetails")
	@ResponseBody
	public SocialConnectionsDTO saveSConnDetail() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		SocialConnectionsDTO connectionsDTO = new SocialConnectionsDTO();
		try {
			if (getRequestParam("sConnId") != null && !getRequestParam("sConnId").trim().isEmpty())
				connectionsDTO.setConnectionId((getRequestParam("sConnId")));

			if (getRequestParam("fbFanPage") != null && !getRequestParam("fbFanPage").trim().isEmpty())
				connectionsDTO.setFacebookFanPage((getRequestParam("fbFanPage")));

			if (getRequestParam("twtId") != null && !getRequestParam("twtId").trim().isEmpty())
				connectionsDTO.setTwitterAccount((getRequestParam("twtId")));

			if (getRequestParam("consumerKey") != null && !getRequestParam("consumerKey").trim().isEmpty())
				connectionsDTO.setConsumerKey((getRequestParam("consumerKey")));

			if (getRequestParam("consumerSecret") != null && !getRequestParam("consumerSecret").trim().isEmpty())
				connectionsDTO.setConsumerSecret((getRequestParam("consumerSecret")));

			if (getRequestParam("oAuthToken") != null && !getRequestParam("oAuthToken").trim().isEmpty())
				connectionsDTO.setoAuthToken((getRequestParam("oAuthToken")));

			if (getRequestParam("oAuthSecret") != null && !getRequestParam("oAuthSecret").trim().isEmpty())
				connectionsDTO.setoAuthSecret((getRequestParam("oAuthSecret")));

			String flag = getRequestParam("flag");
			connectionsDTO = getCityDealz.saveSConnDetails(userInfo, connectionsDTO, flag);
		} catch (Exception e) {
			connectionsDTO = new SocialConnectionsDTO();
			e.printStackTrace();
			if (e instanceof BaseException) {
				BaseException bEx = (BaseException) e;
				connectionsDTO.setJsonMessage(bEx.getMsgCode());
			} else if (e.getCause() instanceof BusinessException) {
				BusinessException bEx = (BusinessException) e.getCause();
				connectionsDTO.setJsonMessage(bEx.getMsgCode());
			} else {
				connectionsDTO
						.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return connectionsDTO;
	}

}
