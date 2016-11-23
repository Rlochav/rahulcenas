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
@Table(name = "usersessionlog")
public class UserSessionLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7477615779009245158L;

	@Id
	@Column(name = "LogId")
	private Integer logId;

	@Column(name = "SessionId")
	private Long sessionId;

	@Column(name = "UserIndex", nullable = false)
	private Integer userIndex;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LoginDateTime")
	private Date loginDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastAccessDateTime")
	private Date lastAccessDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastAttamptDateTime")
	private Date lastAttamptDateTime;

	@Column(name = "IPAddress")
	private String ipAddress;

	@Column(name = "PresentConcurrency")
	private Integer presentConcurrency;

	@Version
	@Column(name = "RowVersion", nullable = false)
	private Integer rowVersion;

	/**
	 * @return the logId
	 */
	public Integer getLogId() {
		return logId;
	}

	/**
	 * @param logId
	 *            the logId to set
	 */
	public void setLogId(Integer logId) {
		this.logId = logId;
	}

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
	 * @return the loginDateTime
	 */
	public Date getLoginDateTime() {
		return loginDateTime;
	}

	/**
	 * @param loginDateTime
	 *            the loginDateTime to set
	 */
	public void setLoginDateTime(Date loginDateTime) {
		this.loginDateTime = loginDateTime;
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
	 * @return the lastAttamptDateTime
	 */
	public Date getLastAttamptDateTime() {
		return lastAttamptDateTime;
	}

	/**
	 * @param lastAttamptDateTime
	 *            the lastAttamptDateTime to set
	 */
	public void setLastAttamptDateTime(Date lastAttamptDateTime) {
		this.lastAttamptDateTime = lastAttamptDateTime;
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
	 * @return the presentConcurrency
	 */
	public Integer getPresentConcurrency() {
		return presentConcurrency;
	}

	/**
	 * @param presentConcurrency
	 *            the presentConcurrency to set
	 */
	public void setPresentConcurrency(Integer presentConcurrency) {
		this.presentConcurrency = presentConcurrency;
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
