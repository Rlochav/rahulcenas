package com.ceostocks.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.common.util.CeoStocksConfigProperty;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserInfo userInfo;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (request.getSession().getAttribute(CeoStocksWebHandler.USER_INFO_SESSION) == null) {
			response.sendRedirect(CeoStocksConfigProperty.getProperty("domain.prefix", "01") + "index");
			return false;
		}
		return super.preHandle(request, response, handler);
	}
}
