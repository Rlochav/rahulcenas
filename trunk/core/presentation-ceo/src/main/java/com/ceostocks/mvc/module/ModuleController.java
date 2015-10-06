package com.ceostocks.mvc.module;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
public class ModuleController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8620162501433148655L;

	@RequestMapping(value = CeoUrls.CEO_SITE_ADMIN)
	public ModelAndView displaySiteAdmin() {

		return new ModelAndView("siteAdmin/siteAdmin");
	}
}
