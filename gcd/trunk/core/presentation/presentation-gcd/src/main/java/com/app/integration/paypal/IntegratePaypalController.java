package com.app.integration.paypal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.mvc.common.AppWebHandler;

@Controller
public class IntegratePaypalController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@RequestMapping(value = "/purchaseLevel")
	public String display() {

		return "paymentgetway/paypalpay";
	}
}
