package com.app.mvc.common;

import java.io.Serializable;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AppWebHandler extends HttpServlet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4838393549791509471L;
	@Autowired
	private HttpServletRequest request;

	private HttpServletResponse response;
	@Autowired
	private HttpSession session;
	protected com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();

	public String getRequestParam(String param) {
		return request.getParameter(param);
	}

	/*
	 * public CacheDTO getCacheDTO(String dbId) { return ((Map<String,
	 * CacheDTO>)
	 * ActionContext.getContext().getApplication().get("cacheObj")).get("1"); }
	 */

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param requestgetRequest
	 *            () the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public <T extends Object> T parseJsonStringToObject(String content, Class<T> type) {
		try {
			if (content == null || content.trim().isEmpty())
				return null;
			else
				return (T) mapper.readValue(content, type);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object getSessionAttribute(String param) {
		return request.getSession().getAttribute(param);
	}

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
}
