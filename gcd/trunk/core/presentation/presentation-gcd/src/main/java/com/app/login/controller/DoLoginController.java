package com.app.login.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.common.interceptor.SupportClass;
import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.CategoryDTO;
import com.app.getcitydealz.dto.NeighborhoodDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.model.getcitydealz.MerchantMaster;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.service.login.Login;

@Controller
@SessionAttributes({ "SESSION_ATTR_USER_INFO" })
public class DoLoginController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 34882053883659449L;
	@Autowired
	private Login loginService;
	private UserInfo userInfo;

	@Autowired
	private GetCityDealz getCityDealz;

	@RequestMapping(value = "/doLogin")
	public String doLogin(@Valid MerchantMaster merchantMaster, BindingResult bindingResult, ModelMap model) throws Exception {
		try {
			if (bindingResult.hasErrors()) {
				return "homePage/cityHomePage";
			}
			String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
						
			userInfo = new UserInfo();
			userInfo.setUserId(merchantMaster.getUserId());
			userInfo.setPassword(merchantMaster.getPassword());
			userInfo.setCityId(cityId);
			userInfo = loginService.doLogin(userInfo);
			if (userInfo != null) {
				model.addAttribute(AppWebConstant.SESSION_ATTR_USER_INFO, userInfo);
				return "redirect:/merchantDashboard";
			}
		} catch (Exception e) {
			if (e instanceof BaseException) {
				e.printStackTrace();
				bindingResult.rejectValue("userId", ((BaseException) e).getMsgCode());
			} else if (e instanceof BusinessException) {
				e.printStackTrace();
				bindingResult.rejectValue("userId", ((BaseException) e).getMsgCode());
			} else {
				e.printStackTrace();
				bindingResult.rejectValue("userId", "common.msg.000000");
			}
		} finally {
			try {
				NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
				if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
					model.put("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());

				CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
				if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
					model.put("categoryDTO", categoryDTO.getCategoryDTOs());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return "homePage/cityHomePage";
	}

	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/**
	 * @param userInfo
	 *            the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}
