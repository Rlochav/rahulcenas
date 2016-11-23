package com.app.getcitydealz.dto;

import java.io.Serializable;
import java.util.List;

public class NeighborhoodDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1838574171644830681L;

	private String neighborhoodId;
	private String neighborhoodName;
	private String cityId;
	private String cityName;
	private String jsonMessage;
	private String count;
	private String cityCode;
	private List<NeighborhoodDTO> neighborhoodDTOs;

	/**
	 * @return the neighborhoodId
	 */
	public String getNeighborhoodId() {
		return neighborhoodId;
	}

	/**
	 * @param neighborhoodId
	 *            the neighborhoodId to set
	 */
	public void setNeighborhoodId(String neighborhoodId) {
		this.neighborhoodId = neighborhoodId;
	}

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
	 * @return the cityId
	 */
	public String getCityId() {
		return cityId;
	}

	/**
	 * @param cityId
	 *            the cityId to set
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName
	 *            the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the jsonMessage
	 */
	public String getJsonMessage() {
		return jsonMessage;
	}

	/**
	 * @param jsonMessage
	 *            the jsonMessage to set
	 */
	public void setJsonMessage(String jsonMessage) {
		this.jsonMessage = jsonMessage;
	}

	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * @return the neighborhoodDTOs
	 */
	public List<NeighborhoodDTO> getNeighborhoodDTOs() {
		return neighborhoodDTOs;
	}

	/**
	 * @param neighborhoodDTOs
	 *            the neighborhoodDTOs to set
	 */
	public void setNeighborhoodDTOs(List<NeighborhoodDTO> neighborhoodDTOs) {
		this.neighborhoodDTOs = neighborhoodDTOs;
	}

	/**
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

}
