package com.app.model.socialconnections;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "socialconnections")
public class SocialConnections extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2758785317738305408L;

	@EmbeddedId
	private SocialConnectionsPK socialConnectionsPK;
	@Column(name = "FacebookFanPage")
	private String facebookFanPage;
	@Column(name = "TwitterAccount")
	private String twitterAccount;
	@Column(name = "TwitterScreenName")
	private String twitterScreenName;
	@Column(name = "FourSquareAccount")
	private String fourSquareAccount;
	@Column(name = "YelpAccount")
	private String yelpAccount;
	@Column(name = "FlickerAccount")
	private String flickerAccount;
	@Column(name = "YoutubeAccount")
	private String youtubeAccount;
	@Column(name = "LinkedinProfile")
	private String linkedinProfile;
	@Column(name = "TripAdvisorAccount")
	private String tripAdvisorAccount;
	@Column(name = "MeetupAccount")
	private String meetupAccount;
	@Column(name = "OpenTableAccount")
	private String openTableAccount;
	@Column(name = "PinterestAccount")
	private String pinterestAccount;
	@Column(name = "GPlusAccount")
	private String gPlusAccount;
	@Column(name = "InstagramAccount")
	private String instagramAccount;
	@Column(name = "EtsyAccount")
	private String etsyAccount;
	@Column(name = "TumblrAccount")
	private String tumblrAccount;

	@Column(name = "FacebookFanPageChk")
	private String facebookFanPageChk;
	@Column(name = "TwitterAccountChk")
	private String twitterAccountChk;
	@Column(name = "FourSquareAccountChk")
	private String fourSquareAccountChk;
	@Column(name = "YelpAccountChk")
	private String yelpAccountChk;
	@Column(name = "FlickerAccountChk")
	private String flickerAccountChk;
	@Column(name = "YoutubeAccountChk")
	private String youtubeAccountChk;
	@Column(name = "LinkedinProfileChk")
	private String linkedinProfileChk;
	@Column(name = "TripAdvisorAccountChk")
	private String tripAdvisorAccountChk;
	@Column(name = "MeetupAccountChk")
	private String meetupAccountChk;
	@Column(name = "OpenTableAccountChk")
	private String openTableAccountChk;
	@Column(name = "PinterestAccountChk")
	private String pinterestAccountChk;
	@Column(name = "GPlusAccountChk")
	private String gPlusAccountChk;
	@Column(name = "InstagramAccountChk")
	private String instagramAccountChk;
	@Column(name = "EtsyAccountChk")
	private String etsyAccountChk;
	@Column(name = "TumblrAccountChk")
	private String tumblrAccountChk;

	/**
	 * @return the socialConnectionsPK
	 */
	public SocialConnectionsPK getSocialConnectionsPK() {
		return socialConnectionsPK;
	}

	/**
	 * @param socialConnectionsPK
	 *            the socialConnectionsPK to set
	 */
	public void setSocialConnectionsPK(SocialConnectionsPK socialConnectionsPK) {
		this.socialConnectionsPK = socialConnectionsPK;
	}

	/**
	 * @return the facebookFanPage
	 */
	public String getFacebookFanPage() {
		return facebookFanPage;
	}

	/**
	 * @param facebookFanPage
	 *            the facebookFanPage to set
	 */
	public void setFacebookFanPage(String facebookFanPage) {
		this.facebookFanPage = facebookFanPage;
	}

	/**
	 * @return the twitterAccount
	 */
	public String getTwitterAccount() {
		return twitterAccount;
	}

	/**
	 * @param twitterAccount
	 *            the twitterAccount to set
	 */
	public void setTwitterAccount(String twitterAccount) {
		this.twitterAccount = twitterAccount;
	}

	/**
	 * @return the fourSquareAccount
	 */
	public String getFourSquareAccount() {
		return fourSquareAccount;
	}

	/**
	 * @param fourSquareAccount
	 *            the fourSquareAccount to set
	 */
	public void setFourSquareAccount(String fourSquareAccount) {
		this.fourSquareAccount = fourSquareAccount;
	}

	/**
	 * @return the yelpAccount
	 */
	public String getYelpAccount() {
		return yelpAccount;
	}

	/**
	 * @param yelpAccount
	 *            the yelpAccount to set
	 */
	public void setYelpAccount(String yelpAccount) {
		this.yelpAccount = yelpAccount;
	}

	/**
	 * @return the flickerAccount
	 */
	public String getFlickerAccount() {
		return flickerAccount;
	}

	/**
	 * @param flickerAccount
	 *            the flickerAccount to set
	 */
	public void setFlickerAccount(String flickerAccount) {
		this.flickerAccount = flickerAccount;
	}

	/**
	 * @return the youtubeAccount
	 */
	public String getYoutubeAccount() {
		return youtubeAccount;
	}

	/**
	 * @param youtubeAccount
	 *            the youtubeAccount to set
	 */
	public void setYoutubeAccount(String youtubeAccount) {
		this.youtubeAccount = youtubeAccount;
	}

	/**
	 * @return the linkedinProfile
	 */
	public String getLinkedinProfile() {
		return linkedinProfile;
	}

	/**
	 * @param linkedinProfile
	 *            the linkedinProfile to set
	 */
	public void setLinkedinProfile(String linkedinProfile) {
		this.linkedinProfile = linkedinProfile;
	}

	/**
	 * @return the tripAdvisorAccount
	 */
	public String getTripAdvisorAccount() {
		return tripAdvisorAccount;
	}

	/**
	 * @param tripAdvisorAccount
	 *            the tripAdvisorAccount to set
	 */
	public void setTripAdvisorAccount(String tripAdvisorAccount) {
		this.tripAdvisorAccount = tripAdvisorAccount;
	}

	/**
	 * @return the meetupAccount
	 */
	public String getMeetupAccount() {
		return meetupAccount;
	}

	/**
	 * @param meetupAccount
	 *            the meetupAccount to set
	 */
	public void setMeetupAccount(String meetupAccount) {
		this.meetupAccount = meetupAccount;
	}

	/**
	 * @return the openTableAccount
	 */
	public String getOpenTableAccount() {
		return openTableAccount;
	}

	/**
	 * @param openTableAccount
	 *            the openTableAccount to set
	 */
	public void setOpenTableAccount(String openTableAccount) {
		this.openTableAccount = openTableAccount;
	}

	/**
	 * @return the pinterestAccount
	 */
	public String getPinterestAccount() {
		return pinterestAccount;
	}

	/**
	 * @param pinterestAccount
	 *            the pinterestAccount to set
	 */
	public void setPinterestAccount(String pinterestAccount) {
		this.pinterestAccount = pinterestAccount;
	}

	/**
	 * @return the facebookFanPageChk
	 */
	public String getFacebookFanPageChk() {
		return facebookFanPageChk;
	}

	/**
	 * @param facebookFanPageChk
	 *            the facebookFanPageChk to set
	 */
	public void setFacebookFanPageChk(String facebookFanPageChk) {
		this.facebookFanPageChk = facebookFanPageChk;
	}

	/**
	 * @return the twitterAccountChk
	 */
	public String getTwitterAccountChk() {
		return twitterAccountChk;
	}

	/**
	 * @param twitterAccountChk
	 *            the twitterAccountChk to set
	 */
	public void setTwitterAccountChk(String twitterAccountChk) {
		this.twitterAccountChk = twitterAccountChk;
	}

	/**
	 * @return the fourSquareAccountChk
	 */
	public String getFourSquareAccountChk() {
		return fourSquareAccountChk;
	}

	/**
	 * @param fourSquareAccountChk
	 *            the fourSquareAccountChk to set
	 */
	public void setFourSquareAccountChk(String fourSquareAccountChk) {
		this.fourSquareAccountChk = fourSquareAccountChk;
	}

	/**
	 * @return the yelpAccountChk
	 */
	public String getYelpAccountChk() {
		return yelpAccountChk;
	}

	/**
	 * @param yelpAccountChk
	 *            the yelpAccountChk to set
	 */
	public void setYelpAccountChk(String yelpAccountChk) {
		this.yelpAccountChk = yelpAccountChk;
	}

	/**
	 * @return the flickerAccountChk
	 */
	public String getFlickerAccountChk() {
		return flickerAccountChk;
	}

	/**
	 * @param flickerAccountChk
	 *            the flickerAccountChk to set
	 */
	public void setFlickerAccountChk(String flickerAccountChk) {
		this.flickerAccountChk = flickerAccountChk;
	}

	/**
	 * @return the youtubeAccountChk
	 */
	public String getYoutubeAccountChk() {
		return youtubeAccountChk;
	}

	/**
	 * @param youtubeAccountChk
	 *            the youtubeAccountChk to set
	 */
	public void setYoutubeAccountChk(String youtubeAccountChk) {
		this.youtubeAccountChk = youtubeAccountChk;
	}

	/**
	 * @return the linkedinProfileChk
	 */
	public String getLinkedinProfileChk() {
		return linkedinProfileChk;
	}

	/**
	 * @param linkedinProfileChk
	 *            the linkedinProfileChk to set
	 */
	public void setLinkedinProfileChk(String linkedinProfileChk) {
		this.linkedinProfileChk = linkedinProfileChk;
	}

	/**
	 * @return the tripAdvisorAccountChk
	 */
	public String getTripAdvisorAccountChk() {
		return tripAdvisorAccountChk;
	}

	/**
	 * @param tripAdvisorAccountChk
	 *            the tripAdvisorAccountChk to set
	 */
	public void setTripAdvisorAccountChk(String tripAdvisorAccountChk) {
		this.tripAdvisorAccountChk = tripAdvisorAccountChk;
	}

	/**
	 * @return the meetupAccountChk
	 */
	public String getMeetupAccountChk() {
		return meetupAccountChk;
	}

	/**
	 * @param meetupAccountChk
	 *            the meetupAccountChk to set
	 */
	public void setMeetupAccountChk(String meetupAccountChk) {
		this.meetupAccountChk = meetupAccountChk;
	}

	/**
	 * @return the openTableAccountChk
	 */
	public String getOpenTableAccountChk() {
		return openTableAccountChk;
	}

	/**
	 * @param openTableAccountChk
	 *            the openTableAccountChk to set
	 */
	public void setOpenTableAccountChk(String openTableAccountChk) {
		this.openTableAccountChk = openTableAccountChk;
	}

	/**
	 * @return the pinterestAccountChk
	 */
	public String getPinterestAccountChk() {
		return pinterestAccountChk;
	}

	/**
	 * @param pinterestAccountChk
	 *            the pinterestAccountChk to set
	 */
	public void setPinterestAccountChk(String pinterestAccountChk) {
		this.pinterestAccountChk = pinterestAccountChk;
	}

	/**
	 * @return the gPlusAccount
	 */
	public String getgPlusAccount() {
		return gPlusAccount;
	}

	/**
	 * @param gPlusAccount
	 *            the gPlusAccount to set
	 */
	public void setgPlusAccount(String gPlusAccount) {
		this.gPlusAccount = gPlusAccount;
	}

	/**
	 * @return the gPlusAccountChk
	 */
	public String getgPlusAccountChk() {
		return gPlusAccountChk;
	}

	/**
	 * @param gPlusAccountChk
	 *            the gPlusAccountChk to set
	 */
	public void setgPlusAccountChk(String gPlusAccountChk) {
		this.gPlusAccountChk = gPlusAccountChk;
	}

	/**
	 * @return the instagramAccount
	 */
	public String getInstagramAccount() {
		return instagramAccount;
	}

	/**
	 * @param instagramAccount
	 *            the instagramAccount to set
	 */
	public void setInstagramAccount(String instagramAccount) {
		this.instagramAccount = instagramAccount;
	}

	/**
	 * @return the etsyAccount
	 */
	public String getEtsyAccount() {
		return etsyAccount;
	}

	/**
	 * @param etsyAccount
	 *            the etsyAccount to set
	 */
	public void setEtsyAccount(String etsyAccount) {
		this.etsyAccount = etsyAccount;
	}

	/**
	 * @return the tumblrAccount
	 */
	public String getTumblrAccount() {
		return tumblrAccount;
	}

	/**
	 * @param tumblrAccount
	 *            the tumblrAccount to set
	 */
	public void setTumblrAccount(String tumblrAccount) {
		this.tumblrAccount = tumblrAccount;
	}

	/**
	 * @return the instagramAccountChk
	 */
	public String getInstagramAccountChk() {
		return instagramAccountChk;
	}

	/**
	 * @param instagramAccountChk
	 *            the instagramAccountChk to set
	 */
	public void setInstagramAccountChk(String instagramAccountChk) {
		this.instagramAccountChk = instagramAccountChk;
	}

	/**
	 * @return the etsyAccountChk
	 */
	public String getEtsyAccountChk() {
		return etsyAccountChk;
	}

	/**
	 * @param etsyAccountChk
	 *            the etsyAccountChk to set
	 */
	public void setEtsyAccountChk(String etsyAccountChk) {
		this.etsyAccountChk = etsyAccountChk;
	}

	/**
	 * @return the tumblrAccountChk
	 */
	public String getTumblrAccountChk() {
		return tumblrAccountChk;
	}

	/**
	 * @param tumblrAccountChk
	 *            the tumblrAccountChk to set
	 */
	public void setTumblrAccountChk(String tumblrAccountChk) {
		this.tumblrAccountChk = tumblrAccountChk;
	}

	/**
	 * @return the twitterScreenName
	 */
	public String getTwitterScreenName() {
		return twitterScreenName;
	}

	/**
	 * @param twitterScreenName
	 *            the twitterScreenName to set
	 */
	public void setTwitterScreenName(String twitterScreenName) {
		this.twitterScreenName = twitterScreenName;
	}

}
