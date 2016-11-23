package com.app.model.metadata;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gcd_content_manager")
public class GcdRightHandRailsNav implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8852740137119756075L;
	@Id
	@Column(name = "Id")
	private Integer id;
	@Column(name = "SectionTitle")
	private String sectionTitle;
	@Column(name = "Align")
	private Integer align;
	@Column(name = "ShowOnPage")
	private Integer showOnPage;
	@Column(name = "Content")
	private String content;

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
	 * @return the sectionTitle
	 */
	public String getSectionTitle() {
		return sectionTitle;
	}

	/**
	 * @param sectionTitle
	 *            the sectionTitle to set
	 */
	public void setSectionTitle(String sectionTitle) {
		this.sectionTitle = sectionTitle;
	}

	/**
	 * @return the align
	 */
	public Integer getAlign() {
		return align;
	}

	/**
	 * @param align
	 *            the align to set
	 */
	public void setAlign(Integer align) {
		this.align = align;
	}

	/**
	 * @return the showOnPage
	 */
	public Integer getShowOnPage() {
		return showOnPage;
	}

	/**
	 * @param showOnPage
	 *            the showOnPage to set
	 */
	public void setShowOnPage(Integer showOnPage) {
		this.showOnPage = showOnPage;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
