package com.app.model.category;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "subcategory")
public class SubCategory extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3131315647749831575L;

	@EmbeddedId
	private SubCategoryPK subCategoryPK;
	@Column(name = "SubCategoryName")
	private String subCategoryName;

	/**
	 * @return the subCategoryPK
	 */
	public SubCategoryPK getSubCategoryPK() {
		return subCategoryPK;
	}

	/**
	 * @param subCategoryPK
	 *            the subCategoryPK to set
	 */
	public void setSubCategoryPK(SubCategoryPK subCategoryPK) {
		this.subCategoryPK = subCategoryPK;
	}

	/**
	 * @return the subCategoryName
	 */
	public String getSubCategoryName() {
		return subCategoryName;
	}

	/**
	 * @param subCategoryName
	 *            the subCategoryName to set
	 */
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

}
