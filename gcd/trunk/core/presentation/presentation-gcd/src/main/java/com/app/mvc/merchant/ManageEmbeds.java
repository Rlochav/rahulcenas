package com.app.mvc.merchant;

import static org.springframework.util.StringUtils.isEmpty;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.getcitydealz.dto.EmbedsDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.model.getcitydealz.MerchantEmbeds;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.IntUtil;

@Controller
public class ManageEmbeds extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7714366704578682727L;
	@Autowired
	private GetCityDealz getCityDealz;
	@Autowired
	private MerchantService merchantService;

	@RequestMapping(value = "/manageEmbeds")
	public String manageMediaDisplay(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			if (userInfo != null && "1001".equals(userInfo.getUserType())) {
				return "../../WelcomePage";
			}
			List<EmbedsDTO> embedsDTOs = merchantService.getMerchantEmbeds(userInfo.getUserIndex());
			modelMap.put("embedsDTOs", embedsDTOs);
			MerchantEmbeds merchantEmbeds = new MerchantEmbeds();
			modelMap.put("merchantEmbeds", merchantEmbeds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "merchant/manageEmbeds";
	}

	@RequestMapping(value = "/deleteEmbeds")
	@ResponseBody
	public EmbedsDTO deleteMediaFile() {
		EmbedsDTO embedsDTO = null;
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			embedsDTO = merchantService.deleteEmbed(IntUtil.getInteger(getRequestParam("embedId")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return embedsDTO;
	}

	@RequestMapping(value = "/updateEmbeds")
	@ResponseBody
	public EmbedsDTO updateSavedMedia() {
		EmbedsDTO embedsDTO = null;
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			embedsDTO = new EmbedsDTO();

			if (!isEmpty(getRequestParam("embedId")))
				embedsDTO.setEmbedId(getRequestParam("embedId"));
			if (!isEmpty(getRequestParam("title")))
				embedsDTO.setEmbedTitle(getRequestParam("title"));
			if (!isEmpty(getRequestParam("content")))
				embedsDTO.setEmbedContent(getRequestParam("content"));
			if (!isEmpty(getRequestParam("showOnPage")))
				embedsDTO.setShowOnPage(getRequestParam("showOnPage"));

			embedsDTO = merchantService.saveMerchantEmbeds(userInfo, embedsDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return embedsDTO;
	}

	@RequestMapping(value = "/saveEmbeds", method = RequestMethod.POST)
	public String uploadMediaFiles(@Valid MerchantEmbeds merchantEmbeds, BindingResult bindingResult, ModelMap model) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			if (bindingResult.hasErrors())
				return "merchant/manageEmbeds";
			EmbedsDTO embedsDTO = new EmbedsDTO();
			embedsDTO.setEmbedTitle(merchantEmbeds.getEmbedTitle());
			embedsDTO.setEmbedContent(merchantEmbeds.getEmbedContent());
			embedsDTO.setShowOnPage(merchantEmbeds.getIsShowOnPage().toString());
			embedsDTO = merchantService.saveMerchantEmbeds(userInfo, embedsDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/manageEmbeds";
	}
}
