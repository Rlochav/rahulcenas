package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MerchantDealzPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5386011395196980454L;

	@Column(name = "MerchantId")
	private Integer merchantId;
	@Column(name = "CityId")
	private Integer citySectionId;
	@Column(name = "DealzId")
	private Integer dealzId;

	public MerchantDealzPK() {
	}

	public MerchantDealzPK(Integer dealzId, Integer merchantId, Integer citySectionId) {
		this.dealzId = dealzId;
		this.merchantId = merchantId;
		this.citySectionId = citySectionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashValue = 1;
		hashValue = hashValue * prime + ((dealzId == null) ? 0 : dealzId.hashCode());
		hashValue = hashValue * prime + ((merchantId == null) ? 0 : merchantId.hashCode());
		hashValue = hashValue * prime + ((citySectionId == null) ? 0 : citySectionId.hashCode());
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MerchantDealzPK))
			return false;
		MerchantDealzPK other = (MerchantDealzPK) obj;
		return other.getDealzId() == this.getDealzId() && other.getMerchantId() == this.getMerchantId() && other.getCitySectionId() == this.getCitySectionId();
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

	/**
	 * @return the citySectionId
	 */
	public Integer getCitySectionId() {
		return citySectionId;
	}

	/**
	 * @param citySectionId
	 *            the citySectionId to set
	 */
	public void setCitySectionId(Integer citySectionId) {
		this.citySectionId = citySectionId;
	}

}