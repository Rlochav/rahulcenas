package com.app.mvc.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.CategoryDTO;
import com.app.getcitydealz.dto.MerchantDTO;
import com.app.getcitydealz.dto.NeighborhoodDTO;
import com.app.getcitydealz.dto.SocialConnectionsDTO;
import com.app.getcitydealz.dto.SubscriptionDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebHandler;

@Controller
public class MerchantDealzSubscriber extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private GetCityDealz getCityDealz;
	@Autowired
	private MerchantService merchantService;

	@RequestMapping(value = "/subscribe/{merchantName}-{merchantId}")
	public ModelAndView display(@PathVariable String merchantId) {
		UserInfo userInfo = new UserInfo();
		ModelAndView mav = new ModelAndView("merchant/merchantDealSubscriber");
		try {

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			MerchantDTO merchantDTO = merchantService.getMerchantDetailById(merchantId, null);
			mav.addObject("merchantDTO", merchantDTO);

			SocialConnectionsDTO sDto = merchantService.getMySocialConnections(merchantId);
			mav.addObject("sDto", sDto);

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/subscribe/subscribeDealz")
	@ResponseBody
	public SubscriptionDTO subscribeDealz() {
		SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
		try {
			if (getRequestParam("firstName") != null && !getRequestParam("firstName").trim().isEmpty())
				subscriptionDTO.setFirstName(getRequestParam("firstName"));
			if (getRequestParam("lastName") != null && !getRequestParam("lastName").trim().isEmpty())
				subscriptionDTO.setLastName(getRequestParam("lastName"));
			if (getRequestParam("emailId") != null && !getRequestParam("emailId").trim().isEmpty())
				subscriptionDTO.setEmailId(getRequestParam("emailId"));
			if (getRequestParam("merchantId") != null && !getRequestParam("merchantId").trim().isEmpty())
				subscriptionDTO.setMerchantId(getRequestParam("merchantId"));
			subscriptionDTO = getCityDealz.subscribeDealz(subscriptionDTO);
		} catch (Exception e) {
			subscriptionDTO = new SubscriptionDTO();
			e.printStackTrace();
			if (e instanceof BaseException) {
				BaseException bEx = (BaseException) e;
				subscriptionDTO.setJsonMessage(bEx.getMsgCode());
			} else if (e.getCause() instanceof BusinessException) {
				BusinessException bEx = (BusinessException) e.getCause();
				subscriptionDTO.setJsonMessage(bEx.getMsgCode());
			} else {
				subscriptionDTO
						.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return subscriptionDTO;
	}
}
