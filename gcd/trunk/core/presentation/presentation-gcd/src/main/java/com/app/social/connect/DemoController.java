package com.app.social.connect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping(value = "/dashboard")
	public String dashBoard() {
		return "homePage/dashboard";
	}
}
