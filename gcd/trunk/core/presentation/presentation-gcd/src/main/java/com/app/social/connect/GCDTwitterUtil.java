package com.app.social.connect;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class GCDTwitterUtil {
	public static List<String> getLatestTweets(String userName, int numTweets) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey("sEnMc6fEEAMkvGxO6tuDw26VL");
		cb.setOAuthConsumerSecret("350zr8GZlTn03FCrz9kxPYAaA7RRdHl3BxA40mMhhpSnIn0WTJ");
		cb.setOAuthAccessToken("297472757-w6CSNjX5vVMcDZk90gmdXJpZqJGoLPBcjJrvmilA");
		cb.setOAuthAccessTokenSecret("br87UMPNHTioHgrRA4ZqwProKgeXzplrWc41F6gKo9IkZ");
		Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		List<String> tweets = null;
		try {
			if (userName != null) {
				java.util.List statuses = twitter.getUserTimeline(userName);
				if (null != statuses && statuses.size() > 0) {
					tweets = new ArrayList<String>();
					for (int i = 0; i < statuses.size(); i++) {
						Status status = (Status) statuses.get(i);
						tweets.add("<a target='_blank' href=" + "https://twitter.com/" + status.getUser().getScreenName() + "/status/" + status.getId() + ">"
								+ status.getText() + "</a>");
						if (numTweets == (1 + i))
							break;
					}
					return tweets;
				}
			}
		} catch (TwitterException e) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@Twitter API Fail@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@: " + e.getMessage());
		}
		return tweets;
	}

	public static void main(String[] args) {
		getLatestTweets("Jazzy_Nola", 5);
	}
}
