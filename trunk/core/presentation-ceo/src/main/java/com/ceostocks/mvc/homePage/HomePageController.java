package com.ceostocks.mvc.homePage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
public class HomePageController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4289688951181443568L;

	@RequestMapping(value = CeoUrls.CEO_INDEX)
	public String displayHomePage() {
		return "homePage/homePage";
	}
}
