package com.app.mvc.merchant;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.mvc.common.AppWebHandler;

@Controller
public class MerchantHome extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7989577138049407556L;

	@RequestMapping(value = "/merchantHome", method = RequestMethod.GET)
	public String display(ModelMap map) {
		return "merchant/merchantHome";
	}

	@RequestMapping(value = "/basicInformation", method = RequestMethod.GET)
	public String basicInfoDisplay() {

		return "merchant/basicInformation";
	}

	@RequestMapping(value = "/billingInformation", method = RequestMethod.GET)
	public String billingInfoDisplay() {

		return "merchant/billingInfo";
	}

	@RequestMapping(value = "/documentManagement", method = RequestMethod.GET)
	public String documentManagementDisplay(ModelMap modelMap) {
		modelMap.put("docType", "2");
		return "documentManagement";
	}
}
