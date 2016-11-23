package com.app.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.NeighborhoodDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
public class NeighborhoodsController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private GetCityDealz getCityDealz;

	@RequestMapping(value = "/component/neighborhoods")
	public ModelAndView neighborhoodsDisplay() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/merchantManagement/mMgmtNeighborhoods");
		try {
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getAllNeighborhoods(userInfo);
			mav.addObject("neighborhoodDTOList", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/addneighborhood")
	public ModelAndView addneighborhoodDisplay(ModelMap modelMap) {
		String btnName = "Add New";
		ModelAndView mav = new ModelAndView("admin/merchantManagement/addneighborhood");
		String nName = getRequestParam("nName");
		String nId = getRequestParam("nId");
		if (nId != null)
			btnName = "Update";
		modelMap.put("nName", nName);
		modelMap.put("nId", nId);
		modelMap.put("btnName", btnName);
		return mav;
	}

	@RequestMapping(value = "/component/saveNeighborhood")
	@ResponseBody
	public NeighborhoodDTO saveNeighborhood() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO();
		try {

			if (getRequestParam("neighborhoodId") != null && !getRequestParam("neighborhoodId").trim().isEmpty())
				neighborhoodDTO.setNeighborhoodId(getRequestParam("neighborhoodId"));

			if (getRequestParam("neighborhoodName") != null && !getRequestParam("neighborhoodName").trim().isEmpty())
				neighborhoodDTO.setNeighborhoodName(getRequestParam("neighborhoodName"));
			neighborhoodDTO = getCityDealz.saveNeighborhood(userInfo, neighborhoodDTO);
		} catch (Exception e) {
			neighborhoodDTO = new NeighborhoodDTO();
			e.printStackTrace();
			if (e instanceof BaseException) {
				BaseException bEx = (BaseException) e;
				neighborhoodDTO.setJsonMessage(bEx.getMsgCode());
			} else if (e.getCause() instanceof BusinessException) {
				BusinessException bEx = (BusinessException) e.getCause();
				neighborhoodDTO.setJsonMessage(bEx.getMsgCode());
			} else {
				neighborhoodDTO
						.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return neighborhoodDTO;
	}
}
