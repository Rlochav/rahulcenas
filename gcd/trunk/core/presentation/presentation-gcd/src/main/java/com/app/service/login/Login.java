package com.app.service.login;

import com.app.login.dto.UserInfo;

public interface Login {

	public UserInfo doLogin(UserInfo userInfo) throws Exception;
}
