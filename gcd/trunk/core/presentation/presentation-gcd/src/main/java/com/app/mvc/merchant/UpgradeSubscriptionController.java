package com.app.mvc.merchant;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.common.dto.CommonFormDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
public class UpgradeSubscriptionController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4642146472517927316L;

	@Autowired
	private MerchantService merchantService;

	@RequestMapping(value = "/manageGcdSubscription", method = RequestMethod.GET)
	public ModelAndView manageGcdSubscriptionDisplay() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("merchant/manageGcdSubscription");
		try {
			CommonFormDTO formDTO = new CommonFormDTO();
			String levelId = merchantService.getMyLevel(userInfo);
			Map<String, String> levelMap = merchantService.getSubscriptionLevel(userInfo);
			mav.addObject("levelId", levelId);
			mav.addObject("levelMap", levelMap);
			mav.addObject("chooseLevelForm", formDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/jsonUpgradeSubscription")
	@ResponseBody
	public String upgradeSubscription() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		String response = null;
		try {
			String currentLevel = getRequestParam("currentLevel");
			String changedLevel = getRequestParam("changedLevel");
			response = merchantService.updateMerchantLevel(userInfo, currentLevel, changedLevel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
