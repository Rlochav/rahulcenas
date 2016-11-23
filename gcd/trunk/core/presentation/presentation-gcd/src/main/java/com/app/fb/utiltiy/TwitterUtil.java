package com.app.fb.utiltiy;

import java.io.IOException;
import java.util.Arrays;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterUtil {

	public static void postOnTwitter(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret, String message)
			throws IOException, TwitterException {
		TwitterFactory twitterFactory = new TwitterFactory();
		Twitter twitter = twitterFactory.getInstance();
		twitter.setOAuthConsumer(consumerKey, consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));
		StatusUpdate statusUpdate = new StatusUpdate(message);
		Status status = twitter.updateStatus(statusUpdate);
		System.out.println("status.toString() = " + status.toString());
		System.out.println("status.getInReplyToScreenName() = " + status.getInReplyToScreenName());
		System.out.println("status.getSource() = " + status.getSource());
		System.out.println("status.getText() = " + status.getText());
		System.out.println("status.getContributors() = " + Arrays.toString(status.getContributors()));
		System.out.println("status.getCreatedAt() = " + status.getCreatedAt());
		System.out.println("status.getCurrentUserRetweetId() = " + status.getCurrentUserRetweetId());
		System.out.println("status.getGeoLocation() = " + status.getGeoLocation());
		System.out.println("status.getId() = " + status.getId());
		System.out.println("status.getInReplyToStatusId() = " + status.getInReplyToStatusId());
		System.out.println("status.getInReplyToUserId() = " + status.getInReplyToUserId());
		System.out.println("status.getPlace() = " + status.getPlace());
		System.out.println("status.getRetweetCount() = " + status.getRetweetCount());
		System.out.println("status.getRetweetedStatus() = " + status.getRetweetedStatus());
		System.out.println("status.getUser() = " + status.getUser());
		System.out.println("status.getAccessLevel() = " + status.getAccessLevel());
		System.out.println("status.getHashtagEntities() = " + Arrays.toString(status.getHashtagEntities()));
		System.out.println("status.getMediaEntities() = " + Arrays.toString(status.getMediaEntities()));
		if (status.getRateLimitStatus() != null) {
			System.out.println("status.getRateLimitStatus().getLimit() = " + status.getRateLimitStatus().getLimit());
			System.out.println("status.getRateLimitStatus().getRemaining() = " + status.getRateLimitStatus().getRemaining());
			System.out.println("status.getRateLimitStatus().getResetTimeInSeconds() = " + status.getRateLimitStatus().getResetTimeInSeconds());
			System.out.println("status.getRateLimitStatus().getSecondsUntilReset() = " + status.getRateLimitStatus().getSecondsUntilReset());
			//System.out.println("status.getRateLimitStatus().getRemainingHits() = " + status.getRateLimitStatus().getRemainingHits());
		}
		System.out.println("status.getURLEntities() = " + Arrays.toString(status.getURLEntities()));
		System.out.println("status.getUserMentionEntities() = " + Arrays.toString(status.getUserMentionEntities()));

	}
}
