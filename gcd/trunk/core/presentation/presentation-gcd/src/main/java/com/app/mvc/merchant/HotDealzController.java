package com.app.mvc.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.deal.dto.DealzDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
public class HotDealzController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public MerchantService merchantService;

	@RequestMapping(value = "/allHotDealz")
	public String displayMyHotDealz(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		if (userInfo != null && "1001".equals(userInfo.getUserType())) {
			return "../../WelcomePage";
		}
		try {
			String dealType = getRequestParam("dealType");
			modelMap.put("dealType", dealType);
			modelMap.put("error", getRequestParam("error"));
			DealzDTO dealzDTO = merchantService.getMyAllHotDealz(userInfo, dealType);
			modelMap.put("dealzDTO", dealzDTO.getDealzDTOs());		
			if("1".equals(dealType))
				modelMap.put("headerMsg", "YOUR DEALZ");
			else
				modelMap.put("headerMsg", "YOUR HOT DEALS");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "merchant/allHotDealz";
	}
}
