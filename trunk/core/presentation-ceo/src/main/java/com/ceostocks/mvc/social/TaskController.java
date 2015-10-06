package com.ceostocks.mvc.social;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
@RequestMapping("/component/task/")
public class TaskController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6640711548254675052L;

	@RequestMapping(value = CeoUrls.CEO_ROOT)
	public String display() {
		return "user/task/userTask";
	}
}
