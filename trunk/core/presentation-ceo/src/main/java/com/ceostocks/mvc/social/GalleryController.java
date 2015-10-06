package com.ceostocks.mvc.social;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
@RequestMapping("/component/gallery/")
public class GalleryController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8359878533051476052L;

	@RequestMapping(value = CeoUrls.CEO_ROOT)
	public String display(ModelMap modelMap) {
		modelMap.addAttribute(USER_INFO, getSession().getAttribute(USER_INFO_SESSION));
		return "user/gallery/userGallery";
	}
}
