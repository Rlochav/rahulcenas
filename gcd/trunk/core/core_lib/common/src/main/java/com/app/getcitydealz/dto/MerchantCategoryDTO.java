package com.app.getcitydealz.dto;

import java.io.Serializable;

public class MerchantCategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4434340823064707475L;

	private String merchantId;
	private String masterCategory;
	private String categoryId;
	private String subCatgoryId;
	private String categoryType;

	/**
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId
	 *            the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return the masterCategory
	 */
	public String getMasterCategory() {
		return masterCategory;
	}

	/**
	 * @param masterCategory
	 *            the masterCategory to set
	 */
	public void setMasterCategory(String masterCategory) {
		this.masterCategory = masterCategory;
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the subCatgoryId
	 */
	public String getSubCatgoryId() {
		return subCatgoryId;
	}

	/**
	 * @param subCatgoryId
	 *            the subCatgoryId to set
	 */
	public void setSubCatgoryId(String subCatgoryId) {
		this.subCatgoryId = subCatgoryId;
	}

	/**
	 * @return the categoryType
	 */
	public String getCategoryType() {
		return categoryType;
	}

	/**
	 * @param categoryType
	 *            the categoryType to set
	 */
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

}
