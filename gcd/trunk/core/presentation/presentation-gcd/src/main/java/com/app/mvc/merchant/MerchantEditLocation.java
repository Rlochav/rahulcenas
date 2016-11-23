package com.app.mvc.merchant;

import static org.springframework.util.StringUtils.isEmpty;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.LocationDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.IntUtil;

@Controller
public class MerchantEditLocation extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -310018192797930228L;

	@Autowired
	private MerchantService merchantService;

	@Autowired
	private GetCityDealz getCityDealz;

	private LocationDTO locationDTO;

	@RequestMapping(value = "/editLocation", method = RequestMethod.GET)
	public ModelAndView editAdditionalLocationDisplay(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		if (userInfo != null && "1001".equals(userInfo.getUserType())) {
			return new ModelAndView("../../WelcomePage");
		}
		ModelAndView mav = new ModelAndView("merchant/editLocation");
		Map<String, String> cityMap = null;
		Map<String, String> stateMap = null;
		Map<String, String> neighborhoodMap = null;
		try {
			neighborhoodMap = merchantService.getNeighborhoodMap(userInfo);
			mav.addObject("neighborhoodMap", neighborhoodMap);
			LocationDTO dto = null;
			if (getRequestParam("locationId") != null && !getRequestParam("locationId").trim().isEmpty()) {
				dto = merchantService.getLocationDetailsById(userInfo, getRequestParam("locationId"));
				modelMap.addAttribute("locationDTO", dto);
			}

			LocationDTO locationDTO = new LocationDTO();
			stateMap = getCityDealz.getStateMap(userInfo, dto == null ? userInfo.getCity() : dto.getCity());
			cityMap = getCityDealz.getCityMap(userInfo);
			mav.addObject("cityMap", cityMap);
			mav.addObject("stateMap", mapper.writeValueAsString(stateMap));
			mav.addObject("editLocationForm", locationDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cityMap == null)
				cityMap = new HashMap<String, String>();
			if (stateMap == null)
				stateMap = new HashMap<String, String>();
		}
		return mav;
	}

	@RequestMapping(value = "/jsonGetStateByCityId")
	@ResponseBody
	public Map<String, String> jsonGetStateByCityId() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		Map<String, String> stateMap = null;
		try {
			if (getRequestParam("cityId") != null && !getRequestParam("cityId").trim().isEmpty())
				stateMap = getCityDealz.getStateMap(userInfo, getRequestParam("cityId"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stateMap == null)
				stateMap = new HashMap<String, String>();
		}
		return stateMap;
	}

	@RequestMapping(value = "/deleteAdditionalLocation")
	@ResponseBody
	public LocationDTO deleteAdditionalLocation() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			Integer merchantId = isEmpty(getRequestParam("merchantId")) == false ? IntUtil.getInteger(getRequestParam("merchantId")) : userInfo
					.getUserIndex();
			if (!isEmpty(getRequestParam("locId")))
				locationDTO = merchantService.deleteMerchantAdditionLocation(merchantId, getRequestParam("locId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locationDTO;
	}

	@RequestMapping(value = "/manageLocation", method = RequestMethod.GET)
	public String manageLocationDisplay(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			LocationDTO locationDTOs = merchantService.getAdditionLocationByMerchant(userInfo);
			if (locationDTOs != null && locationDTOs.getLocationDTOs() != null) {
				if (locationDTOs.getLocationDTOs().size() > 0)
					modelMap.addAttribute("locationDTO1", locationDTOs.getLocationDTOs().get(0));
				else
					modelMap.addAttribute("locationDTO1", new LocationDTO());
				if (locationDTOs.getLocationDTOs().size() > 1)
					modelMap.addAttribute("locationDTO2", locationDTOs.getLocationDTOs().get(1));
				else
					modelMap.addAttribute("locationDTO2", new LocationDTO());
				if (locationDTOs.getLocationDTOs().size() > 2)
					modelMap.addAttribute("locationDTO3", locationDTOs.getLocationDTOs().get(2));
				else
					modelMap.addAttribute("locationDTO3", new LocationDTO());
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
		return "merchant/manageLocation";
	}

	@RequestMapping(value = "/saveEditLocation")
	@ResponseBody
	public LocationDTO saveEditLocation() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			LocationDTO dto = new LocationDTO();

			if (getRequestParam("merchantId") != null && !getRequestParam("merchantId").trim().isEmpty())
				dto.setMerchantId(getRequestParam("merchantId"));
			else
				dto.setMerchantId(userInfo.getUserIndex() + "");

			if (getRequestParam("locationId") != null && !getRequestParam("locationId").trim().isEmpty())
				dto.setLocationId(getRequestParam("locationId"));
			if (getRequestParam("locationName") != null && !getRequestParam("locationName").trim().isEmpty())
				dto.setLocationName(getRequestParam("locationName"));
			if (getRequestParam("contactFirstName") != null && !getRequestParam("contactFirstName").trim().isEmpty())
				dto.setContactFirstName(getRequestParam("contactFirstName"));
			if (getRequestParam("contactLastName") != null && !getRequestParam("contactLastName").trim().isEmpty())
				dto.setContactLastName(getRequestParam("contactLastName"));
			if (getRequestParam("locationPhone") != null && !getRequestParam("locationPhone").trim().isEmpty())
				dto.setLocationPhone(getRequestParam("locationPhone"));
			if (getRequestParam("address1") != null && !getRequestParam("address1").trim().isEmpty())
				dto.setAddress1(getRequestParam("address1"));
			if (getRequestParam("address2") != null && !getRequestParam("address2").trim().isEmpty())
				dto.setAddress2(getRequestParam("address2"));
			if (getRequestParam("address3") != null && !getRequestParam("address3").trim().isEmpty())
				dto.setAddress3(getRequestParam("address3"));
			if (getRequestParam("city") != null && !getRequestParam("city").trim().isEmpty())
				dto.setCity(getRequestParam("city"));
			if (getRequestParam("state") != null && !getRequestParam("state").trim().isEmpty())
				dto.setState(getRequestParam("state"));
			if (getRequestParam("zipCode") != null && !getRequestParam("zipCode").trim().isEmpty())
				dto.setZipCode(getRequestParam("zipCode"));
			if (getRequestParam("emailAddress") != null && !getRequestParam("emailAddress").trim().isEmpty())
				dto.setEmailAddress(getRequestParam("emailAddress"));
			if (getRequestParam("locationDesc") != null && !getRequestParam("locationDesc").trim().isEmpty())
				dto.setLocationDesc(getRequestParam("locationDesc"));
			if (getRequestParam("locationHours") != null && !getRequestParam("locationHours").trim().isEmpty())
				dto.setLocationHours(getRequestParam("locationHours"));
			if (getRequestParam("neighborhoodName") != null && !getRequestParam("neighborhoodName").trim().isEmpty())
				dto.setNeighborhoodName(getRequestParam("neighborhoodName"));

			locationDTO = merchantService.saveEditLocation(IntUtil.getInteger(dto.getMerchantId()), dto);
		} catch (Exception e) {
			locationDTO = new LocationDTO();
			if (e instanceof BaseException) {
				e.printStackTrace();
				locationDTO.setJsonMessage(((BaseException) e).getMsgCode());
			} else if (e instanceof BusinessException) {
				e.printStackTrace();
				locationDTO.setJsonMessage(((BusinessException) e).getMessage());
			} else {
				e.printStackTrace();
				locationDTO
						.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return locationDTO;
	}

	/**
	 * @return the locationDTO
	 */
	public LocationDTO getLocationDTO() {
		return locationDTO;
	}

	/**
	 * @param locationDTO
	 *            the locationDTO to set
	 */
	public void setLocationDTO(LocationDTO locationDTO) {
		this.locationDTO = locationDTO;
	}

}
