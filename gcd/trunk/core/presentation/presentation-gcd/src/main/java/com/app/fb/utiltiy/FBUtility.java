package com.app.fb.utiltiy;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import facebook4j.Account;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import facebook4j.auth.OAuthAuthorization;
import facebook4j.auth.OAuthSupport;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;
import facebook4j.internal.org.json.JSONArray;

@Controller
public class FBUtility {

	@RequestMapping(value = "/facebook/connect-2-facebook")
	public ModelAndView display() {
		ModelAndView mav = new ModelAndView("/fb/facebookDetails");
		return mav;
	}

	@RequestMapping(value = "/facebook/postOnFacebook")
	public void updateStatus() {
		try {
			ConfigurationBuilder confBuilder = new ConfigurationBuilder();

			confBuilder.setDebugEnabled(true);
			confBuilder.setOAuthAppId("274313712698100");
			confBuilder.setOAuthAppSecret("0a2bac4c0875ae846825c92981aafcba");
			confBuilder.setUseSSL(true);
			confBuilder.setJSONStoreEnabled(true);

			Configuration configuration = confBuilder.build();

			FacebookFactory facebookFactory = new FacebookFactory(configuration);
			Facebook facebookClient = facebookFactory.getInstance();
			AccessToken accessToken = null;
			ResponseList<Account> accounts = null;
			try {
				OAuthSupport oAuthSupport = new OAuthAuthorization(configuration);

				accessToken = oAuthSupport.getOAuthAppAccessToken();
			} catch (FacebookException e) {
				System.err.println("Error while creating access token " + e.getLocalizedMessage());
			}

			URL url = new URL("https://graph.facebook.com/oauth/access_token?client_id=174025642805043&client_secret=9834e76ac9a4cfbfca2befc0e1c94698&grant_type=fb_exchange_token&fb_exchange_token=CAACeRoCfBzMBAPfqZBKNNmknV4YLWdyI3yD4THKYUxZAYNhCtbnQvDhFlQSxrM3QZCMnKZB6LZA5dupZAeAWQG73jiYPq9Te5NYEcLeKBiLFH5vfietV8hk8Y0nE88xbK7gRkbrhv3gZCFyQCBU3NQxbrrLR1BBT9gy0ZBZCVl72PCHPkKlvvrG0JaN2WxzBkFiojIylpMiQHNwZDZD");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			facebookClient
					.setOAuthAccessToken(new AccessToken(
							"CAACeRoCfBzMBAG144DU1fVQqBBR52wg7oAcAZAVZBIMGZBCIIuxoVeo3AjZCEwuKdn3tJJbmxYB7adPooWuJyhrHa5oFmZC5VBsPpm084ZC0tZCahJNIdn8p63hmfSbQ88ukG23gh62QI8ANm74wI0OLFcQqlRldQSVKMXjCLGbUSEzNX8D8slweTRjZBA2GVmQZD"));
			JSONArray userName = facebookClient.executeFQL("SELECT name FROM user WHERE  uid=100007007563976");
			JSONArray pages = facebookClient
					.executeFQL("SELECT page_id, name, page_url FROM page WHERE page_id IN (SELECT page_id FROM page_admin WHERE uid=100007007563976)");
			facebookClient.postStatusMessage("manish Shrivastva.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
