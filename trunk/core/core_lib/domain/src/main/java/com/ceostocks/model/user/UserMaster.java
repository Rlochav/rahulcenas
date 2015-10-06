package com.ceostocks.model.user;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.ceostocks.common.base.Base;
import com.ceostocks.model.document.UserProfilePic;
import com.ceostocks.model.ecom.Company;
import com.ceostocks.model.social.page.UserPage;

@Entity
@Table(name = "USER_MASTER")
public class UserMaster extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5130376860371248016L;

	@Id
	@GeneratedValue(generator = "sq_user_index", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_user_index", sequenceName = "SQ_USER_INDEX", allocationSize = 1)
	@Column(name = "USER_INDEX")
	private BigDecimal userIndex;
	@Column(name = "USER_ID")
	private String userId;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL_ID", unique = true)
	private String emailId;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "USER_TYPE")
	private Integer userType = 1;
	@Column(name = "SEX")
	private Integer sex;
	@Column(name = "DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(name = "COUNTRY")
	private Integer country;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	@Column(name = "ROW_VERSION")
	@Version
	private Integer rowVersion;
	@Column(name = "ACTIVATE_CODE")
	private String activateCode;
	@Column(name = "TIMELINE_ID", unique = true)
	private String timeLineId;

	@OneToMany(mappedBy = "userMaster", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<UserRoles> userRoles = new ArrayList<UserRoles>();
	@OneToMany(mappedBy = "userMaster", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@Where(clause = "status<>666")
	private List<UserProfilePic> userProfilePics = new ArrayList<UserProfilePic>();

	@OneToMany(mappedBy = "userMaster", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserPage> userPages = new HashSet<UserPage>();
	@OneToMany(mappedBy = "userMaster", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Company> companies = new HashSet<Company>();

	@OneToOne(fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	private UserSession userSession;
	@OneToMany(fetch = FetchType.LAZY)
	@Fetch(FetchMode.SELECT)
	private List<UserSessionLog> userSessionLogs = new ArrayList<UserSessionLog>();

	public UserMaster() {
		// orm use
	}

	/**
	 * @return the userIndex
	 */
	public BigDecimal getUserIndex() {
		return userIndex;
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
	 * @return the sex
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the country
	 */
	public Integer getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(Integer country) {
		this.country = country;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive == null ? true : isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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
	 * @return the userRoles
	 */
	public List<UserRoles> getUserRoles() {
		return userRoles;
	}

	/**
	 * @param userRoles
	 *            the userRoles to set
	 */
	public void setUserRoles(List<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	/**
	 * @return the activateCode
	 */
	public String getActivateCode() {
		return activateCode;
	}

	/**
	 * @param activateCode
	 *            the activateCode to set
	 */
	public void setActivateCode(String activateCode) {
		this.activateCode = activateCode;
	}

	/**
	 * @return the userProfilePics
	 */
	public List<UserProfilePic> getUserProfilePics() {
		return userProfilePics;
	}

	/**
	 * @param userProfilePics
	 *            the userProfilePics to set
	 */
	public void addUserProfilePics(UserProfilePic userProfilePic) {
		this.userProfilePics.add(userProfilePic);
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
	 * @return the userSession
	 */
	public UserSession getUserSession() {
		return userSession;
	}

	/**
	 * @param userSession
	 *            the userSession to set
	 */
	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}

	/**
	 * @return the userSessionLogs
	 */
	public List<UserSessionLog> getUserSessionLogs() {
		return userSessionLogs;
	}

	/**
	 * @param userSessionLogs
	 *            the userSessionLogs to set
	 */
	public void setUserSessionLogs(List<UserSessionLog> userSessionLogs) {
		this.userSessionLogs = userSessionLogs;
	}

	/*
	*//**
	 * @return the userTimelinePosts
	 */
	/*
	 * public List<TimelinePost> getUserTimelinePosts() { return
	 * userTimelinePosts; }
	 *//**
	 * @param userTimelinePosts
	 *            the userTimelinePosts to set
	 */
	/*
	 * public void addUserTimelinePosts(TimelinePost userTimelinePost) {
	 * this.userTimelinePosts.add(userTimelinePost); }
	 */

	/**
	 * @return the companies
	 */
	public Set<Company> getCompanies() {
		return companies;
	}

	/**
	 * @param companies
	 *            the companies to set
	 */
	public void addCompanies(Company company) {
		this.companies.add(company);
	}

	/**
	 * @return the timeLineId
	 */
	public String getTimeLineId() {
		return timeLineId;
	}

	/**
	 * @param timeLineId
	 *            the timeLineId to set
	 */
	public void setTimeLineId(String timeLineId) {
		this.timeLineId = timeLineId;
	}

}
