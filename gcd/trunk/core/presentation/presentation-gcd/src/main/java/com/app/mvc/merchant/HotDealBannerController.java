package com.app.mvc.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.getcitydealz.dto.HotDealBannerDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
public class HotDealBannerController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -233649581400190973L;

	@Autowired
	private MerchantService merchantService;

	@RequestMapping(value = "/jsonGetHotDealz")
	@ResponseBody
	public HotDealBannerDTO getHotDealDetails() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		HotDealBannerDTO bannerDTO = null;
		try {
			bannerDTO = merchantService.getHotDealDetails(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bannerDTO;
	}
}
