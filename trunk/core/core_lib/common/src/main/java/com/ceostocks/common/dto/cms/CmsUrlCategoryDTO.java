package com.ceostocks.common.dto.cms;

import java.util.ArrayList;
import java.util.List;

public class CmsUrlCategoryDTO {
	private String id;
	private String name;
	private String isActive;
	private String categoryType;
	private List<CmsUrlDTO> cmsUrls = new ArrayList<>();

	public CmsUrlCategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param isActive
	 * @param cmsUrls
	 */
	public CmsUrlCategoryDTO(String id, String name, String isActive, String categoryType, List<CmsUrlDTO> cmsUrls) {
		this.id = id;
		this.name = name;
		this.isActive = isActive;
		this.categoryType = categoryType;
		this.cmsUrls = cmsUrls;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
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

	/**
	 * @return the cmsUrls
	 */
	public List<CmsUrlDTO> getCmsUrls() {
		return cmsUrls;
	}

	/**
	 * @param cmsUrls
	 *            the cmsUrls to set
	 */
	public void setCmsUrls(List<CmsUrlDTO> cmsUrls) {
		this.cmsUrls = cmsUrls;
	}

	/**
	 * @return the categoryType
	 */
	public String getCategoryType() {
		return categoryType;
	}

	/**
	 * @param categoryType
	 *            the categoryType to set
	 */
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

}
