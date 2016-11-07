package com.ceostocks.model.cms;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.ceostocks.common.base.Base;

@MappedSuperclass
public abstract class CmsContent extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 838608905705592893L;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "CONTENT")
	private String content;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
