package com.app.social.connect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.app.getcitydealz.service.GetCityDealz;
import com.app.mvc.common.AppWebHandler;
import com.app.social.dto.SocialProfileDTO;

@Controller
@SessionAttributes({ "socialProfileDTO" })
public class SocialLoginController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5753929561388352694L;
	@Autowired
	private GetCityDealz getCityDealz;

	@RequestMapping("/socialDetailsConsumer")
	@ResponseBody
	public SocialProfileDTO holdDetails(ModelMap modelMap) {
		try {
			SocialProfileDTO dto = new SocialProfileDTO();
			dto.setEmailId(getRequestParam("emailId"));
			dto.setFirstName(getRequestParam("fName"));
			dto.setLastName(getRequestParam("lName"));
			dto.setAccount(getRequestParam("account"));
			dto = getCityDealz.saveSocialDetails(dto);
			modelMap.addAttribute("socialProfileDTO", dto);
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
