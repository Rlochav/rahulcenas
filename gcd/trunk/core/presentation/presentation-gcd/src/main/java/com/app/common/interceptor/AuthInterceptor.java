package com.app.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.Resource;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.getcitydealz.dto.CityDTO;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.AppPropertyBuilder;

/**
 * 
 * @author Arun
 * 
 */
public class AuthInterceptor extends AppWebHandler implements HandlerInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4831042746083064487L;

	Resource[] resources = null;

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception e) throws Exception {

		try {

		} catch (Exception e2) {
			System.out.println("Hi after Comletion" + e.getMessage());
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3) throws Exception {
		try {
			System.out.println();
		} catch (Exception e2) {
			System.out.println("Hi after Comletion" + e2.getMessage());
		}
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		try {
			UserInfo userInfo = request.getSession().getAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) request.getSession()
					.getAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) : null;
			request.setCharacterEncoding("UTF-8");

			String requestedPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);

			if (!requestedPath.equals("/updateMediaTitle") && !requestedPath.equals("/deleteMediaFile") && !requestedPath.equals("/displayImage")
					&& !requestedPath.equals("/displayImage1") && !requestedPath.equals("/jsonGetHotDealz") && !requestedPath.equals("/saveSocialConnection")
					&& !requestedPath.equals("/manageMerchantLocation") && !requestedPath.equals("/saveEditLocation") && !requestedPath.equals("/myProfile")
					&& !requestedPath.equals("/savePageMaster") && !requestedPath.equals("/saveRightHandRails") && !requestedPath.equals("/pageNotFound")
					&& !requestedPath.equals("/jsonGetSubCategoryByCtgId") && !requestedPath.equals("/rightHandRailEditor") && !requestedPath.equals("/error")
					&& !requestedPath.equals("/adminDoLogin") && !requestedPath.equals("/pageEditor") && requestedPath.indexOf("/component/") == -1
					&& userInfo != null && userInfo.getUserType() != null && userInfo.getUserType().equals("1001")) {
				response.sendRedirect("/");
				return true;
			}

			if (requestedPath.equals("/contactus") || requestedPath.equals("/privacy-policy") || requestedPath.equals("/new-orleans-merchant-listing")
					|| requestedPath.equals("/adminDoLogin") || requestedPath.equals("/admin") || requestedPath.equals("/sendBecomeMerchantRequest")
					|| requestedPath.equals("/merchant-signin") || requestedPath.equals("/merchant-login-city") || requestedPath.equals("/rateDealz")
					|| requestedPath.equals("/citieslist") || requestedPath.equals("/displayImage") || requestedPath.equals("/displayImage1")
					|| requestedPath.equals("/doRegister") || requestedPath.equals("/mRegistrationSuccessfully")
					|| requestedPath.equals("/merchantLevelPaypal") || requestedPath.equals("/loadAllDealz") || requestedPath.equals("/doLogin")
					|| requestedPath.equals("/doLogin") || requestedPath.equals("/login") || requestedPath.equals("/dev")
					|| requestedPath.equals("/masterLogin") || requestedPath.equals("/checkpoint") || requestedPath.equals("/downloadDocument")
					|| requestedPath.equals("/become-a-merchant") || requestedPath.equals("/subscribe") || requestedPath.equals("/sitemap")
					|| requestedPath.equals("/become-a-merchant/subscription-plan-pricing") || requestedPath.equals("/jsonSubscribeDeails")
					|| requestedPath.equals("/about-get-city-dealz") || requestedPath.equals("/blogs") || requestedPath.equals("/jefferson-chamber")
					|| requestedPath.equals("/employment") || requestedPath.equals("/jsonGetHotDealz") || requestedPath.equals("/index")
					|| requestedPath.equals("/getdeals-city") || requestedPath.equals("/refillCache") || requestedPath.equals("/remindMeMyCredentials")
					|| requestedPath.equals("/dashboard") || requestedPath.equals("/jsonAutoFileQuery") || requestedPath.equals("/searchQuery")
					|| requestedPath.equals("/jsonConfirmDeal") || requestedPath.equals("/socialDetailsConsumer")
					|| requestedPath.equals("/ckfinder/core/connector/java/connector.java") || requestedPath.equals("/pageEditor")
					|| requestedPath.equals("/rightHandRailEditor") || requestedPath.equals("/sitemap.xml") || requestedPath.equals("/error")
					|| requestedPath.equals("/pageNotFound"))
				return true;

			else if (requestedPath.equals("/redirectToCityLink")) {
				String cityId = request.getParameter("cityId");
				CityDTO cityDTO = new SupportClass().getCityDTO(cityId);
				if (cityDTO != null) {
					String standardUrl = AppPropertyBuilder.getProperty("standardUrl.subdomain.url", "01");
					response.sendRedirect("http://" + cityDTO.getCityCode() + standardUrl);
				} else
					return false;
			}

			else if (requestedPath.equals("/redirectToGcdCity")) {
				String qParam = request.getParameter("q");
				String cityId = request.getParameter("cityId");
				if (userInfo == null)
					userInfo = new UserInfo();
				userInfo.setCityId(cityId);
				CityDTO cityDTO = new SupportClass().getCityDTO(cityId);
				switch (qParam) {
				case "email": {
					if (cityDTO != null) {
						String standardUrl = AppPropertyBuilder.getProperty("citiesUrl.subdomain.url", "01");
						response.sendRedirect("http://" + cityDTO.getCityCode() + standardUrl + "/subscribe");
					} else
						return false;
					break;
				}
				case "map": {
					if (cityDTO != null) {
						String standardUrl = AppPropertyBuilder.getProperty("citiesUrl.subdomain.url", "01");
						response.sendRedirect("http://" + cityDTO.getCityCode() + standardUrl + "/dealzByMap/DealsOnMap");
					} else
						return false;
					break;
				}
				case "mList": {
					if (cityDTO != null) {
						String standardUrl = AppPropertyBuilder.getProperty("citiesUrl.subdomain.url", "01");
						response.sendRedirect("http://" + cityDTO.getCityCode() + standardUrl + "/new-orleans-merchant-listing");
					} else
						return false;
					break;
				}
				}
			}

			else if (userInfo == null || requestedPath.equals("/appLogOut"))
				response.sendRedirect("/merchant-signin");
		} catch (Exception e) {
			System.out.println("Hi");
		}

		return true;
	}
}
