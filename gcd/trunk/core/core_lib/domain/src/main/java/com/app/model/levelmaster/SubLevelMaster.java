package com.app.model.levelmaster;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;
import com.app.model.getcitydealz.SubLevelMasterPK;

@Entity
@Table(name = "sublevelmaster")
public class SubLevelMaster extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1028321471734141288L;

	@EmbeddedId
	private SubLevelMasterPK subLevelMasterPK;
	@Column(name = "SubLevelType")
	private String subLevelType;
	@Column(name = "IsActive")
	private String isActive;

	/**
	 * @return the subLevelMasterPK
	 */
	public SubLevelMasterPK getSubLevelMasterPK() {
		return subLevelMasterPK;
	}

	/**
	 * @param subLevelMasterPK
	 *            the subLevelMasterPK to set
	 */
	public void setSubLevelMasterPK(SubLevelMasterPK subLevelMasterPK) {
		this.subLevelMasterPK = subLevelMasterPK;
	}

	/**
	 * @return the subLevelType
	 */
	public String getSubLevelType() {
		return subLevelType;
	}

	/**
	 * @param subLevelType
	 *            the subLevelType to set
	 */
	public void setSubLevelType(String subLevelType) {
		this.subLevelType = subLevelType;
	}

	/**
	 * @return the isActive
	 */
	public String getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
