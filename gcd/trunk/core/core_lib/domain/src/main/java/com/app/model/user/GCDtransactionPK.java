package com.app.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.app.model.documentsmanagemant.DocumentLinkPK;

@Embeddable
public class GCDtransactionPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -528424859901980551L;

	@Column(name = "DealId")
	private Integer dealId;
	@Column(name = "SubscriberId")
	private Integer subscriberId;

	public GCDtransactionPK(Integer dealId, Integer subscriberId) {
		this.dealId = dealId;
		this.subscriberId = subscriberId;
	}

	public GCDtransactionPK() {

	}

	/**
	 * @return the dealId
	 */
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @param dealId
	 *            the dealId to set
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	/**
	 * @return the subscriberId
	 */
	public Integer getSubscriberId() {
		return subscriberId;
	}

	/**
	 * @param subscriberId
	 *            the subscriberId to set
	 */
	public void setSubscriberId(Integer subscriberId) {
		this.subscriberId = subscriberId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashValue = 1;
		hashValue = hashValue * prime + ((dealId == null) ? 0 : dealId.hashCode());
		hashValue = hashValue * prime + ((subscriberId == null) ? 0 : subscriberId.hashCode());
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof DocumentLinkPK))
			return false;
		GCDtransactionPK other = (GCDtransactionPK) obj;
		return other.getDealId() == this.getDealId() && other.getSubscriberId() == this.getSubscriberId();
	}

}
