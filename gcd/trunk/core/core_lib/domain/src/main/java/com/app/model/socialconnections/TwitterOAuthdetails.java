package com.app.model.socialconnections;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "twitteroauthdetails")
public class TwitterOAuthdetails extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6197641289966975450L;

	@EmbeddedId
	private TwitterOAuthdetailsPK twitterOAuthdetailsPK;
	@Column(name = "ConsumerKey")
	private String ConsumerKey;
	@Column(name = "ConsumerSecret")
	private String consumerSecret;
	@Column(name = "OAuthToken")
	private String oAuthToken;
	@Column(name = "OAuthSecret")
	private String oAuthSecret;

	/**
	 * @return the twitterOAuthdetailsPK
	 */
	public TwitterOAuthdetailsPK getTwitterOAuthdetailsPK() {
		return twitterOAuthdetailsPK;
	}

	/**
	 * @param twitterOAuthdetailsPK
	 *            the twitterOAuthdetailsPK to set
	 */
	public void setTwitterOAuthdetailsPK(TwitterOAuthdetailsPK twitterOAuthdetailsPK) {
		this.twitterOAuthdetailsPK = twitterOAuthdetailsPK;
	}

	/**
	 * @return the consumerKey
	 */
	public String getConsumerKey() {
		return ConsumerKey;
	}

	/**
	 * @param consumerKey
	 *            the consumerKey to set
	 */
	public void setConsumerKey(String consumerKey) {
		ConsumerKey = consumerKey;
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
