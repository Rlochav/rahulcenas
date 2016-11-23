package com.app.model.socialconnections;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SocialConnectionsPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4761070376684099654L;
	@Column(name = "SocialConnectionId")
	private Integer socialConnectionId;
	@Column(name = "MerchantId")
	private Integer merchantId;

	public SocialConnectionsPK(Integer socialConnectionId, Integer merchantId) {
		this.merchantId = merchantId;
		this.socialConnectionId = socialConnectionId;
	}

	public SocialConnectionsPK() {

	}

	@Override
	public int hashCode() {
		final int prime = 51;
		int hashValue = 1;
		hashValue = prime * hashValue + (merchantId == null ? 0 : merchantId.hashCode());
		hashValue = prime * hashValue + (socialConnectionId == null ? 0 : socialConnectionId.hashCode());
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SocialConnectionsPK))
			return false;
		SocialConnectionsPK other = (SocialConnectionsPK) obj;
		return other.getMerchantId() == this.getMerchantId() && other.getSocialConnectionId() == this.getSocialConnectionId();
	}

	/**
	 * @return the socialConnectionId
	 */
	public Integer getSocialConnectionId() {
		return socialConnectionId;
	}

	/**
	 * @param socialConnectionId
	 *            the socialConnectionId to set
	 */
	public void setSocialConnectionId(Integer socialConnectionId) {
		this.socialConnectionId = socialConnectionId;
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
