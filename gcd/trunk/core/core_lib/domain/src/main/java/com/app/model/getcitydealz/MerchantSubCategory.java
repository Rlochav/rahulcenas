package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "merchantsubcategory")
public class MerchantSubCategory extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4833370058349198286L;

	@EmbeddedId
	private MerchantSubCategoryPK merchantSubCategoryPK;
	@Column(name = "CategoryType")
	private Integer categoryType;

	/**
	 * @return the merchantSubCategoryPK
	 */
	public MerchantSubCategoryPK getMerchantSubCategoryPK() {
		return merchantSubCategoryPK;
	}

	/**
	 * @param merchantSubCategoryPK
	 *            the merchantSubCategoryPK to set
	 */
	public void setMerchantSubCategoryPK(MerchantSubCategoryPK merchantSubCategoryPK) {
		this.merchantSubCategoryPK = merchantSubCategoryPK;
	}

	/**
	 * @return the categoryType
	 */
	public Integer getCategoryType() {
		return categoryType;
	}

	/**
	 * @param categoryType
	 *            the categoryType to set
	 */
	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}
}
