package com.app.mvc.merchant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GMapDemo {

	@RequestMapping(value = "/gmapDemo")
	public String displayMap() {

		return "gmap/gmap";
	}
}
