package com.ceostocks.common.dto;

import java.io.Serializable;

public class DocumentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4966899592756117888L;

	private String id;
	private String orignalFileName;
	private String fileSavedAs;
	private String fileSavedAsThumbnail;
	private String status;
	private String contentType;
	private String fileSize;
	private String fileType;
	private String fileLocation;

	public DocumentDTO() {

	}

	/**
	 * @param id
	 * @param originalFileName
	 * @param fileSavedAs
	 * @param fileSavedAsThumbnail
	 * @param status
	 * @param contentType
	 * @param fileSize
	 * @param fileType
	 * @param fileLocation
	 * @param docType
	 */
	public DocumentDTO(String id, String orignalFileName, String fileSavedAs, String fileSavedAsThumbnail, String status, String contentType, String fileSize,
			String fileType, String fileLocation) {
		super();
		this.id = id;
		this.orignalFileName = orignalFileName;
		this.fileSavedAs = fileSavedAs;
		this.fileSavedAsThumbnail = fileSavedAsThumbnail;
		this.status = status;
		this.contentType = contentType;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.fileLocation = fileLocation;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the originalFileName
	 */
	public String getOrignalFileName() {
		return orignalFileName;
	}

	/**
	 * @return the fileSavedAs
	 */
	public String getFileSavedAs() {
		return fileSavedAs;
	}

	/**
	 * @return the fileSavedAsThumbnail
	 */
	public String getFileSavedAsThumbnail() {
		return fileSavedAsThumbnail;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @return the fileSize
	 */
	public String getFileSize() {
		return fileSize;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @return the fileLocation
	 */
	public String getFileLocation() {
		return fileLocation;
	}

}
