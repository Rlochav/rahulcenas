package com.app.mvc.merchant;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.SocialConnectionsDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.IntUtil;

import facebook4j.Account;
import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;

@Controller
public class SocialConnectionController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2619343506379764084L;
	@Autowired
	private MerchantService merchantService;
	private SocialConnectionsDTO socialConnectionsDTO;

	@RequestMapping(value = "/socialConnections", method = RequestMethod.GET)
	public String socialConnectionsDisplay(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		if (userInfo != null && "1001".equals(userInfo.getUserType())) {
			return "../../WelcomePage";
		}
		try {
			modelMap.put("socialDTO", merchantService.getMySocialConnections(userInfo.getUserIndex() + ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "merchant/socialConnections";
	}

	@RequestMapping(value = "/saveSocialConnection")
	@ResponseBody
	public SocialConnectionsDTO saveSocialConnection(ModelMap map) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			socialConnectionsDTO = new SocialConnectionsDTO();

			if (getRequestParam("connectionId") != null && !getRequestParam("connectionId").trim().isEmpty())
				socialConnectionsDTO.setConnectionId(getRequestParam("connectionId"));

			if (getRequestParam("merchantId") != null && !getRequestParam("merchantId").trim().isEmpty())
				socialConnectionsDTO.setMerchantId(getRequestParam("merchantId"));

			if (socialConnectionsDTO.getMerchantId() == null || socialConnectionsDTO.getMerchantId().trim().isEmpty())
				socialConnectionsDTO.setMerchantId(userInfo.getUserIndex() + "");

			if (getRequestParam("facebookFanPage") != null && !getRequestParam("facebookFanPage").trim().isEmpty())
				socialConnectionsDTO.setFacebookFanPage(getRequestParam("facebookFanPage"));

			if (getRequestParam("facebookFanPagechk") != null && !getRequestParam("facebookFanPagechk").trim().isEmpty())
				socialConnectionsDTO.setFacebookFanPagechk(getRequestParam("facebookFanPagechk"));

			if (getRequestParam("twitterAccount") != null && !getRequestParam("twitterAccount").trim().isEmpty())
				socialConnectionsDTO.setTwitterAccount(getRequestParam("twitterAccount"));

			if (getRequestParam("twitterAccountchk") != null && !getRequestParam("twitterAccountchk").trim().isEmpty())
				socialConnectionsDTO.setTwitterAccountchk(getRequestParam("twitterAccountchk"));

			if (getRequestParam("fourSquareAccount") != null && !getRequestParam("fourSquareAccount").trim().isEmpty())
				socialConnectionsDTO.setFourSquareAccount(getRequestParam("fourSquareAccount"));

			if (getRequestParam("fourSquareAccountchk") != null && !getRequestParam("fourSquareAccountchk").trim().isEmpty())
				socialConnectionsDTO.setFourSquareAccountchk(getRequestParam("fourSquareAccountchk"));

			if (getRequestParam("yelpAccount") != null && !getRequestParam("yelpAccount").trim().isEmpty())
				socialConnectionsDTO.setYelpAccount(getRequestParam("yelpAccount"));

			if (getRequestParam("yelpAccountchk") != null && !getRequestParam("yelpAccountchk").trim().isEmpty())
				socialConnectionsDTO.setYelpAccountchk(getRequestParam("yelpAccountchk"));

			if (getRequestParam("flickerAccount") != null && !getRequestParam("flickerAccount").trim().isEmpty())
				socialConnectionsDTO.setFlickerAccount(getRequestParam("flickerAccount"));

			if (getRequestParam("flickerAccountchk") != null && !getRequestParam("flickerAccountchk").trim().isEmpty())
				socialConnectionsDTO.setFlickerAccountchk(getRequestParam("flickerAccountchk"));

			if (getRequestParam("youtubeAccount") != null && !getRequestParam("youtubeAccount").trim().isEmpty())
				socialConnectionsDTO.setYoutubeAccount(getRequestParam("youtubeAccount"));

			if (getRequestParam("youtubeAccountchk") != null && !getRequestParam("youtubeAccountchk").trim().isEmpty())
				socialConnectionsDTO.setYoutubeAccountchk(getRequestParam("youtubeAccountchk"));

			if (getRequestParam("linkedinProfile") != null && !getRequestParam("linkedinProfile").trim().isEmpty())
				socialConnectionsDTO.setLinkedinProfile(getRequestParam("linkedinProfile"));

			if (getRequestParam("linkedinProfilechk") != null && !getRequestParam("linkedinProfilechk").trim().isEmpty())
				socialConnectionsDTO.setLinkedinProfilechk(getRequestParam("linkedinProfilechk"));

			if (getRequestParam("tripAdvisorAccount") != null && !getRequestParam("tripAdvisorAccount").trim().isEmpty())
				socialConnectionsDTO.setTripAdvisorAccount(getRequestParam("tripAdvisorAccount"));

			if (getRequestParam("tripAdvisorAccountchk") != null && !getRequestParam("tripAdvisorAccountchk").trim().isEmpty())
				socialConnectionsDTO.setTripAdvisorAccountchk(getRequestParam("tripAdvisorAccountchk"));

			if (getRequestParam("meetupAccount") != null && !getRequestParam("meetupAccount").trim().isEmpty())
				socialConnectionsDTO.setMeetupAccount(getRequestParam("meetupAccount"));

			if (getRequestParam("meetupAccountchk") != null && !getRequestParam("meetupAccountchk").trim().isEmpty())
				socialConnectionsDTO.setMeetupAccountchk(getRequestParam("meetupAccountchk"));

			if (getRequestParam("openTableAccount") != null && !getRequestParam("openTableAccount").trim().isEmpty())
				socialConnectionsDTO.setOpenTableAccount(getRequestParam("openTableAccount"));

			if (getRequestParam("openTableAccountchk") != null && !getRequestParam("openTableAccountchk").trim().isEmpty())
				socialConnectionsDTO.setOpenTableAccountchk(getRequestParam("openTableAccountchk"));

			if (getRequestParam("pinterestAccount") != null && !getRequestParam("pinterestAccount").trim().isEmpty())
				socialConnectionsDTO.setPinterestAccount(getRequestParam("pinterestAccount"));

			if (getRequestParam("pinterestAccountchk") != null && !getRequestParam("pinterestAccountchk").trim().isEmpty())
				socialConnectionsDTO.setPinterestAccountchk(getRequestParam("pinterestAccountchk"));

			if (getRequestParam("gPlusAccount") != null && !getRequestParam("gPlusAccount").trim().isEmpty())
				socialConnectionsDTO.setgPlusAccount(getRequestParam("gPlusAccount"));

			if (getRequestParam("gPlusAccountchk") != null && !getRequestParam("gPlusAccountchk").trim().isEmpty())
				socialConnectionsDTO.setgPlusAccountchk(getRequestParam("gPlusAccountchk"));

			if (getRequestParam("instagramAccount") != null && !getRequestParam("instagramAccount").trim().isEmpty())
				socialConnectionsDTO.setInstagramAccount(getRequestParam("instagramAccount"));

			if (getRequestParam("instagramAccountchk") != null && !getRequestParam("instagramAccountchk").trim().isEmpty())
				socialConnectionsDTO.setInstagramAccountchk(getRequestParam("instagramAccountchk"));

			if (getRequestParam("etsyAccount") != null && !getRequestParam("etsyAccount").trim().isEmpty())
				socialConnectionsDTO.setEtsyAccount(getRequestParam("etsyAccount"));

			if (getRequestParam("etsyAccountchk") != null && !getRequestParam("etsyAccountchk").trim().isEmpty())
				socialConnectionsDTO.setEtsyAccountchk(getRequestParam("etsyAccountchk"));

			if (getRequestParam("tumblrAccount") != null && !getRequestParam("tumblrAccount").trim().isEmpty())
				socialConnectionsDTO.setTumblrAccount(getRequestParam("tumblrAccount"));

			if (getRequestParam("tumblrAccountchk") != null && !getRequestParam("tumblrAccountchk").trim().isEmpty())
				socialConnectionsDTO.setTumblrAccountchk(getRequestParam("tumblrAccountchk"));

			if (getRequestParam("consumerKey") != null && !getRequestParam("consumerKey").trim().isEmpty())
				socialConnectionsDTO.setConsumerKey(getRequestParam("consumerKey"));

			if (getRequestParam("consumerSecret") != null && !getRequestParam("consumerSecret").trim().isEmpty())
				socialConnectionsDTO.setConsumerSecret(getRequestParam("consumerSecret"));

			if (getRequestParam("oAuthToken") != null && !getRequestParam("oAuthToken").trim().isEmpty())
				socialConnectionsDTO.setoAuthToken(getRequestParam("oAuthToken"));

			if (getRequestParam("oAuthSecret") != null && !getRequestParam("oAuthSecret").trim().isEmpty())
				socialConnectionsDTO.setoAuthSecret(getRequestParam("oAuthSecret"));

			if (getRequestParam("twitterOAuthdetailsId") != null && !getRequestParam("twitterOAuthdetailsId").trim().isEmpty())
				socialConnectionsDTO.setTwitterOAuthdetailsId(getRequestParam("twitterOAuthdetailsId"));

			socialConnectionsDTO.setJsonMessage(null);
			socialConnectionsDTO = merchantService.saveSocialConnection(userInfo, socialConnectionsDTO);
		} catch (Exception e) {
			socialConnectionsDTO = new SocialConnectionsDTO();
			if (e instanceof BaseException) {
				e.printStackTrace();
				socialConnectionsDTO.setJsonMessage(((BaseException) e).getMsgCode());
			} else if (e instanceof BusinessException) {
				e.printStackTrace();
				socialConnectionsDTO.setJsonMessage(((BusinessException) e).getMessage());
			} else {
				e.printStackTrace();
				socialConnectionsDTO
						.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return socialConnectionsDTO;
	}

	@RequestMapping(value = "/signInFacebook")
	public void signInFacebook(HttpServletResponse response) throws IOException {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthAppId(AppPropertyBuilder.getProperty("fb.appId", "01"))
				.setOAuthAppSecret(AppPropertyBuilder.getProperty("fb.appSecret", "01"))
				.setOAuthPermissions("offline_access,publish_stream,user_photos,publish_checkins,photo_upload,manage_pages");
		FacebookFactory ff = new FacebookFactory(cb.build());
		Facebook facebook = ff.getInstance();

		getRequest().getSession().setAttribute("facebook", facebook);
		StringBuffer callbackURL = getRequest().getRequestURL();
		int index = callbackURL.lastIndexOf("/");
		callbackURL.replace(index, callbackURL.length(), "").append("/merchantsocialcommunities");
		response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
	}

	@RequestMapping(value = "/component/signInByAdminFacebook")
	public void signInByAdminFacebook(HttpServletResponse response) throws IOException {
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId(AppPropertyBuilder.getProperty("fb.appId", "01"), AppPropertyBuilder.getProperty("fb.appSecret", "01"));
		getRequest().getSession().setAttribute("facebook", facebook);
		StringBuffer callbackURL = getRequest().getRequestURL();
		int index = callbackURL.lastIndexOf("/");
		callbackURL.replace(index, callbackURL.length(), "").append("/component/socialcommunities?merchantId=" + getRequestParam("merchantId"));
		response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
	}

	@RequestMapping(value = "/component/socialcommunities")
	public ModelAndView displayByAdminSocialCommunity(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("/fb/merchantsocialcommunities");
		try {
			Facebook facebook = (Facebook) getRequest().getSession().getAttribute("facebook");
			String oauthCode = getRequestParam("code");
			AccessToken accessToken = facebook.getOAuthAccessToken(oauthCode);
			String name = facebook.getName();
			System.out.println(accessToken.getExpires());
			modelMap.put("facebook", facebook);
			merchantService.saveFBAccessToken(IntUtil.getInteger(getRequestParam("merchantId")), accessToken.getToken(), name);

		} catch (Exception e) {
			System.err.println(e);
		}
		return mav;
	}

	@RequestMapping(value = "/merchantsocialcommunities")
	public ModelAndView displaySocialCommunity(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("/fb/socialcommunities");
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
			// merchantService.saveFBAccessToken(userInfo.getUserIndex(),
			// accessToken.getToken(), name);

		} catch (Exception e) {
			System.err.println(e);
		}
		return mav;
	}

	@RequestMapping(value = "/postOnFacebook")
	public void postOnFb() {
		try {
			ConfigurationBuilder confBuilder = new ConfigurationBuilder();
			confBuilder.setDebugEnabled(true);
			/*
			 * confBuilder.setOAuthAppId("274313712698100");
			 * confBuilder.setOAuthAppSecret
			 * ("0a2bac4c0875ae846825c92981aafcba");
			 */
			confBuilder.setOAuthAppId("274313712698100");
			confBuilder.setOAuthAppSecret("0a2bac4c0875ae846825c92981aafcba");
			confBuilder.setUseSSL(true);
			confBuilder.setJSONStoreEnabled(true);
			Configuration configuration = confBuilder.build();
			FacebookFactory facebookFactory = new FacebookFactory(configuration);
			Facebook facebookClient = facebookFactory.getInstance();

			facebookClient
					.setOAuthAccessToken(new AccessToken(
							"CAACeRoCfBzMBALIqq8WTaLKqbvHwWNyhmZBtbvjwlS7BYc8BgLnjFlk2ovOj0MJzaHxy8UZC5prokNdxdRDXxJCTNTZCdGdpLala5OtKdNNtUT7FHKcB96k7fH036v6Xte4CZAJoViVYoD5kgZAuysGAZBlyPtNLsIWv7S32dhWZB03pbmQZA6CZCKM5LV5MOdsgZD"));
			PostUpdate post = new PostUpdate(new URL("http://facebook4j.org")).picture(new URL("http://facebook4j.org/images/hero.png"))
					.name("Facebook4J - A Java library for the Facebook Graph API").caption("facebook4j.org").description("Success.");
			facebookClient.postFeed(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/clickOnContinue")
	public String continueWithCommunity() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		System.out.println(getRequestParam("name") + " " + getRequestParam("accessToken"));

		try {
			merchantService.saveFBAccessToken(userInfo.getUserIndex(), getRequestParam("accessToken"), getRequestParam("name"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/merchantDashboard";
	}
}
