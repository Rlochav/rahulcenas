package com.ceostocks.common.handler;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceostocks.common.dto.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class CeoStocksWebHandler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6484330124707862546L;

	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpSession session;
	protected ObjectMapper mapper = new ObjectMapper();

	public static final String USER_INFO_SESSION = "USER_INFO_SESSION";
	public static final String USER_INFO = "userInfo";
	public static final String PROFILE_INFO = "profileInfo";

	public String getRequestParam(String param) {
		return request.getParameter(param);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		if (this.session == null && request != null)
			this.session = request.getSession();
		return this.session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}

	public UserInfo getUserInfo() {
		return (UserInfo) session.getAttribute(USER_INFO_SESSION);
	}

}
