package com.app.model.category;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SubCategoryPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5238040695394420915L;
	@Column(name = "SubCategoryId")
	private Integer subCategoryId;
	@Column(name = "CategoryId")
	private Integer categoryId;

	public SubCategoryPK() {
	}

	public SubCategoryPK(Integer subCategoryId, Integer categoryId) {
		this.subCategoryId = subCategoryId;
		this.categoryId = categoryId;
	}

	/**
	 * @return the subCategoryId
	 */
	public Integer getSubCategoryId() {
		return subCategoryId;
	}

	/**
	 * @param subCategoryId
	 *            the subCategoryId to set
	 */
	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	/**
	 * @return the categoryId
	 */
	public Integer getMasterCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setMasterCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public int hashCode() {
		final int prime = 51;
		int hashValue = 1;
		hashValue = prime * hashValue + ((subCategoryId == null) ? 0 : subCategoryId.hashCode());
		hashValue = prime * hashValue + ((categoryId == null) ? 0 : categoryId.hashCode());
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SubCategoryPK))
			return false;
		SubCategoryPK other = (SubCategoryPK) obj;
		if (subCategoryId == null) {
			if (other.subCategoryId != null)
				return false;
		} else if (!subCategoryId.equals(other.subCategoryId))
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		return true;
	}
}
