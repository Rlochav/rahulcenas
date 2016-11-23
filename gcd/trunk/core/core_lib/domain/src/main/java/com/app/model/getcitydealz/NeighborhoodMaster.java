package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "neighborhoodmaster")
public class NeighborhoodMaster extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3884561354506024719L;

	@EmbeddedId
	private NeighborhoodMasterPK neighborhoodMasterPK;
	@Column(name = "NeighborhoodName")
	private String neighborhoodName;

	/**
	 * @return the neighborhoodName
	 */
	public String getNeighborhoodName() {
		return neighborhoodName;
	}

	/**
	 * @param neighborhoodName
	 *            the neighborhoodName to set
	 */
	public void setNeighborhoodName(String neighborhoodName) {
		this.neighborhoodName = neighborhoodName;
	}

	/**
	 * @return the neighborhoodMasterPK
	 */
	public NeighborhoodMasterPK getNeighborhoodMasterPK() {
		return neighborhoodMasterPK;
	}

	/**
	 * @param neighborhoodMasterPK
	 *            the neighborhoodMasterPK to set
	 */
	public void setNeighborhoodMasterPK(NeighborhoodMasterPK neighborhoodMasterPK) {
		this.neighborhoodMasterPK = neighborhoodMasterPK;
	}

}
