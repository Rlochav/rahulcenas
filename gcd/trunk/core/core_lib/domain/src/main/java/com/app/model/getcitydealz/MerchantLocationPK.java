package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MerchantLocationPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1479741012831679483L;

	@Column(name = "MerchantId")
	private Integer merchantId;
	@Column(name = "LocationId")
	private Integer locationId;

	public MerchantLocationPK(Integer merchantId, Integer locationId) {
		this.locationId = locationId;
		this.merchantId = merchantId;
	}

	public MerchantLocationPK() {

	}

	@Override
	public int hashCode() {
		final int prime = 51;
		int hashValue = 1;
		hashValue = prime * hashValue + ((merchantId == null) ? 0 : merchantId.hashCode());
		hashValue = prime * hashValue + ((locationId == null) ? 0 : locationId.hashCode());
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MerchantLocationPK))
			return false;
		MerchantLocationPK other = (MerchantLocationPK) obj;
		if (merchantId == null) {
			if (other.merchantId != null)
				return false;
		} else if (!merchantId.equals(other.merchantId))
			return false;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		return true;
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
	 * @return the locationId
	 */
	public Integer getLocationId() {
		return locationId;
	}

	/**
	 * @param locationId
	 *            the locationId to set
	 */
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

}
