package com.app.model.documentsmanagemant;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DocumentLinkPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -488538418179507060L;

	@Column(name = "MerchantId")
	private Integer merchantId;
	@Column(name = "DocId")
	private Integer docId;

	public DocumentLinkPK(Integer merchantId, Integer docId) {
		this.merchantId = merchantId;
		this.docId = docId;
	}

	public DocumentLinkPK() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashValue = 1;
		hashValue = hashValue * prime + ((docId == null) ? 0 : docId.hashCode());
		hashValue = hashValue * prime + ((merchantId == null) ? 0 : merchantId.hashCode());
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof DocumentLinkPK))
			return false;
		DocumentLinkPK other = (DocumentLinkPK) obj;
		return other.getDocId() == this.getDocId() && other.getMerchantId() == this.getMerchantId();
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
	 * @return the docId
	 */
	public Integer getDocId() {
		return docId;
	}

	/**
	 * @param docId
	 *            the docId to set
	 */
	public void setDocId(Integer docId) {
		this.docId = docId;
	}

}
