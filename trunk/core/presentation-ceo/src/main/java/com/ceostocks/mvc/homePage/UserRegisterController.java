package com.ceostocks.mvc.homePage;

import static com.ceostocks.common.util.CeoStocksConfigProperty.getProperty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceostocks.application.user.UserApplication;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.common.util.DateUtil;
import com.ceostocks.common.util.EmailUtility;
import com.ceostocks.common.util.IntUtil;
import com.ceostocks.common.util.TokenUtil;
import com.ceostocks.model.user.UserMaster;

@Controller
public class UserRegisterController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6396799463853720749L;

	@Autowired
	private UserApplication userApplication;

	private ThreadLocal<String> errorMessage;

	@RequestMapping(value = "/doRegister")
	@ResponseBody
	public String doRegister() {
		errorMessage = new ThreadLocal<String>();
		UserMaster userMaster = new UserMaster();
		setUsermasterRequestParamas(userMaster);
		try {
			userMaster = userApplication.doRegisterUser(userMaster);

			sendActivationEmail(userMaster);
		} catch (Exception e) {
			getErrorMessage().set(e.getMessage());
			e.printStackTrace();
		}
		return getErrorMessage().get();
	}

	private void sendActivationEmail(UserMaster userMaster) throws Exception {
		Map<String, Object> holderMap = new HashMap<String, Object>();
		holderMap.put("memberName", userMaster.getFirstName());
		holderMap.put("firstName", userMaster.getFirstName());
		holderMap.put("URL", getProperty("register.confirm.url", "01") + userMaster.getActivateCode());
		boolean isSent = EmailUtility.postMailType2("01", Arrays.asList(new String[] { userMaster.getEmailId() }), null, null,
				getProperty("register.confirm.subject", "01"), "registerConfirmationUrl.vm", holderMap, 1);
	}

	private void setUsermasterRequestParamas(UserMaster userMaster) {
		userMaster.setFirstName(getRequestParam("firstName"));
		userMaster.setLastName(getRequestParam("lastName"));
		userMaster.setEmailId(getRequestParam("emailAddress"));
		userMaster.setPassword(getRequestParam("newPassword"));
		userMaster.setSex(IntUtil.getInteger(getRequestParam("gender")));
		userMaster.setDob(DateUtil.parseStringToDate(getRequestParam("dateOfBirth"), DateUtil.dateFormat));
		userMaster.setCountry(IntUtil.getInteger(getRequestParam("country")));
		userMaster.setActivateCode(TokenUtil.getToken(true, true, false, 50));
		userMaster.setIsActive(false);
		userMaster.setTimeLineId(UUID.randomUUID().toString());
	}

	@RequestMapping(value = "/component/registerStepOne")
	public String displayRegisterStep1(ModelMap modelMap) {
		modelMap.addAttribute(USER_INFO, getSession().getAttribute(USER_INFO_SESSION));
		return "user/registerStep1";
	}

	@RequestMapping(value = "/component/registerStepTwo")
	public String displayRegisterStep2(ModelMap modelMap) {
		modelMap.addAttribute(USER_INFO, getSession().getAttribute(USER_INFO_SESSION));
		return "user/registerStep2";
	}

	@RequestMapping(value = "/component/registerStepThree")
	public String displayRegisterStep3(ModelMap modelMap) {
		modelMap.addAttribute(USER_INFO, getSession().getAttribute(USER_INFO_SESSION));
		return "user/registerStep3";
	}

	@RequestMapping(value = "/component/registerStepFour")
	public String displayRegisterStep4(ModelMap modelMap) {
		modelMap.addAttribute(USER_INFO, getSession().getAttribute(USER_INFO_SESSION));
		return "user/registerStep4";
	}

	@RequestMapping(value = "/component/saveUserType")
	public String saveUserTypeSelection() {

		return null;
	}

	/**
	 * @return the userApplication
	 */
	public UserApplication getUserApplication() {
		return userApplication;
	}

	/**
	 * @param userApplication
	 *            the userApplication to set
	 */
	public void setUserApplication(UserApplication userApplication) {
		this.userApplication = userApplication;
	}

	/**
	 * @return the errorMessage
	 */
	public ThreadLocal<String> getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(ThreadLocal<String> errorMessage) {
		this.errorMessage = errorMessage;
	}

}
