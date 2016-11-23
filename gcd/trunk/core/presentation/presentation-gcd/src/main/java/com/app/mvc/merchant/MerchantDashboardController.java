package com.app.mvc.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.deal.dto.DealzDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
public class MerchantDashboardController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2940423130902235016L;
	@Autowired
	private MerchantService merchantService;

	@RequestMapping(value = "/merchantDashboard", method = RequestMethod.GET)
	public String merchantDashboardDisplay(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			if (userInfo != null && "1001".equals(userInfo.getUserType())) {
				return "../../WelcomePage";
			}

			DealzDTO heigestRatedDEalz = merchantService.getHighestRatedDealz(userInfo);
			if (heigestRatedDEalz == null || heigestRatedDEalz.getDealzDTOs() == null || heigestRatedDEalz.getDealzDTOs().size() == 0) {
				modelMap.put("heigestRatedDEalz", null);
			} else {
				modelMap.put("heigestRatedDEalz", heigestRatedDEalz.getDealzDTOs());
			}
			com.app.deal.dto.DealzDTO dealzDTO = merchantService.getMyLatestDeal(userInfo.getUserIndex());
			if (dealzDTO == null || dealzDTO.getDealzDTOs() == null || dealzDTO.getDealzDTOs().size() == 0) {
				modelMap.put("latestDeals", null);
			} else {
				modelMap.put("latestDeals", dealzDTO.getDealzDTOs());
			}
			modelMap.put("embbeds", merchantService.getMerchantEmbeds(userInfo.getUserIndex()));
			modelMap.put("socialConnection", merchantService.getMySocialConnection(userInfo));
			modelMap.put("mediaList", merchantService.getMediaFiles(userInfo));
			modelMap.put("merchantDTO", merchantService.getMerchantDetailById(userInfo.getUserIndex() + "", null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "merchant/merchantDashboard";
	}
}
