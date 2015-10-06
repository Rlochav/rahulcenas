package com.ceostocks.model.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "USER_SESSION_LOG")
public class UserSessionLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6207103862660120574L;
	@Id
	@GeneratedValue
	@Column(name = "LOG_ID")
	private Integer logId;
	@Column(name = "SESSION_ID")
	private Integer userSessionId;
	@Column(name = "USER_INDEX")
	private BigDecimal userIndex;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_ACCESS_DATE_TIME")
	private Date lastAccessDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_ATTAMPT_DATE_TIME")
	private Date lastAttamptDateTime;
	@Column(name = "IP_ADDRESS")
	private String ipAddress;
	@Version
	@Column(name = "ROW_VERSION")
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
	 * @return the userSession
	 */
	public Integer getUserSessionId() {
		return userSessionId;
	}

	/**
	 * @param userSession
	 *            the userSession to set
	 */
	public void setUserSessionId(Integer userSessionId) {
		this.userSessionId = userSessionId;
	}

	/**
	 * @return the userIndex
	 */
	public BigDecimal getUserIndex() {
		return userIndex;
	}

	/**
	 * @param userIndex
	 *            the userIndex to set
	 */
	public void setUserIndex(BigDecimal userIndex) {
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

	public void create(Integer userSessionId, BigDecimal userIndex, String ipAddress) {

		this.setUserSessionId(userSessionId);
		this.setUserIndex(userIndex);

		this.setLastAccessDateTime(new Date());

		this.setLastAttamptDateTime(new Date());

		this.setIpAddress(ipAddress);
	}
}
