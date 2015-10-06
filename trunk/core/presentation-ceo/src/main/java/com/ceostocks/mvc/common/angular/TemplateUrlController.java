package com.ceostocks.mvc.common.angular;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceostocks.common.handler.CeoStocksWebHandler;

@Controller
@RequestMapping("/component")
public class TemplateUrlController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2033925203382680122L;

	@RequestMapping("/postContent")
	public String postContentDisplay(ModelMap modelMap) {
		modelMap.addAttribute(USER_INFO, getSession().getAttribute(USER_INFO_SESSION));
		return "common/postContent";
	}

	@RequestMapping("/searchFriendTemplate")
	public String searchFriendTemplateDisplay() {
		return "common/searchFriendTemplate";
	}
}
