package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.app.model.documentsmanagemant.DocumentLinkPK;

@Embeddable
public class MerchantSubCategoryPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2080906022774277154L;

	@Column(name = "CategoryId")
	private Integer categoryId;
	@Column(name = "SubCategoryId")
	private Integer subCategoryId;
	@Column(name = "MerchantId")
	private Integer merchantId;

	public MerchantSubCategoryPK(Integer categoryId, Integer subCategoryId, Integer merchantId) {
		this.categoryId = categoryId;
		this.subCategoryId = subCategoryId;
		this.merchantId = merchantId;
	}

	public MerchantSubCategoryPK() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashValue = 1;
		hashValue = hashValue * prime + ((categoryId == null) ? 0 : categoryId.hashCode());
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
		MerchantSubCategoryPK other = (MerchantSubCategoryPK) obj;
		return other.getCategoryId() == this.getCategoryId() && other.getSubCategoryId() == this.getSubCategoryId()
				&& other.getMerchantId() == this.getMerchantId();
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
