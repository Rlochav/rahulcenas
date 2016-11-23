package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "merchantfeature")
public class MerchantFeature extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6037843911648890174L;

	@EmbeddedId
	private MerchantFeaturePK merchantFeaturePK;

	/**
	 * @return the merchantFeaturePK
	 */
	public MerchantFeaturePK getMerchantFeaturePK() {
		return merchantFeaturePK;
	}

	/**
	 * @param merchantFeaturePK
	 *            the merchantFeaturePK to set
	 */
	public void setMerchantFeaturePK(MerchantFeaturePK merchantFeaturePK) {
		this.merchantFeaturePK = merchantFeaturePK;
	}
}
