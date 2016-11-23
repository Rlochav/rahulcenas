package com.app.model.socialconnections;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TwitterOAuthdetailsPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4761070376684099654L;

	@Column(name = "TwitterOAuthdetails")
	private Integer twitterOAuthdetails;
	@Column(name = "MerchantId")
	private Integer merchantId;

	public TwitterOAuthdetailsPK(Integer twitterOAuthdetails, Integer merchantId) {
		this.merchantId = merchantId;
		this.twitterOAuthdetails = twitterOAuthdetails;
	}

	public TwitterOAuthdetailsPK() {

	}

	@Override
	public int hashCode() {
		final int prime = 51;
		int hashValue = 1;
		hashValue = prime * hashValue + (merchantId == null ? 0 : merchantId.hashCode());
		hashValue = prime * hashValue + (twitterOAuthdetails == null ? 0 : twitterOAuthdetails.hashCode());
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TwitterOAuthdetailsPK))
			return false;
		TwitterOAuthdetailsPK other = (TwitterOAuthdetailsPK) obj;
		return other.getMerchantId() == this.getMerchantId() && other.getTwitterOAuthdetails() == this.getTwitterOAuthdetails();
	}

	/**
	 * @return the twitterOAuthdetails
	 */
	public Integer getTwitterOAuthdetails() {
		return twitterOAuthdetails;
	}

	/**
	 * @param twitterOAuthdetails
	 *            the twitterOAuthdetails to set
	 */
	public void setTwitterOAuthdetails(Integer twitterOAuthdetails) {
		this.twitterOAuthdetails = twitterOAuthdetails;
	}

	/**
	 * @return the merchantId
	 */
	public Integer getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId
	 *            the merchantId to set
	 */
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}

}
