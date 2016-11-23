package com.app.model.subscriber;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "subscribercategorylink")
public class SubscriberCategoryLink extends BaseNoUDF<Serializable> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3113483331639664989L;

	@Id
	@Column(name = "LinkId")
	private Integer linkId;
	@Column(name = "CategoryId")
	private Integer categoryId;

	/**
	 * @return the linkId
	 */
	public Integer getLinkId() {
		return linkId;
	}

	/**
	 * @param linkId
	 *            the linkId to set
	 */
	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
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

}
