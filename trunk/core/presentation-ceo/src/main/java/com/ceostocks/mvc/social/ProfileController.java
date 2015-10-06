package com.ceostocks.mvc.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceostocks.application.user.UserApplication;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
@RequestMapping("/component/profile/")
public class ProfileController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5583699429290627625L;
	@Autowired
	private UserApplication userApplication;

	@RequestMapping(value = CeoUrls.CEO_USER_PROFILE)
	public String display(@PathVariable String timelineId, ModelMap modelMap) {
		modelMap.addAttribute(USER_INFO, getSession().getAttribute(USER_INFO_SESSION));
		try {
			modelMap.addAttribute(PROFILE_INFO, userApplication.getUserDetailsByTimelineId(timelineId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "user/profile/userProfile";
	}
}
