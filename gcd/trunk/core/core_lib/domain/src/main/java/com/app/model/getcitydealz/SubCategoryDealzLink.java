package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subcategorydealzlink")
public class SubCategoryDealzLink implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2219235221410270265L;

	@EmbeddedId
	private SubCategoryDealzLinkPK subCategoryDealzLinkPK;

	/**
	 * @return the subCategoryDealzLinkPK
	 */
	public SubCategoryDealzLinkPK getSubCategoryDealzLinkPK() {
		return subCategoryDealzLinkPK;
	}

	/**
	 * @param subCategoryDealzLinkPK
	 *            the subCategoryDealzLinkPK to set
	 */
	public void setSubCategoryDealzLinkPK(SubCategoryDealzLinkPK subCategoryDealzLinkPK) {
		this.subCategoryDealzLinkPK = subCategoryDealzLinkPK;
	}
}
