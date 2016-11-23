package com.app.common.masterlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
@SessionAttributes({ "SESSION_ATTR_MASTER_LOGIN" })
public class MasterLogin extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private GetCityDealz getCityDealz;
	private UserInfo userInfo;

	@RequestMapping(value = "/masterLogin", method = RequestMethod.POST)
	@ResponseBody
	public UserInfo doLogin(Model model) throws Exception {
		if (userInfo == null)
			userInfo = new UserInfo();
		try {
			if (getRequestParam("userId") != null && !getRequestParam("userId").trim().isEmpty())
				userInfo.setUserId(getRequestParam("userId"));

			if (getRequestParam("password") != null && !getRequestParam("password").trim().isEmpty())
				userInfo.setPassword(getRequestParam("password"));

			userInfo = getCityDealz.adminDoLogin(userInfo);
			userInfo.setJsonMessage(null);
			if (userInfo != null && "1002".equals(userInfo.getUserType())) {
				model.addAttribute(AppWebConstant.SESSION_ATTR_MASTER_LOGIN, userInfo);
			}
		} catch (Exception e) {
			userInfo = new UserInfo();
			if (e instanceof BaseException) {
				e.printStackTrace();
				userInfo.setJsonMessage(((BaseException) e).getMsgCode());
			} else if (e instanceof BusinessException) {
				e.printStackTrace();
				userInfo.setJsonMessage(((BusinessException) e).getMessage());
			} else {
				e.printStackTrace();
				userInfo.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return userInfo;
	}

}
