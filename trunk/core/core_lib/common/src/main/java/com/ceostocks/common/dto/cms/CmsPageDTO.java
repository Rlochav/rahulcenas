package com.ceostocks.common.dto.cms;

import com.ceostocks.common.dto.BaseDTO;

public class CmsPageDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 787709621904884939L;
	private Integer id;
	private String name;
	private String desciption;
	private Boolean isActive;

	public CmsPageDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param desciption
	 * @param isActive
	 */
	public CmsPageDTO(Integer id, String name, String desciption, Boolean isActive) {
		this.id = id;
		this.name = name;
		this.desciption = desciption;
		this.isActive = isActive;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the desciption
	 */
	public String getDesciption() {
		return desciption;
	}

	/**
	 * @param desciption
	 *            the desciption to set
	 */
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
