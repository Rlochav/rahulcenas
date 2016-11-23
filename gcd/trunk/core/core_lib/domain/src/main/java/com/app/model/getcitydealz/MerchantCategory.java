package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "merchantcategory")
public class MerchantCategory extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5520994462168371086L;

	@EmbeddedId
	private MerchantCategoryPK merchantCategoryPK;

	/**
	 * @return the merchantCategoryPK
	 */
	public MerchantCategoryPK getMerchantCategoryPK() {
		return merchantCategoryPK;
	}

	/**
	 * @param merchantCategoryPK
	 *            the merchantCategoryPK to set
	 */
	public void setMerchantCategoryPK(MerchantCategoryPK merchantCategoryPK) {
		this.merchantCategoryPK = merchantCategoryPK;
	}
}
