package com.app.getcitydealz.dto;

import java.io.Serializable;

public class CommonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7430911218074292612L;
	private String cityId;
	/**
	 * @return the cityId
	 */
	public String getCityId() {
		return cityId;
	}
	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

}
