package com.app.scheduler.subscription;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.common.interceptor.SupportClass;
import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.deal.dto.DealzDTO;
import com.app.getcitydealz.dto.CategoryDTO;
import com.app.getcitydealz.dto.NeighborhoodDTO;
import com.app.getcitydealz.dto.SubscriptionDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.social.dto.SocialProfileDTO;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.EmailUtility;

@Controller
public class DealzSubscriptionController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private GetCityDealz getCityDealz;
	@Autowired
	private MerchantService merchantService;

	@RequestMapping(value = "/subscribe")
	public ModelAndView display() {
		UserInfo userInfo = new UserInfo();
		ModelAndView mav = new ModelAndView("subscription/scubscritpion");
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		SocialProfileDTO dto = (SocialProfileDTO) getSessionAttribute("socialProfileDTO");

		mav.addObject("fName", dto != null ? dto.getFirstName() : getRequestParam("fName"));
		mav.addObject("lName", dto != null ? dto.getLastName() : getRequestParam("lName"));
		mav.addObject("email", dto != null ? dto.getEmailId() : getRequestParam("email"));
		try {
			mav.addObject("cityDTO", getCityDealz.getCityDetails(cityId));
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			List<CategoryDTO> subscriptionCtg = getCityDealz.getListOfCategoryNneighborhoods(userInfo);
			if (subscriptionCtg != null)
				mav.addObject("subscriptionCtg", subscriptionCtg);

			DealzDTO dealzDTO = getCityDealz.getAllDealsByMasterCategory(userInfo, "Dining");
			if (dealzDTO != null && dealzDTO.getDealzDTOs() != null)
				mav.addObject("deals", dealzDTO.getDealzDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/jsonSubscribeDeails", method = RequestMethod.POST)
	@ResponseBody
	public String subscribeMe() {
		UserInfo userInfo = new UserInfo();
		String message = null;
		try {
			SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
			if (getRequestParam("firstName") != null && !getRequestParam("firstName").trim().isEmpty())
				subscriptionDTO.setFirstName(getRequestParam("firstName"));
			if (getRequestParam("lastName") != null && !getRequestParam("lastName").trim().isEmpty())
				subscriptionDTO.setLastName(getRequestParam("lastName"));
			if (getRequestParam("emailId") != null && !getRequestParam("emailId").trim().isEmpty())
				subscriptionDTO.setEmailId(getRequestParam("emailId"));
			if (getRequestParam("subscriptionType") != null && !getRequestParam("subscriptionType").trim().isEmpty())
				subscriptionDTO.setSubscriptionType(getRequestParam("subscriptionType"));

			String[] categories = null;
			if (getRequestParam("cRows") != null && !getRequestParam("cRows").trim().isEmpty())
				categories = getRequestParam("cRows").split(",");

			String[] neighborhood = null;
			if (getRequestParam("nRows") != null && !getRequestParam("nRows").trim().isEmpty())
				neighborhood = getRequestParam("nRows").split(",");

			String s = getCityDealz.subscribeDealz(userInfo, subscriptionDTO, categories, neighborhood);

		} catch (Exception e) {
			if (e instanceof BaseException) {
				e.printStackTrace();
				message = ((BaseException) e).getMsgCode();
			} else if (e instanceof BusinessException) {
				e.printStackTrace();
				message = ((BusinessException) e).getMessage();
			} else {
				e.printStackTrace();
				message = "Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator";
			}
		}
		return message;
	}

	@RequestMapping(value = "/emailUnsubscriber/jsonUnsubscribedDealz")
	@Async
	public ModelAndView unSubscribedEmail(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("unsubscribed");
		try {
			String subscriptionId = getRequestParam("sId");
			String s = merchantService.unSubscribedEmailById(subscriptionId);
			if (s.equalsIgnoreCase("success"))
				modelMap.put("message", "Congratulations! you have unsubscribed deals");

			HttpSession hs = getRequest().getSession(true);
			hs.setAttribute((AppWebConstant.SESSION_ATTR_MASTER_LOGIN), new UserInfo());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
