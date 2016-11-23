package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "neighborhooddealzlink")
public class NeighborhoodDealzLink extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4857322998975721190L;

	@EmbeddedId
	private NeighborhoodDealzLinkPK neighborhoodDealzLinkPK;
	@Column(name = "Processed")
	private Integer processed;
	@Column(name = "Processed1")
	private Integer processed1;

	/**
	 * @return the neighborhoodDealzLinkPK
	 */
	public NeighborhoodDealzLinkPK getNeighborhoodDealzLinkPK() {
		return neighborhoodDealzLinkPK;
	}

	/**
	 * @param neighborhoodDealzLinkPK
	 *            the neighborhoodDealzLinkPK to set
	 */
	public void setNeighborhoodDealzLinkPK(NeighborhoodDealzLinkPK neighborhoodDealzLinkPK) {
		this.neighborhoodDealzLinkPK = neighborhoodDealzLinkPK;
	}

	/**
	 * @return the processed
	 */
	public Integer getProcessed() {
		return processed;
	}

	/**
	 * @param processed
	 *            the processed to set
	 */
	public void setProcessed(Integer processed) {
		this.processed = processed;
	}

	/**
	 * @return the processed1
	 */
	public Integer getProcessed1() {
		return processed1;
	}

	/**
	 * @param processed1
	 *            the processed1 to set
	 */
	public void setProcessed1(Integer processed1) {
		this.processed1 = processed1;
	}

}
