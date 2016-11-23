package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.app.model.category.SubCategoryPK;

@Embeddable
public class NeighborhoodMasterPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3567560060655130908L;

	@Column(name = "CityId")
	private Integer cityId;
	@Column(name = "NeighborhoodId")
	private Integer neighborhoodId;

	public NeighborhoodMasterPK(Integer cityId, Integer neighborhoodId) {
		this.cityId = cityId;
		this.neighborhoodId = neighborhoodId;
	}

	public NeighborhoodMasterPK() {

	}

	@Override
	public int hashCode() {
		final int prime = 51;
		int hashValue = 1;
		hashValue = prime * hashValue + ((cityId == null) ? 0 : cityId.hashCode());
		hashValue = prime * hashValue + ((neighborhoodId == null) ? 0 : neighborhoodId.hashCode());
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SubCategoryPK))
			return false;
		NeighborhoodMasterPK other = (NeighborhoodMasterPK) obj;
		if (neighborhoodId == null) {
			if (other.neighborhoodId != null)
				return false;
		} else if (!neighborhoodId.equals(other.neighborhoodId))
			return false;
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		return true;
	}

	/**
	 * @return the cityId
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @param cityId
	 *            the cityId to set
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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
