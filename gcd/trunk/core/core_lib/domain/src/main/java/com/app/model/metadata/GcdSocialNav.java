package com.app.model.metadata;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gcd_meta_nav")
public class GcdSocialNav implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8036362141862704682L;

	@Id
	@Column(name = "Id")
	private Integer id;
	@Column(name = "ImageAlt")
	private String imageAlt;
	@Column(name = "Url")
	private String url;
	@Column(name = "ShowOnPage")
	private Integer showOnPage;
	@Column(name = "Type")
	private Integer type;
	@Column(name = "Align")
	private Integer align;
	@Column(name = "PageText")
	private String pageText;
	@Column(name = "IsEditable")
	private Integer isEditable;
	@Column(name = "ElementId")
	private String elementId;
	@Column(name = "ElementClass")
	private String elementClass;
	@Column(name = "BreakGroup")
	private Integer breakGroup;

	/**
	 * @return the isEditable
	 */
	public boolean getIsEditable() {
		return isEditable == 1 ? true : false;
	}

	/**
	 * @param isEditable
	 *            the isEditable to set
	 */
	public void setIsEditable(boolean isEditable) {
		this.isEditable = (isEditable == true ? 1 : 0);
	}

	/**
	 * @return the pageText
	 */
	public String getPageText() {
		return pageText;
	}

	/**
	 * @param pageText
	 *            the pageText to set
	 */
	public void setPageText(String pageText) {
		this.pageText = pageText;
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
	 * @return the imageAlt
	 */
	public String getImageAlt() {
		return imageAlt;
	}

	/**
	 * @param imageAlt
	 *            the imageAlt to set
	 */
	public void setImageAlt(String imageAlt) {
		this.imageAlt = imageAlt;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
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
	 * @return the elementId
	 */
	public String getElementId() {
		return elementId;
	}

	/**
	 * @param elementId
	 *            the elementId to set
	 */
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	/**
	 * @return the elementClass
	 */
	public String getElementClass() {
		return elementClass;
	}

	/**
	 * @param elementClass
	 *            the elementClass to set
	 */
	public void setElementClass(String elementClass) {
		this.elementClass = elementClass;
	}

	/**
	 * @return the breakGroup
	 */
	public Integer getBreakGroup() {
		return breakGroup;
	}

	/**
	 * @param breakGroup
	 *            the breakGroup to set
	 */
	public void setBreakGroup(Integer breakGroup) {
		this.breakGroup = breakGroup;
	}

}
