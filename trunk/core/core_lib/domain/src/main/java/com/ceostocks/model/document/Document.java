package com.ceostocks.model.document;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;
import com.ceostocks.model.social.post.TimelinePost;

/**
 * Document is design for handling all document.
 * 
 * @author Arun
 */
@NamedQueries({ @NamedQuery(name = "Document.findByFileSavedAs", query = "select d from Document d where d.fileSavedAs=:fileSavedAs") })
@Entity
@Table(name = "DOCUMENT")
public class Document extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7077774105749343187L;
	@Id
	@GeneratedValue(generator = "sq_doc_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_doc_id", sequenceName = "SQ_DOC_ID", allocationSize = 1)
	@Column(name = "ID")
	private BigDecimal id;
	@Column(name = "ORIGINAL_FILE_NAME")
	private String originalFileName;
	@Column(name = "FILE_SAVED_AS")
	private String fileSavedAs;
	@Column(name = "FILE_SAVED_AS_THUMBNAIL")
	private String fileSavedAsThumbnail;
	@Column(name = "STATUS")
	private Integer status;
	@Column(name = "CONTENT_TYPE")
	private String contentType;
	@Column(name = "FILE_SIZE")
	private String fileSize;
	@Column(name = "FILE_TYPE")
	private Integer fileType;
	@Column(name = "FILE_LOCATION")
	private String fileLocation;

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "POST_ID", nullable = true)
	private TimelinePost timelinePost;

	public Document() {
		// orm use
	}

	/**
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
	public Document(String originalFileName, String fileSavedAs, String fileSavedAsThumbnail, Integer status, String contentType, String fileSize,
			Integer fileType, String fileLocation) {
		super();
		this.originalFileName = originalFileName;
		this.fileSavedAs = fileSavedAs;
		this.fileSavedAsThumbnail = fileSavedAsThumbnail;
		this.status = status;
		this.contentType = contentType;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.fileLocation = fileLocation;
	}

	/**
	 * @return the timelinePost
	 */
	public TimelinePost getTimelinePost() {
		return timelinePost;
	}

	/**
	 * @param timelinePost
	 *            the timelinePost to set
	 */
	public void setTimelinePost(TimelinePost timelinePost) {
		this.timelinePost = timelinePost;
	}

	/**
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
	}

	/**
	 * @return the originalFileName
	 */
	public String getOriginalFileName() {
		return originalFileName;
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
	public Integer getStatus() {
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
	public Integer getFileType() {
		return fileType;
	}

	/**
	 * @return the fileLocation
	 */
	public String getFileLocation() {
		return fileLocation;
	}

}
