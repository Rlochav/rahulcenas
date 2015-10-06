package com.ceostocks.mvc.exceptionHandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceostocks.common.handler.CeoStocksWebHandler;

@Controller
@RequestMapping("/error")
public class ErrorController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2981340536724865127L;

	@RequestMapping(value = "/404")
	public String error404() {
		return "errorPages/defaultErrorPage";
	}
}
