package com.ceostocks.mvc.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
@RequestMapping("/component/")
public class ProductManagementController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1668476949657766181L;

	@RequestMapping(value = CeoUrls.CEO_OPEN_PRODUCT_MANAGEMENT)
	public ModelAndView displayProductManagement() {

		return new ModelAndView("product/productManagement");
	}

	@RequestMapping(value = CeoUrls.CEO_SAVE_PRODUCT, method = RequestMethod.POST)
	@ResponseBody
	public void saveProduct() {
		
	}

	@RequestMapping(value = CeoUrls.CEO_DELETE_PRODUCT, method = RequestMethod.DELETE)
	public void deleteProduct() {

	}
}
