package com.app.model.merchantlevel;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "merchantlevel")
public class MerchantLevel extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4970562269576735710L;

	@EmbeddedId
	private MerchantLevelPK merchantLevelPK;

	/**
	 * @return the merchantLevelPK
	 */
	public MerchantLevelPK getMerchantLevelPK() {
		return merchantLevelPK;
	}

	/**
	 * @param merchantLevelPK
	 *            the merchantLevelPK to set
	 */
	public void setMerchantLevelPK(MerchantLevelPK merchantLevelPK) {
		this.merchantLevelPK = merchantLevelPK;
	}

}
