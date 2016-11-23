package com.app.admin.controllers;

import static com.app.utility.common.AppPropertyBuilder.getProperty;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.SocialConnectionsDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.AppPropertyBuilder;

import facebook4j.Account;
import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import facebook4j.conf.ConfigurationBuilder;

@Controller
public class AdminSocialLinkController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	public GetCityDealz getCityDealz;
	@Autowired
	private MerchantService merchantService;

	private RequestToken requestToken;
	private Twitter twitter;

	@RequestMapping(value = "/component/socialLinks")
	public ModelAndView display(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/adminsociallinks");
		try {
			SocialConnectionsDTO connectionsDTO = getCityDealz.getAdminSConnDetails(userInfo);
			if (connectionsDTO != null)
				modelMap.put("conn", connectionsDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/jsonSaveSConnDetails")
	@ResponseBody
	public SocialConnectionsDTO saveSConnDetail() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		SocialConnectionsDTO connectionsDTO = new SocialConnectionsDTO();
		try {
			if (getRequestParam("sConnId") != null && !getRequestParam("sConnId").trim().isEmpty())
				connectionsDTO.setConnectionId((getRequestParam("sConnId")));

			if (getRequestParam("fbFanPage") != null && !getRequestParam("fbFanPage").trim().isEmpty())
				connectionsDTO.setFacebookFanPage((getRequestParam("fbFanPage")));

			if (getRequestParam("twtId") != null && !getRequestParam("twtId").trim().isEmpty())
				connectionsDTO.setTwitterAccount((getRequestParam("twtId")));

			String flag = getRequestParam("flag");
			connectionsDTO = getCityDealz.saveSConnDetails(userInfo, connectionsDTO, flag);
		} catch (Exception e) {
			connectionsDTO = new SocialConnectionsDTO();
			e.printStackTrace();
			if (e instanceof BaseException) {
				BaseException bEx = (BaseException) e;
				connectionsDTO.setJsonMessage(bEx.getMsgCode());
			} else if (e.getCause() instanceof BusinessException) {
				BusinessException bEx = (BusinessException) e.getCause();
				connectionsDTO.setJsonMessage(bEx.getMsgCode());
			} else {
				connectionsDTO
						.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return connectionsDTO;
	}

	@RequestMapping(value = "/component/signInFacebook")
	@ResponseBody
	public void signInFacebook(HttpServletResponse response) throws IOException {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthAppId(AppPropertyBuilder.getProperty("fb.admin.appId", "01"))
				.setOAuthAppSecret(AppPropertyBuilder.getProperty("fb.admin.appSecret", "01"))
				.setOAuthPermissions("email, public_profile,user_friends");
		FacebookFactory ff = new FacebookFactory(cb.build());
		Facebook facebook = ff.getInstance();

		getRequest().getSession().setAttribute("facebook", facebook);
		StringBuffer callbackURL = getRequest().getRequestURL();
		int index = callbackURL.lastIndexOf("/");
		callbackURL.replace(index, callbackURL.length(), "").append("/merchantsocialcommunities");
		response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
	}

	@RequestMapping(value = "/component/merchantsocialcommunities")
	public ModelAndView displaySocialCommunity(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("/fb/adminSocialcommunities");
		try {
			Facebook facebook = (Facebook) getRequest().getSession().getAttribute("facebook");
			String oauthCode = getRequest().getParameter("code");
			AccessToken accessToken = facebook.getOAuthAccessToken(oauthCode);
			String name = facebook.getName();
			System.out.println(accessToken.getExpires());
			ResponseList<Account> accounts = facebook.getAccounts();
			if (accounts != null && accounts.size() > 0) {
				System.out.println(accounts.get(0).getName() + "_" + accounts.get(0).getAccessToken());
				modelMap.put("acc", accounts);
			}
			modelMap.put("facebook", facebook);
			modelMap.put("token", accessToken.getToken());
		} catch (Exception e) {
			System.err.println(e);
		}
		return mav;
	}

	@RequestMapping(value = "/component/clickOnContinue")
	public String continueWithCommunity() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		System.out.println(getRequestParam("name") + " " + getRequestParam("accessToken"));

		try {
			merchantService.saveAdminFBAccessToken(userInfo.getUserIndex(), getRequestParam("accessToken"), getRequestParam("name"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/component/socialLinks";
	}

	@RequestMapping("/component/jsonTwitterOAuthUrl")
	@ResponseBody
	public String getAuthUrl() {
		String authUrl = null;
		try {
			twitter = new TwitterFactory().getInstance();
			twitter.setOAuthConsumer(getProperty("twitter.admin.consumerKey", "01"),getProperty("twitter.admin.consumerSecret", "01"));
			requestToken = twitter.getOAuthRequestToken();
			System.out.println("Got request token.");
			System.out.println("Request token: " + requestToken.getToken());
			System.out.println("Request token secret: " + requestToken.getTokenSecret());
			authUrl = requestToken.getAuthorizationURL();
			System.out.println(authUrl);
		} catch (Exception e) {
			System.err.println("Twitter Api Failed: " + e.getMessage());
		}
		return authUrl;
	}

	@RequestMapping("/component/twitterOAuthCallback")
	public String authenticateTwitter(ModelMap modelMap) {
		try {
			twitter4j.auth.AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, getRequestParam("oauth_verifier"));
			accessToken.getScreenName();
			System.out.println(accessToken.getToken());

			modelMap.put("screenName", accessToken.getScreenName());
			modelMap.put("userId", accessToken.getUserId());
			modelMap.put("token", accessToken.getToken());
			modelMap.put("tokenSecret", accessToken.getTokenSecret());

		} catch (Exception e) {
			System.err.println("Twitter Api Failed: " + e.getMessage());
		}
		return "fb/adminTwitterCallback";
	}

	@RequestMapping("/component/saveTwitterDetails")
	public String saveTwitterDetails(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			merchantService.saveAdminTwitterDetails(userInfo, getRequestParam("userId"), getRequestParam("screenName"), getRequestParam("token"),
					getRequestParam("tokenSecret"));
		} catch (Exception e) {
			System.err.println("Twitter Api Failed: " + e.getMessage());
		}
		return "redirect:/component/socialLinks";
	}

}
