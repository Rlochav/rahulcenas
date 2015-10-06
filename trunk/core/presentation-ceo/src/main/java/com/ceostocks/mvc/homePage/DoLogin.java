package com.ceostocks.mvc.homePage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ceostocks.application.user.UserApplication;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.handler.CeoStocksWebHandler;

@Controller
@SessionAttributes({ "USER_INFO_SESSION" })
public class DoLogin extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7818950058445621563L;

	@Autowired
	private UserApplication userApplication;

	private ThreadLocal<String> errorMessage;

	@RequestMapping(value = "/doLogin", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String doLogin(ModelMap modelMap) {
		errorMessage = new ThreadLocal<String>();
		try {
			String ipAddress = getClientIpAddr(getRequest());
			UserInfo userInfo = userApplication.doLogin(getRequestParam("userId"), getRequestParam("password"), ipAddress);
			modelMap.addAttribute(USER_INFO_SESSION, userInfo);
		} catch (Exception e) {
			errorMessage.set(e.getMessage());
			e.printStackTrace();
		}
		return errorMessage.get();
	}

	@RequestMapping(value = "/accountConfirmation")
	public String accountConfirmation(ModelMap modelMap) {
		String activationCode = getRequestParam("token");
		try {
			UserInfo userInfo = userApplication.getUserMasterByActivationCode(activationCode);
			if (userInfo != null) {
				modelMap.addAttribute(USER_INFO_SESSION, userInfo);
			} else {
				modelMap.addAttribute("message", "register.invalid.token");
				return "errorPages/defaultErrorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/component/registerStepOne";
	}

	private static String getClientIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip + (request.getRemoteHost() == null ? "" : "/" + request.getRemoteHost());
	}
}
