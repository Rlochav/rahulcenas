package com.app.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.CityDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
public class CitiesController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public GetCityDealz getCityDealz;

	@RequestMapping(value = "/component/cities")
	public ModelAndView display() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/listcities");
		try {
			CityDTO cityDTO = getCityDealz.getAllCityDetails(userInfo);
			mav.addObject("citiesList", cityDTO.getCityDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/editcity")
	public ModelAndView editCitydisplay() {
		ModelAndView mav = new ModelAndView("admin/editcity");
		String btnName = "Add New";
		try {
			if (getRequestParam("cityId") != null && !getRequestParam("cityId").trim().isEmpty() && getRequestParam("stateId") != null
					&& !getRequestParam("stateId").trim().isEmpty()) {
				CityDTO cityDTO = getCityDealz.getCityDetailsById(getRequestParam("cityId"), getRequestParam("stateId"));
				btnName = "Update";
				mav.addObject("city", cityDTO);
			}
			mav.addObject("btnName", btnName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/jsonSaveCityDetails")
	@ResponseBody
	public CityDTO saveCityDetails() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		CityDTO cityDTO = new CityDTO();
		try {
			if (getRequestParam("cityId") != null && !getRequestParam("cityId").trim().isEmpty())
				cityDTO.setCityId(getRequestParam("cityId"));
			if (getRequestParam("cityCode") != null && !getRequestParam("cityCode").trim().isEmpty())
				cityDTO.setCityCode(getRequestParam("cityCode"));
			if (getRequestParam("cityName") != null && !getRequestParam("cityName").trim().isEmpty())
				cityDTO.setCityName(getRequestParam("cityName"));
			if (getRequestParam("state") != null && !getRequestParam("state").trim().isEmpty())
				cityDTO.setStateName(getRequestParam("state"));
			if (getRequestParam("stateId") != null && !getRequestParam("stateId").trim().isEmpty())
				cityDTO.setStateId(getRequestParam("stateId"));
			cityDTO = getCityDealz.saveCityDetails(userInfo, cityDTO);
		} catch (Exception e) {
			cityDTO = new CityDTO();
			e.printStackTrace();
			if (e instanceof BaseException) {
				BaseException bEx = (BaseException) e;
				cityDTO.setJsonMessage(bEx.getMsgCode());
			} else if (e.getCause() instanceof BusinessException) {
				BusinessException bEx = (BusinessException) e.getCause();
				cityDTO.setJsonMessage(bEx.getMsgCode());
			} else {
				cityDTO.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return cityDTO;
	}
}
