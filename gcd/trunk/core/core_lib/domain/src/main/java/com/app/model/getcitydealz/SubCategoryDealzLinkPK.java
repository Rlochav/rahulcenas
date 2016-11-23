package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.app.model.documentsmanagemant.DocumentLinkPK;

@Embeddable
public class SubCategoryDealzLinkPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1683059414050486893L;

	private Integer dealzId;
	private Integer subCategoryId;
	private Integer merchantId;

	public SubCategoryDealzLinkPK(Integer dealzId, Integer subCategoryId, Integer merchantId) {
		this.dealzId = dealzId;
		this.subCategoryId = subCategoryId;
		this.merchantId = merchantId;
	}

	public SubCategoryDealzLinkPK() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashValue = 1;
		hashValue = hashValue * prime + ((dealzId == null) ? 0 : dealzId.hashCode());
		hashValue = hashValue * prime + ((subCategoryId == null) ? 0 : subCategoryId.hashCode());
		hashValue = hashValue * prime + ((merchantId == null) ? 0 : merchantId.hashCode());
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof DocumentLinkPK))
			return false;
		SubCategoryDealzLinkPK other = (SubCategoryDealzLinkPK) obj;
		return other.getDealzId() == this.getDealzId() && other.getSubCategoryId() == this.getSubCategoryId() && other.getMerchantId() == this.getMerchantId();
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
	 * @return the subCategoryId
	 */
	public Integer getSubCategoryId() {
		return subCategoryId;
	}

	/**
	 * @param subCategoryId
	 *            the subCategoryId to set
	 */
	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
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
