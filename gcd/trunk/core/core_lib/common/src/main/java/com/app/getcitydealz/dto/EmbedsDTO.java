package com.app.getcitydealz.dto;

import java.util.List;

import com.app.base.dto.BaseDTO;

public class EmbedsDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8786338765359362958L;

	private String embedId;
	private String embedContent;
	private String embedTitle;
	private String showOnPage;

	/**
	 * @return the embedId
	 */
	public String getEmbedId() {
		return embedId;
	}

	/**
	 * @param embedId
	 *            the embedId to set
	 */
	public void setEmbedId(String embedId) {
		this.embedId = embedId;
	}

	/**
	 * @return the embedContent
	 */
	public String getEmbedContent() {
		return embedContent;
	}

	/**
	 * @param embedContent
	 *            the embedContent to set
	 */
	public void setEmbedContent(String embedContent) {
		this.embedContent = embedContent;
	}

	/**
	 * @return the embedTitle
	 */
	public String getEmbedTitle() {
		return embedTitle;
	}

	/**
	 * @param embedTitle
	 *            the embedTitle to set
	 */
	public void setEmbedTitle(String embedTitle) {
		this.embedTitle = embedTitle;
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

}
