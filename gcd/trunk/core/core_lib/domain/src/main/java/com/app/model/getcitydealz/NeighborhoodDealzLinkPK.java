package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.app.model.documentsmanagemant.DocumentLinkPK;

@Embeddable
public class NeighborhoodDealzLinkPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7918093329924380245L;

	@Column(name = "DealzId")
	private Integer dealzId;
	@Column(name = "NeighbourhoodId")
	private Integer neighbourhoodId;
	@Column(name = "MerchantId")
	private Integer merchantId;

	public NeighborhoodDealzLinkPK(Integer dealzId, Integer neighbourhoodId, Integer merchantId) {
		this.dealzId = dealzId;
		this.merchantId = merchantId;
		this.neighbourhoodId = neighbourhoodId;
	}

	public NeighborhoodDealzLinkPK() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashValue = 1;
		hashValue = hashValue * prime + ((dealzId == null) ? 0 : dealzId.hashCode());
		hashValue = hashValue * prime + ((neighbourhoodId == null) ? 0 : neighbourhoodId.hashCode());
		hashValue = hashValue * prime + ((merchantId == null) ? 0 : merchantId.hashCode());
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof DocumentLinkPK))
			return false;
		NeighborhoodDealzLinkPK other = (NeighborhoodDealzLinkPK) obj;
		return other.getDealzId() == this.getDealzId() && other.getNeighbourhoodId() == this.getNeighbourhoodId()
				&& other.getMerchantId() == this.getMerchantId();
	}

	/**
	 * @return the dealzId
	 */
	public Integer getDealzId() {
		return dealzId;
	}

	/**
	 * @param dealzId
	 *            the dealzId to set
	 */
	public void setDealzId(Integer dealzId) {
		this.dealzId = dealzId;
	}

	/**
	 * @return the neighbourhoodId
	 */
	public Integer getNeighbourhoodId() {
		return neighbourhoodId;
	}

	/**
	 * @param neighbourhoodId
	 *            the neighbourhoodId to set
	 */
	public void setNeighbourhoodId(Integer neighbourhoodId) {
		this.neighbourhoodId = neighbourhoodId;
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
