package com.app.admin.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.LocationDTO;
import com.app.getcitydealz.dto.MerchantDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.IntUtil;

@Controller
public class AdminManageLocation extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8542748160880759433L;
	@Autowired
	private MerchantService merchantService;

	@Autowired
	private GetCityDealz getCityDealz;

	private LocationDTO locationDTO;

	@RequestMapping(value = "/component/manageMerchantLocation")
	public ModelAndView display(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/merchantManagement/mMgmtManageLocation");
		try {
			MerchantDTO merchantDTO = merchantService.getMerchantDetailById(getRequestParam("merchantId"), null);
			modelMap.addAttribute("merchantDTO", merchantDTO);
			List<LocationDTO> locationDTOs = merchantDTO.getLocationDTOs();
			if (locationDTOs != null) {
				if (locationDTOs.size() > 0)
					modelMap.addAttribute("locationDTO1", locationDTOs.get(0));
				else
					modelMap.addAttribute("locationDTO1", new LocationDTO());
				if (locationDTOs.size() > 1)
					modelMap.addAttribute("locationDTO2", locationDTOs.get(1));
				else
					modelMap.addAttribute("locationDTO2", new LocationDTO());
				if (locationDTOs.size() > 2)
					modelMap.addAttribute("locationDTO3", locationDTOs.get(2));
				else
					modelMap.addAttribute("locationDTO3", new LocationDTO());

				modelMap.addAttribute("merchantId", getRequestParam("merchantId"));
			}
		} catch (Exception e) {
			locationDTO = new LocationDTO();
			if (e instanceof BaseException)
				locationDTO.setJsonMessage(((BaseException) e).getMsgCode());
			else if (e instanceof BusinessException)
				locationDTO.setJsonMessage(((BusinessException) e).getMessage());
			else
				locationDTO
						.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
		}
		return mav;
	}

	@RequestMapping(value = "/component/editManageLocation", method = RequestMethod.GET)
	public ModelAndView editAdditionalLocationDisplay(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/merchantManagement/mMgmtEditManageLocation");
		Map<String, String> cityMap = null;
		Map<String, String> stateMap = null;
		Map<String, String> neighborhoodMap = null;
		try {
			UserInfo mInfo = new UserInfo();
			mInfo.setUserIndex(IntUtil.getInteger(getRequestParam("merchantId")));
			neighborhoodMap = merchantService.getNeighborhoodMap(userInfo);
			mav.addObject("neighborhoodMap", neighborhoodMap);
			LocationDTO dto = null;
			if (getRequestParam("locationId") != null && !getRequestParam("locationId").trim().isEmpty()) {
				dto = merchantService.getLocationDetailsById(mInfo, getRequestParam("locationId"));
				modelMap.addAttribute("locationDTO", dto);
			}

			LocationDTO locationDTO = new LocationDTO();
			stateMap = getCityDealz.getStateMap(userInfo, dto == null ? userInfo.getCity() : dto.getCity());
			cityMap = getCityDealz.getCityMap(userInfo);
			mav.addObject("cityMap", cityMap);
			mav.addObject("stateMap", mapper.writeValueAsString(stateMap));
			mav.addObject("editLocationForm", locationDTO);
			mav.addObject("merchantId", getRequestParam("merchantId"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cityMap == null)
				cityMap = new HashMap<String, String>();
			if (stateMap == null)
				stateMap = new HashMap<String, String>();
			if (neighborhoodMap == null)
				neighborhoodMap = new HashMap<String, String>();
		}
		return mav;
	}
}
