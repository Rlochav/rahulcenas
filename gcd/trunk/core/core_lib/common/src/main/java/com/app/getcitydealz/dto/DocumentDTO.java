package com.app.getcitydealz.dto;

import java.util.List;

import com.app.base.dto.BaseDTO;

public class DocumentDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8181654874840865235L;

	private String docId;
	private String orignalFileName;
	private String docExt;
	private String docSize;
	private String parentFolderPath;
	private String fileSavedAs;
	private String contentType;
	private String dealzId;
	private String docType;
	private String documentTitle;
	private String showOnPage;
	private String jsonMessage;
	private String logoId;
	private String merchantId;
	private String sdf1;
	private List<DocumentDTO> documentDTOs;

	/**
	 * @return the docId
	 */
	public String getDocId() {
		return docId;
	}

	/**
	 * @param docId
	 *            the docId to set
	 */
	public void setDocId(String docId) {
		this.docId = docId;
	}

	/**
	 * @return the orignalFileName
	 */
	public String getOrignalFileName() {
		return orignalFileName;
	}

	/**
	 * @param orignalFileName
	 *            the orignalFileName to set
	 */
	public void setOrignalFileName(String orignalFileName) {
		this.orignalFileName = orignalFileName;
	}

	/**
	 * @return the docExt
	 */
	public String getDocExt() {
		return docExt;
	}

	/**
	 * @param docExt
	 *            the docExt to set
	 */
	public void setDocExt(String docExt) {
		this.docExt = docExt;
	}

	/**
	 * @return the docSize
	 */
	public String getDocSize() {
		return docSize;
	}

	/**
	 * @param docSize
	 *            the docSize to set
	 */
	public void setDocSize(String docSize) {
		this.docSize = docSize;
	}

	/**
	 * @return the parentFolderPath
	 */
	public String getParentFolderPath() {
		return parentFolderPath;
	}

	/**
	 * @param parentFolderPath
	 *            the parentFolderPath to set
	 */
	public void setParentFolderPath(String parentFolderPath) {
		this.parentFolderPath = parentFolderPath;
	}

	/**
	 * @return the fileSavedAs
	 */
	public String getFileSavedAs() {
		return fileSavedAs;
	}

	/**
	 * @param fileSavedAs
	 *            the fileSavedAs to set
	 */
	public void setFileSavedAs(String fileSavedAs) {
		this.fileSavedAs = fileSavedAs;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType
	 *            the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the dealzId
	 */
	public String getDealzId() {
		return dealzId;
	}

	/**
	 * @param dealzId
	 *            the dealzId to set
	 */
	public void setDealzId(String dealzId) {
		this.dealzId = dealzId;
	}

	/**
	 * @return the docType
	 */
	public String getDocType() {
		return docType;
	}

	/**
	 * @param docType
	 *            the docType to set
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}

	/**
	 * @return the documentTitle
	 */
	public String getDocumentTitle() {
		return documentTitle;
	}

	/**
	 * @param documentTitle
	 *            the documentTitle to set
	 */
	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
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
	 * @return the documentDTOs
	 */
	public List<DocumentDTO> getDocumentDTOs() {
		return documentDTOs;
	}

	/**
	 * @param documentDTOs
	 *            the documentDTOs to set
	 */
	public void setDocumentDTOs(List<DocumentDTO> documentDTOs) {
		this.documentDTOs = documentDTOs;
	}

	/**
	 * @return the jsonMessage
	 */
	public String getJsonMessage() {
		return jsonMessage;
	}

	/**
	 * @param jsonMessage
	 *            the jsonMessage to set
	 */
	public void setJsonMessage(String jsonMessage) {
		this.jsonMessage = jsonMessage;
	}

	/**
	 * @return the logoId
	 */
	public String getLogoId() {
		return logoId;
	}

	/**
	 * @param logoId
	 *            the logoId to set
	 */
	public void setLogoId(String logoId) {
		this.logoId = logoId;
	}

	/**
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return the sdf1
	 */
	public String getSdf1() {
		return sdf1;
	}

	/**
	 * @param sdf1 the sdf1 to set
	 */
	public void setSdf1(String sdf1) {
		this.sdf1 = sdf1;
	}

}
