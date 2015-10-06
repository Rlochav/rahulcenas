package com.ceostocks.model.document;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.ceostocks.common.base.Base;
import com.ceostocks.model.user.UserMaster;

@Entity
@Table(name = "USER_PROFILE_PIC")
@Where(clause = " status <> 666 ")
public class UserProfilePic extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 441795221321946577L;
	@Id
	@GeneratedValue(generator = "sq_user_profile_pic_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_user_profile_pic_id", sequenceName = "SQ_USER_PROFILE_PIC_ID", allocationSize = 1)
	@Column(name = "ID")
	private BigDecimal id;
	@Column(name = "CONTENT_TYPE")
	private String contentType;
	@Column(name = "Original_File_Name")
	private String originalFileName;
	@Column(name = "SAVED_AS")
	private String savedAs;
	@Column(name = "STATUS")
	private Integer status;
	@ManyToOne
	@JoinColumn(name = "USER_INDEX", nullable = false)
	private UserMaster userMaster;

	/**
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
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
	 * @return the originalFileName
	 */
	public String getOriginalFileName() {
		return originalFileName;
	}

	/**
	 * @param originalFileName
	 *            the originalFileName to set
	 */
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	/**
	 * @return the savedAs
	 */
	public String getSavedAs() {
		return savedAs;
	}

	/**
	 * @param savedAs
	 *            the savedAs to set
	 */
	public void setSavedAs(String savedAs) {
		this.savedAs = savedAs;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the userMaster
	 */
	public UserMaster getUserMaster() {
		return userMaster;
	}

	/**
	 * @param userMaster
	 *            the userMaster to set
	 */
	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

}
