package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MerchantCategoryPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 609054181370127715L;

	@Column(name = "MerchantId")
	private Integer merchantId;
	@Column(name = "MasterCategory")
	private Integer masterCategory;
	@Column(name = "CategoryId")
	private Integer categoryId;

	public MerchantCategoryPK(Integer merchantId, Integer masterCategory, Integer categoryId) {
		this.merchantId = merchantId;
		this.masterCategory = masterCategory;
		this.categoryId = categoryId;
	}

	public MerchantCategoryPK() {

	}

	@Override
	public int hashCode() {
		final int prime = 51;
		int hashValue = 1;
		hashValue = prime * hashValue + ((categoryId == null) ? 0 : categoryId.hashCode());
		hashValue = prime * hashValue + ((merchantId == null) ? 0 : merchantId.hashCode());
		hashValue = prime * hashValue + ((masterCategory == null) ? 0 : masterCategory.hashCode());
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MerchantCategoryPK))
			return false;
		MerchantCategoryPK other = (MerchantCategoryPK) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (merchantId == null) {
			if (other.merchantId != null)
				return false;
		} else if (!merchantId.equals(other.merchantId))
			return false;

		if (masterCategory == null) {
			if (other.masterCategory != null)
				return false;
		} else if (!masterCategory.equals(other.masterCategory))
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
	 * @return the masterCategory
	 */
	public Integer getMasterCategory() {
		return masterCategory;
	}

	/**
	 * @param masterCategory
	 *            the masterCategory to set
	 */
	public void setMasterCategory(Integer masterCategory) {
		this.masterCategory = masterCategory;
	}

	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
