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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "USER_SESSION")
public class UserSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6348281066901186742L;
	@Id
	@GeneratedValue
	@Column(name = "SESSION_ID")
	private Integer sessionId;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_ACCESS_DATE_TIME")
	private Date lastAccessDateTime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_LOGIN_DATE_TIME")
	private Date lastLoginDateTime;
	@Column(name = "IP_ADDRESS")
	private String ipAddress;
	@Version
	@Column(name = "ROW_VERSION")
	private Integer rowVersion;

	@Column(name = "USER_INDEX")
	private BigDecimal userIndex;

	public UserSession() {

	}

	/**
	 * @return the sessionId
	 */
	public Integer getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId
	 *            the sessionId to set
	 */
	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
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

	public void create(String ipAddress, BigDecimal userIndex) {
		this.setIpAddress(ipAddress);
		this.setLastLoginDateTime(new Date());
		this.setLastAccessDateTime(new Date());
		this.setUserIndex(userIndex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(sessionId).hashCode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSession other = (UserSession) obj;
		return new EqualsBuilder().append(this.sessionId, other.sessionId).build();
	}

}
