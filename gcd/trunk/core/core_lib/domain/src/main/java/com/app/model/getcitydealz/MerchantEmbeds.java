package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "merchantembeds")
public class MerchantEmbeds extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8447754924651032365L;

	@Id
	@Column(name = "EmbedId")
	private Integer embedId;
	@Column(name = "MerchantId")
	private Integer merchantId;
	@Column(name = "EmbedTitle")
	@NotEmpty(message = "Embed Title can't be empty.")
	private String embedTitle;
	@Column(name = "EmbedContent")
	@NotEmpty(message = "Embed content can't be empty.")
	private String embedContent;
	@Column(name = "IsShowOnPage")
	private Boolean isShowOnPage;

	/**
	 * @return the embedId
	 */
	public Integer getEmbedId() {
		return embedId;
	}

	/**
	 * @param embedId
	 *            the embedId to set
	 */
	public void setEmbedId(Integer embedId) {
		this.embedId = embedId;
	}

	/**
	 * @return the merchantId
	 */
	public Integer getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId
	 *            the merchantId to set
	 */
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
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
	 * @return the isShowOnPage
	 */
	public Boolean getIsShowOnPage() {
		return isShowOnPage;
	}

	/**
	 * @param isShowOnPage
	 *            the isShowOnPage to set
	 */
	public void setIsShowOnPage(Boolean isShowOnPage) {
		this.isShowOnPage = isShowOnPage;
	}

}
