package com.app.mvc.merchant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.deal.dto.DealzDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
public class LoadMerchantDealz extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1414519325878422866L;
	@Autowired
	private GetCityDealz getCityDealz;

	@RequestMapping(value = "/loadAllDealz")
	public String getAllDealz(ModelMap map) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		if (userInfo != null && "1001".equals(userInfo.getUserType())) {
			return "../../WelcomePage";
		}
		try {
			if (userInfo == null)
				userInfo = new UserInfo();
			String upcoming = getRequestParam("upcoming");
			List<DealzDTO> dealzDTOs = getCityDealz.getAllDealz(userInfo, null, upcoming, "0");
			if (dealzDTOs != null)
				map.put("dealzs", dealzDTOs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "merchant/dealz";
	}
}
