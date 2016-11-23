package com.app.mvc.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.MerchantDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
public class ManageEmailPwd extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3290016610503367871L;
	@Autowired
	private MerchantService merchantService;
	private MerchantDTO merchantDTO;

	@RequestMapping(value = "/manageEmailPwd", method = RequestMethod.GET)
	public String manageEmailPwdDisplay(ModelMap map) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		if (userInfo != null && "1001".equals(userInfo.getUserType())) {
			return "../../WelcomePage";
		}
		try {
			map.put("merchantDTO", merchantService.getMerchantDetailById(userInfo.getUserIndex() + "", null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "merchant/manageEmailPwd";
	}

	@RequestMapping(value = "/updateEmailPwdMerchant")
	@ResponseBody
	public MerchantDTO updateEmailPwd() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			if (merchantDTO == null)
				merchantDTO = new MerchantDTO();
			if (getRequestParam("merchantName") != null && !getRequestParam("merchantName").trim().isEmpty())
				merchantDTO.setMerchantName(getRequestParam("merchantName"));
			if (getRequestParam("mPassword") != null && !getRequestParam("mPassword").trim().isEmpty())
				merchantDTO.setPassword(getRequestParam("mPassword"));
			if (getRequestParam("mEmailId") != null && !getRequestParam("mEmailId").trim().isEmpty())
				merchantDTO.setEmailId(getRequestParam("mEmailId"));
			merchantDTO = merchantService.updateEmailPwd(userInfo, merchantDTO);
		} catch (Exception e) {
			merchantDTO = new MerchantDTO();
			if (e instanceof BaseException) {
				e.printStackTrace();
				merchantDTO.setJsonMessage(((BaseException) e).getMsgCode());
			} else if (e instanceof BusinessException) {
				e.printStackTrace();
				merchantDTO.setJsonMessage(((BusinessException) e).getMessage());
			} else {
				e.printStackTrace();
				merchantDTO
						.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return merchantDTO;
	}
}
