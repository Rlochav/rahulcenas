package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.app.model.documentsmanagemant.DocumentLinkPK;

@Embeddable
public class CategoryDealzLinkPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2846839484372755389L;

	private Integer dealzId;
	private Integer categoryId;
	private Integer merchantId;

	public CategoryDealzLinkPK(Integer dealzId, Integer categoryId, Integer merchantId) {
		this.dealzId = dealzId;
		this.categoryId = categoryId;
		this.merchantId = merchantId;
	}

	public CategoryDealzLinkPK() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashValue = 1;
		hashValue = hashValue * prime + ((dealzId == null) ? 0 : dealzId.hashCode());
		hashValue = hashValue * prime + ((categoryId == null) ? 0 : categoryId.hashCode());
		hashValue = hashValue * prime + ((merchantId == null) ? 0 : merchantId.hashCode());
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof DocumentLinkPK))
			return false;
		CategoryDealzLinkPK other = (CategoryDealzLinkPK) obj;
		return other.getDealzId() == this.getDealzId() && other.getCategoryId() == this.getCategoryId() && other.getMerchantId() == this.getMerchantId();
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
