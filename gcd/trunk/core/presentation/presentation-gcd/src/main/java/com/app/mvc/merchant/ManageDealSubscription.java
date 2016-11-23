package com.app.mvc.merchant;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.mvc.common.AppWebHandler;

public class ManageDealSubscription extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8519361895050219545L;

	@RequestMapping(value = "/manageDealzSubscription")
	public ModelAndView display() {
		ModelAndView mav = new ModelAndView("merchant/manageDealzSubscription");
		return mav;
	}
}
