package com.ceostocks.common.dto.cms;

import com.ceostocks.common.dto.BaseDTO;

public class CmsUrlDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1378016717050668454L;
	private String urlId;
	private String name;
	private String isActive;

	public CmsUrlDTO() {

	}

	public CmsUrlDTO(String urlId, String name, String isActive) {
		this.urlId = urlId;
		this.name = name;
		this.isActive = isActive;
	}

	/**
	 * @return the urlId
	 */
	public String getUrlId() {
		return urlId;
	}

	/**
	 * @param urlId
	 *            the urlId to set
	 */
	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
