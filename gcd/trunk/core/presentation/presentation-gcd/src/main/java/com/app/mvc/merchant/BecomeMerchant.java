package com.app.mvc.merchant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nl.captcha.Captcha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.common.interceptor.SupportClass;
import com.app.getcitydealz.dto.CategoryDTO;
import com.app.getcitydealz.dto.NeighborhoodDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.EmailUtility;

@Controller
public class BecomeMerchant extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private GetCityDealz getCityDealz;

	@RequestMapping(value = "/become-a-merchant")
	public ModelAndView display() {
		UserInfo userInfo = new UserInfo();
		ModelAndView mav = new ModelAndView("merchant/becomeMerchant");
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		try {
			mav.addObject("cityDTO", getCityDealz.getCityDetails(cityId));
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/sendBecomeMerchantRequest", method = RequestMethod.POST)
	@ResponseBody
	public UserInfo requestSend() {
		UserInfo userInfo = new UserInfo();
		try {
			Captcha captcha = (Captcha) getRequest().getSession().getAttribute(Captcha.NAME);
			String answer = getRequest().getParameter("answer");
			if (captcha.isCorrect(answer)) {
				String merchantEmailId = getRequestParam("emailId");
				List<String> mEmailId = Arrays.asList(merchantEmailId);
				List<String> recipients = Arrays.asList(AppPropertyBuilder.getProperty("mail.default.to", "01").split(","));

				Map<String, Object> holderMap = new HashMap<String, Object>();
				holderMap.put("BussinessName", getRequestParam("bussinessName"));
				holderMap.put("TypeOfBusiness", getRequestParam("typeOfBusiness"));
				holderMap.put("ContactName", getRequestParam("contactName"));
				holderMap.put("EmailId", getRequestParam("emailId"));
				holderMap.put("Phone", getRequestParam("phone"));
				EmailUtility.postMailType2("01", recipients, null, null, "Become a Merchant Sign Up: " + getRequestParam("bussinessName"), "becomeMerchant.vm",
						holderMap, 2);
				if (getRequestParam("sendToSender") != null && !getRequestParam("sendToSender").trim().isEmpty() && getRequestParam("sendToSender").equals("1"))
					EmailUtility.postMailType2("01", mEmailId, null, null, "Become a Merchant Sign Up: " + getRequestParam("bussinessName"),
							"becomeMerchant.vm", holderMap, 2);
				userInfo.setJsonMessage("Request send successfully...");
			} else {
				userInfo.setJsonMessage("Captcha is invalid.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfo;
	}
}
