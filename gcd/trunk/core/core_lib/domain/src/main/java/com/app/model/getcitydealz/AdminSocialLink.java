package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "adminsociallink")
public class AdminSocialLink extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4242278059832305773L;

	@EmbeddedId
	private AdminSocialLinkPK adminSocialLinkPK;
	@Column(name = "FBFanPage")
	private String fbFanPage;
	@Column(name = "TwitterAcc")
	private String twitterAcc;
	@Column(name = "ConsumerKey")
	private String consumerKey;
	@Column(name = "ConsumerSecret")
	private String consumerSecret;
	@Column(name = "OAuthToken")
	private String oAuthToken;
	@Column(name = "OAuthSecret")
	private String oAuthSecret;

	/**
	 * @return the adminSocialLinkPK
	 */
	public AdminSocialLinkPK getAdminSocialLinkPK() {
		return adminSocialLinkPK;
	}

	/**
	 * @param adminSocialLinkPK
	 *            the adminSocialLinkPK to set
	 */
	public void setAdminSocialLinkPK(AdminSocialLinkPK adminSocialLinkPK) {
		this.adminSocialLinkPK = adminSocialLinkPK;
	}

	/**
	 * @return the fbFanPage
	 */
	public String getFbFanPage() {
		return fbFanPage;
	}

	/**
	 * @param fbFanPage
	 *            the fbFanPage to set
	 */
	public void setFbFanPage(String fbFanPage) {
		this.fbFanPage = fbFanPage;
	}

	/**
	 * @return the twitterAcc
	 */
	public String getTwitterAcc() {
		return twitterAcc;
	}

	/**
	 * @param twitterAcc
	 *            the twitterAcc to set
	 */
	public void setTwitterAcc(String twitterAcc) {
		this.twitterAcc = twitterAcc;
	}

	/**
	 * @return the consumerKey
	 */
	public String getConsumerKey() {
		return consumerKey;
	}

	/**
	 * @param consumerKey
	 *            the consumerKey to set
	 */
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	/**
	 * @return the consumerSecret
	 */
	public String getConsumerSecret() {
		return consumerSecret;
	}

	/**
	 * @param consumerSecret
	 *            the consumerSecret to set
	 */
	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	/**
	 * @return the oAuthToken
	 */
	public String getoAuthToken() {
		return oAuthToken;
	}

	/**
	 * @param oAuthToken
	 *            the oAuthToken to set
	 */
	public void setoAuthToken(String oAuthToken) {
		this.oAuthToken = oAuthToken;
	}

	/**
	 * @return the oAuthSecret
	 */
	public String getoAuthSecret() {
		return oAuthSecret;
	}

	/**
	 * @param oAuthSecret
	 *            the oAuthSecret to set
	 */
	public void setoAuthSecret(String oAuthSecret) {
		this.oAuthSecret = oAuthSecret;
	}

}
