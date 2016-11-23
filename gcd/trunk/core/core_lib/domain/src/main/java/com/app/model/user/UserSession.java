package com.app.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "usersession")
public class UserSession implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8689481654527565105L;

	@Id
	@Column(name = "SessionId")
	private Long sessionId;

	@Column(name = "UserIndex")
	private Integer userIndex;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastAccessDateTime")
	private Date lastAccessDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastLoginDateTime")
	private Date lastLoginDateTime;

	@Column(name = "IPAddress")
	private String ipAddress;

	@Version
	@Column(name = "RowVersion", nullable = false)
	private Integer rowVersion;

	/**
	 * @return the sessionId
	 */
	public Long getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId
	 *            the sessionId to set
	 */
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the userIndex
	 */
	public Integer getUserIndex() {
		return userIndex;
	}

	/**
	 * @param userIndex
	 *            the userIndex to set
	 */
	public void setUserIndex(Integer userIndex) {
		this.userIndex = userIndex;
	}

	/**
	 * @return the lastAccessDateTime
	 */
	public Date getLastAccessDateTime() {
		return lastAccessDateTime;
	}

	/**
	 * @param lastAccessDateTime
	 *            the lastAccessDateTime to set
	 */
	public void setLastAccessDateTime(Date lastAccessDateTime) {
		this.lastAccessDateTime = lastAccessDateTime;
	}

	/**
	 * @return the lastLoginDateTime
	 */
	public Date getLastLoginDateTime() {
		return lastLoginDateTime;
	}

	/**
	 * @param lastLoginDateTime
	 *            the lastLoginDateTime to set
	 */
	public void setLastLoginDateTime(Date lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress
	 *            the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @return the rowVersion
	 */
	public Integer getRowVersion() {
		return rowVersion;
	}

	/**
	 * @param rowVersion
	 *            the rowVersion to set
	 */
	public void setRowVersion(Integer rowVersion) {
		this.rowVersion = rowVersion;
	}

}
