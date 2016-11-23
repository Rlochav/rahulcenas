package com.app.model.documentsmanagemant;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "documents")
public class Documents extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5954962947932852072L;

	@Id
	@Column(name = "DocID")
	private Integer docId;
	@Column(name = "OrignalFileName")
	private String orignalFileName;
	@Column(name = "DocExt")
	private String docExt;
	@Column(name = "DocSize")
	private String docSize;
	@Column(name = "ParentFolderPath")
	private String parentFolderPath;
	@Column(name = "FileSavedAs")
	private String fileSavedAs;
	@Column(name = "ContentType")
	private String contentType;
	@Column(name = "DocumentTitle")
	private String documentTitle;
	@Column(name = "ShowOnPage")
	private Integer showOnPage;

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

}
