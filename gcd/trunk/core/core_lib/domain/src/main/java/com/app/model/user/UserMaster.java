package com.app.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "usermaster")
public class UserMaster extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5139118176322442032L;

	@Id
	@Column(name = "UserIndex")
	private Integer userIndex;

	@Column(name = "EmailId")
	private String emailId;

	@NotEmpty(message = "User Id is mandatory.")
	@Column(name = "UserId")
	private String userId;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "MiddleName")
	private String middleName;

	@Column(name = "LastName")
	private String lastName;

	@NotEmpty(message = "Password Id is mandatory.")
	@Column(name = "Password")
	private String password;

	@Column(name = "Status")
	private Integer status;

	@Column(name = "UserType")
	private Integer userType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastVisitDateTime")
	private Date lastVisitDateTime;

	@Column(name = "FailedAttamptCount")
	private Integer failedAttamptCount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastAttamptDateTime")
	private Date lastAttamptDateTime;

	@Column(name = "Phone")
	private String phone;

	@Column(name = "Fax")
	private String fax;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UserActiveTillDate")
	private Date userActiveTillDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DateOfBirth")
	private Date dateOfBirth;

	@Column(name = "DOBVerifyReq")
	private Integer dobVerifyReq;

	private String errorMessage;

	public UserMaster() {
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
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the userType
	 */
	public Integer getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	/**
	 * @return the lastVisitDateTime
	 */
	public Date getLastVisitDateTime() {
		return lastVisitDateTime;
	}

	/**
	 * @param lastVisitDateTime
	 *            the lastVisitDateTime to set
	 */
	public void setLastVisitDateTime(Date lastVisitDateTime) {
		this.lastVisitDateTime = lastVisitDateTime;
	}

	/**
	 * @return the failedAttamptCount
	 */
	public Integer getFailedAttamptCount() {
		return failedAttamptCount;
	}

	/**
	 * @param failedAttamptCount
	 *            the failedAttamptCount to set
	 */
	public void setFailedAttamptCount(Integer failedAttamptCount) {
		this.failedAttamptCount = failedAttamptCount;
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
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax
	 *            the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the userActiveTillDate
	 */
	public Date getUserActiveTillDate() {
		return userActiveTillDate;
	}

	/**
	 * @param userActiveTillDate
	 *            the userActiveTillDate to set
	 */
	public void setUserActiveTillDate(Date userActiveTillDate) {
		this.userActiveTillDate = userActiveTillDate;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the dobVerifyReq
	 */
	public Integer getDobVerifyReq() {
		return dobVerifyReq;
	}

	/**
	 * @param dobVerifyReq
	 *            the dobVerifyReq to set
	 */
	public void setDobVerifyReq(Integer dobVerifyReq) {
		this.dobVerifyReq = dobVerifyReq;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
