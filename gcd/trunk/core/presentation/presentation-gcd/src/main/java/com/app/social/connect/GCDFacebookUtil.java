package com.app.social.connect;

import java.util.ArrayList;
import java.util.List;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;

public class GCDFacebookUtil {

	public static List<String> getLatestFbFeeds(String userName, int numFeeds) {
		List<String> fbFeeds = null;
		try {
			Facebook facebook = new FacebookFactory().getInstance();
			facebook.setOAuthAppId("1499701620271988", "852c7ce94e03bd6b0f3b9ace25b6c529");
			facebook.setOAuthAccessToken(new AccessToken(
					"CAACeRoCfBzMBAAV92HZA039HUNLz43PdIirskyshdEcoVZCS7p0wmaVeV74acbe0tKb6IDRGetwgTGX8Br8SjcXbMYpsrEMfb2jwFmIsijCJlZB80o8OY0na0S3IbTZCyZAMKgBGfSeLACEquwtSgsw9yMO07PPKCzhtsch3WZAkuVv4Ads9JRCvm5AzmvSUbqPXC9iLZCYjPrlwG3qyMbi"));
			User user = facebook.getUser(userName);
			ResponseList<Post> posts = facebook.getFeed(user.getId());
			if (posts != null) {
				int i = 0;
				fbFeeds = new ArrayList<String>();
				for (Post post : posts) {
					if (post.getMessage() != null && post.getMessage().length() > 0)
						if (post.getLink() != null)
							fbFeeds.add("<a target='_blank' href=" + post.getLink() + ">" + post.getMessage() + "</a>");
					if (numFeeds == (1 + i))
						break;
					i++;
				}
				if (fbFeeds.size() == 0)
					fbFeeds.add("No Post Found.");
			}
		} catch (FacebookException e) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@Facebook API Fail@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@: " + e.getMessage());
		}
		return fbFeeds;
	}
}
