package com.ceostocks.mvc.social;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
@RequestMapping("/component/about-us/")
public class AboutUsController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2370492091592310694L;

	@RequestMapping(value = CeoUrls.CEO_ROOT)
	public String display(ModelMap modelMap) {
		modelMap.addAttribute(USER_INFO, getSession().getAttribute(USER_INFO_SESSION));
		return "aboutUs/about";
	}
}
