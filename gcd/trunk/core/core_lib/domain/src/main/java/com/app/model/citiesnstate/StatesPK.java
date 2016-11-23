package com.app.model.citiesnstate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StatesPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6581936496100806360L;

	@Column(name = "CityId")
	private Integer cityId;
	@Column(name = "StateId")
	private Integer stateId;

	public StatesPK() {

	}

	public StatesPK(Integer stateId, Integer cityId) {
		this.cityId = cityId;
		this.stateId = stateId;
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
	 * @return the stateId
	 */
	public Integer getStateId() {
		return stateId;
	}

	/**
	 * @param stateId
	 *            the stateId to set
	 */
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashValue = 1;
		hashValue = hashValue * prime + ((cityId == null) ? 0 : cityId.hashCode());
		hashValue = hashValue * prime + ((stateId == null) ? 0 : stateId.hashCode());
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof StatesPK))
			return false;
		StatesPK other = (StatesPK) obj;
		return other.getCityId() == this.getCityId() && other.getStateId() == this.getStateId();
	}

}
