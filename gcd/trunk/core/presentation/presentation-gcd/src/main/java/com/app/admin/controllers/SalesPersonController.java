package com.app.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.SalesPersonDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
public class SalesPersonController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private GetCityDealz getCityDealz;

	@RequestMapping(value = "/component/salesPeople")
	public ModelAndView display() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/salespersons");
		try {
			SalesPersonDTO salesPersonDTO = getCityDealz.getAllSalesPerson(userInfo);
			if (salesPersonDTO != null)
				mav.addObject("salesPList", salesPersonDTO.getSalesPersonDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/addsalesperson")
	public String editSalesPerson(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		String btnName = "Add New";
		try {
			if (getRequestParam("spId") != null && !getRequestParam("spId").equals("undefined") && !getRequestParam("spId").trim().isEmpty()) {
				modelMap.put("salesPDTO", getCityDealz.getSalesPersonById(userInfo, getRequestParam("spId")));
				btnName = "Update";
			}
			modelMap.put("btnName", btnName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/editSalespersons";
	}

	@RequestMapping(value = "/component/jsonSaveSalesPerson")
	@ResponseBody
	public SalesPersonDTO saveSalesPerson() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		SalesPersonDTO dto = null;
		try {
			SalesPersonDTO salesPersonDTO = new SalesPersonDTO();
			if (getRequestParam("spId") != null && !getRequestParam("spId").trim().isEmpty())
				salesPersonDTO.setSalesPersonId(getRequestParam("spId"));

			if (getRequestParam("firstName") != null && !getRequestParam("firstName").trim().isEmpty())
				salesPersonDTO.setSalesPersonFirstName(getRequestParam("firstName"));

			if (getRequestParam("lastName") != null && !getRequestParam("lastName").trim().isEmpty())
				salesPersonDTO.setSalesPersonLastName(getRequestParam("lastName"));

			if (getRequestParam("status") != null && !getRequestParam("status").trim().isEmpty())
				salesPersonDTO.setStatus(getRequestParam("status"));

			dto = getCityDealz.saveSalesPerson(userInfo, salesPersonDTO);
		} catch (Exception e) {
			dto = new SalesPersonDTO();
			if (e instanceof BaseException)
				dto.setJsonMessage(((BaseException) e).getMsgCode());
			else if (e instanceof BusinessException)
				dto.setJsonMessage(((BusinessException) e).getMessage());
			else
				dto.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");

		}
		return dto;
	}
}
