package com.app.model.subscriber;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "subscriberneighborhoodslink")
public class SubscriberNeighborhoodsLink extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7537082001033204226L;

	@Id
	@Column(name = "LinkId")
	private Integer linkId;
	@Column(name = "NeighborhoodId")
	private Integer neighborhoodId;

	/**
	 * @return the linkId
	 */
	public Integer getLinkId() {
		return linkId;
	}

	/**
	 * @param linkId
	 *            the linkId to set
	 */
	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	/**
	 * @return the neighborhoodId
	 */
	public Integer getNeighborhoodId() {
		return neighborhoodId;
	}

	/**
	 * @param neighborhoodId
	 *            the neighborhoodId to set
	 */
	public void setNeighborhoodId(Integer neighborhoodId) {
		this.neighborhoodId = neighborhoodId;
	}

}
