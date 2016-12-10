package com.app.common.dto;

import java.io.Serializable;
import java.util.List;

public class GcdMetaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2650396435511802879L;

	private String id;
	private String imageAlt;
	private String text;
	private String url;
	private String showOnPage;
	private String type;
	private String align;
	private String imagePath;
	private String pageText;
	private String isEditable;
	private String pageTitle;
	private String elementId;
	private String elementClass;
	private String breakGroup;
	private List<GcdMetaDTO> gcdMetaDTOs;

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
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
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
	public String getShowOnPage() {
		return showOnPage;
	}

	/**
	 * @param showOnPage
	 *            the showOnPage to set
	 */
	public void setShowOnPage(String showOnPage) {
		this.showOnPage = showOnPage;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the align
	 */
	public String getAlign() {
		return align;
	}

	/**
	 * @param align
	 *            the align to set
	 */
	public void setAlign(String align) {
		this.align = align;
	}

	/**
	 * @return the gcdMetaDTOs
	 */
	public List<GcdMetaDTO> getGcdMetaDTOs() {
		return gcdMetaDTOs;
	}

	/**
	 * @param gcdMetaDTOs
	 *            the gcdMetaDTOs to set
	 */
	public void setGcdMetaDTOs(List<GcdMetaDTO> gcdMetaDTOs) {
		this.gcdMetaDTOs = gcdMetaDTOs;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath
	 *            the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
	 * @return the isEditable
	 */
	public String getIsEditable() {
		return isEditable;
	}

	/**
	 * @param isEditable
	 *            the isEditable to set
	 */
	public void setIsEditable(String isEditable) {
		this.isEditable = isEditable;
	}

	/**
	 * @return the pageTitle
	 */
	public String getPageTitle() {
		return pageTitle;
	}

	/**
	 * @param pageTitle
	 *            the pageTitle to set
	 */
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
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
	public String getBreakGroup() {
		return breakGroup;
	}

	/**
	 * @param breakGroup
	 *            the breakGroup to set
	 */
	public void setBreakGroup(String breakGroup) {
		this.breakGroup = breakGroup;
	}

}
