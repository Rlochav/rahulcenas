package com.app.doc.controller;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm {
	private String docType;
	private List<String> docTitle;
	private List<String> showOnPages;
	private List<MultipartFile> files;

	/**
	 * @return the docTitle
	 */
	public List<String> getDocTitle() {
		return docTitle;
	}

	/**
	 * @param docTitle
	 *            the docTitle to set
	 */
	public void setDocTitle(List<String> docTitle) {
		this.docTitle = docTitle;
	}

	/**
	 * @return the showOnPages
	 */
	public List<String> getShowOnPages() {
		return showOnPages;
	}

	/**
	 * @param showOnPages
	 *            the showOnPages to set
	 */
	public void setShowOnPages(List<String> showOnPages) {
		this.showOnPages = showOnPages;
	}

	/**
	 * @return the files
	 */
	public List<MultipartFile> getFiles() {
		return files;
	}

	/**
	 * @param files
	 *            the files to set
	 */
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
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
}
