package com.ceostocks.mvc.homePage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceostocks.application.user.UserApplication;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
@RequestMapping("/component/")
public class UserHomePageController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4582908606036066666L;
	@Autowired
	private UserApplication userApplication;

	@RequestMapping(value = CeoUrls.CEO_HOME)
	public String displayHomePage(ModelMap modelMap) {
		modelMap.addAttribute(USER_INFO, getSession().getAttribute(USER_INFO_SESSION));
		return "user/userHomePage";
	}

}
