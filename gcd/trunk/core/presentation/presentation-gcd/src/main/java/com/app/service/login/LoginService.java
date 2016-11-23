package com.app.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.login.dto.UserInfo;
import com.app.login.manager.LoginManager;

@Service
public class LoginService implements Login {

	@Autowired
	private LoginManager loginManager;

	@Transactional(propagation = Propagation.NEVER)
	public UserInfo doLogin(UserInfo userInf) throws Exception {
		UserInfo userInfo = null;
		userInfo = loginManager.doLogin(userInf);
		return userInfo;
	}

	/**
	 * @return the loginManager
	 */
	public LoginManager getLoginManager() {
		return loginManager;
	}

	/**
	 * @param loginManager
	 *            the loginManager to set
	 */
	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}

}
