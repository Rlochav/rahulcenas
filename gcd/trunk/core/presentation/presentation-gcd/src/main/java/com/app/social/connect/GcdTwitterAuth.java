package com.app.social.connect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;

@Controller
public class GcdTwitterAuth extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 973976921664237423L;

	@Autowired
	private MerchantService merchantService;

	private RequestToken requestToken;
	private Twitter twitter;

	@RequestMapping("/jsonTwitterOAuthUrl")
	@ResponseBody
	public String getAuthUrl() {
		String authUrl = null;
		try {
			twitter = new TwitterFactory().getInstance();
			twitter.setOAuthConsumer("sEnMc6fEEAMkvGxO6tuDw26VL", "350zr8GZlTn03FCrz9kxPYAaA7RRdHl3BxA40mMhhpSnIn0WTJ");
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

	@RequestMapping("/twitterOAuthCallback")
	public String authenticateTwitter(ModelMap modelMap) {
		try {
			AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, getRequestParam("oauth_verifier"));
			accessToken.getScreenName();
			System.out.println(accessToken.getToken());

			modelMap.put("screenName", accessToken.getScreenName());
			modelMap.put("userId", accessToken.getUserId());
			modelMap.put("token", accessToken.getToken());
			modelMap.put("tokenSecret", accessToken.getTokenSecret());

		} catch (Exception e) {
			System.err.println("Twitter Api Failed: " + e.getMessage());
		}
		return "fb/twitterCallback";
	}

	@RequestMapping("/saveTwitterDetails")
	public String saveTwitterDetails(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		try {
			merchantService.saveTwitterDetails(userInfo, getRequestParam("userId"), getRequestParam("screenName"), getRequestParam("token"),
					getRequestParam("tokenSecret"));
		} catch (Exception e) {
			System.err.println("Twitter Api Failed: " + e.getMessage());
		}
		return "redirect:/socialConnections";
	}
}
