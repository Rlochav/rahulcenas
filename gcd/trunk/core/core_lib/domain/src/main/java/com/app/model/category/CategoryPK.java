package com.app.model.category;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CategoryPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5759870527739088028L;

	@Column(name = "CategoryId")
	private Integer categoryId;
	@Column(name = "MasterCategoryId")
	private Integer masterCategoryId;

	public CategoryPK() {
	}

	public CategoryPK(Integer categoryId, Integer masterCategoryId) {
		this.categoryId = categoryId;
		this.masterCategoryId = masterCategoryId;
	}

	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the masterCategoryId
	 */
	public Integer getMasterCategoryId() {
		return masterCategoryId;
	}

	/**
	 * @param masterCategoryId
	 *            the masterCategoryId to set
	 */
	public void setMasterCategoryId(Integer masterCategoryId) {
		this.masterCategoryId = masterCategoryId;
	}

	@Override
	public int hashCode() {
		final int prime = 51;
		int hashValue = 1;
		hashValue = prime * hashValue + ((categoryId == null) ? 0 : categoryId.hashCode());
		hashValue = prime * hashValue + ((masterCategoryId == null) ? 0 : masterCategoryId.hashCode());
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CategoryPK))
			return false;
		CategoryPK other = (CategoryPK) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (masterCategoryId == null) {
			if (other.masterCategoryId != null)
				return false;
		} else if (!masterCategoryId.equals(other.masterCategoryId))
			return false;
		return true;
	}
}
