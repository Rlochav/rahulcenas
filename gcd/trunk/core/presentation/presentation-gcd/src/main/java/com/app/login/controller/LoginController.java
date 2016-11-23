package com.app.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.mvc.common.AppWebHandler;

@Controller
public class LoginController extends AppWebHandler {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5244095521897790909L;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String display() {
		return "homePage/login";
	}

}
