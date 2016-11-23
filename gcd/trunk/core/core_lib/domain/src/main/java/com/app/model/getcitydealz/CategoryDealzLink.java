package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorydealzlink")
public class CategoryDealzLink implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2998134979421894515L;

	@EmbeddedId
	private CategoryDealzLinkPK categoryDealzLinkPK;
	@Column(name = "Processed")
	private Integer processed;
	@Column(name = "Processed1")
	private Integer processed1;

	/**
	 * @return the categoryDealzLinkPK
	 */
	public CategoryDealzLinkPK getCategoryDealzLinkPK() {
		return categoryDealzLinkPK;
	}

	/**
	 * @param categoryDealzLinkPK
	 *            the categoryDealzLinkPK to set
	 */
	public void setCategoryDealzLinkPK(CategoryDealzLinkPK categoryDealzLinkPK) {
		this.categoryDealzLinkPK = categoryDealzLinkPK;
	}

	/**
	 * @return the processed
	 */
	public Integer getProcessed() {
		return processed;
	}

	/**
	 * @param processed
	 *            the processed to set
	 */
	public void setProcessed(Integer processed) {
		this.processed = processed;
	}

	/**
	 * @return the processed1
	 */
	public Integer getProcessed1() {
		return processed1;
	}

	/**
	 * @param processed1
	 *            the processed1 to set
	 */
	public void setProcessed1(Integer processed1) {
		this.processed1 = processed1;
	}

}
