package com.app.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.mvc.common.AppWebHandler;

@Controller
public class LogoutController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3494154156805253054L;

	@RequestMapping(value = "/appLogOut")
	public String getCityDealzLogOut() {
		if (getSession() != null)
			getSession().invalidate();
		return "homePage/homePage";
	}
}
