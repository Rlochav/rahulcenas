package com.app.model.merchantlevel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.app.model.getcitydealz.SubLevelMasterPK;

@Embeddable
public class MerchantLevelPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5059092572746428266L;

	@Column(name = "MerchantId")
	private Integer merchantId;
	@Column(name = "LevelId")
	private Integer levelId;

	public MerchantLevelPK() {
	}

	public MerchantLevelPK(Integer merchantId, Integer levelId) {
		this.levelId = levelId;
		this.merchantId = merchantId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SubLevelMasterPK))
			return false;
		MerchantLevelPK other = (MerchantLevelPK) obj;
		return other.getLevelId() == this.getLevelId() && other.getMerchantId() == this.getMerchantId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashResult = 1;
		hashResult = hashResult * prime + ((levelId == null ? 0 : levelId.hashCode()));
		hashResult = hashResult * prime + ((merchantId == null ? 0 : merchantId.hashCode()));
		return hashResult;
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
	 * @return the levelId
	 */
	public Integer getLevelId() {
		return levelId;
	}

	/**
	 * @param levelId
	 *            the levelId to set
	 */
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

}
