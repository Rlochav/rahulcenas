package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.app.model.category.CategoryPK;

@Embeddable
public class MerchantFeaturePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6601766222370518295L;

	private Integer merchantId;
	private Integer featureId;

	public MerchantFeaturePK(Integer merchantId, Integer featureId) {
		this.featureId = featureId;
		this.merchantId = merchantId;
	}

	public MerchantFeaturePK() {

	}

	@Override
	public int hashCode() {
		final int prime = 51;
		int hashValue = 1;
		hashValue = prime * hashValue + ((featureId == null) ? 0 : featureId.hashCode());
		hashValue = prime * hashValue + ((merchantId == null) ? 0 : merchantId.hashCode());
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CategoryPK))
			return false;
		MerchantFeaturePK other = (MerchantFeaturePK) obj;
		if (featureId == null) {
			if (other.featureId != null)
				return false;
		} else if (!featureId.equals(other.featureId))
			return false;
		if (merchantId == null) {
			if (other.merchantId != null)
				return false;
		} else if (!merchantId.equals(other.merchantId))
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
	 * @return the featureId
	 */
	public Integer getFeatureId() {
		return featureId;
	}

	/**
	 * @param featureId
	 *            the featureId to set
	 */
	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

}
