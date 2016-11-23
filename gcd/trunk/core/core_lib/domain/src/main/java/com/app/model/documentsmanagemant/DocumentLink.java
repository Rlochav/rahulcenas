package com.app.model.documentsmanagemant;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "documentlink")
public class DocumentLink extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1449837610144995001L;

	@EmbeddedId
	private DocumentLinkPK documentLinkPK;
	@Column(name = "DocType")
	private Integer docType;
	@Column(name = "DealId")
	private Integer dealId;

	/**
	 * @return the documentLinkPK
	 */
	public DocumentLinkPK getDocumentLinkPK() {
		return documentLinkPK;
	}

	/**
	 * @param documentLinkPK
	 *            the documentLinkPK to set
	 */
	public void setDocumentLinkPK(DocumentLinkPK documentLinkPK) {
		this.documentLinkPK = documentLinkPK;
	}

	/**
	 * @return the docType
	 */
	public Integer getDocType() {
		return docType;
	}

	/**
	 * @param docType
	 *            the docType to set
	 */
	public void setDocType(Integer docType) {
		this.docType = docType;
	}

	/**
	 * @return the dealId
	 */
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @param dealId
	 *            the dealId to set
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

}
