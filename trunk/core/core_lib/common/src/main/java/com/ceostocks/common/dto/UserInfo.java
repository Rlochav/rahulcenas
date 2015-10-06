package com.ceostocks.common.dto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserInfo extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4724785269307003774L;

	private BigDecimal userIndex;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private String dob;
	private String country;
	private String profilePic;
	private String userSessionId;
	private String timelineId;

	private Map<String, String> permissionMap;

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
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the permissionMap
	 */
	public Map<String, String> getPermissionMap() {
		return permissionMap;
	}

	/**
	 * @param permissionMap
	 *            the permissionMap to set
	 */
	public void putPermissionMap(String key, String value) {
		permissionMap = new HashMap<String, String>();
		permissionMap.put(key, value);
	}

	/**
	 * @return the profilePic
	 */
	public String getProfilePic() {
		return profilePic;
	}

	/**
	 * @param profilePic
	 *            the profilePic to set
	 */
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	/**
	 * @return the userSessionId
	 */
	public String getUserSessionId() {
		return userSessionId;
	}

	/**
	 * @param userSessionId
	 *            the userSessionId to set
	 */
	public void setUserSessionId(String userSessionId) {
		this.userSessionId = userSessionId;
	}

	/**
	 * @return the timelineId
	 */
	public String getTimelineId() {
		return timelineId;
	}

	/**
	 * @param timelineId
	 *            the timelineId to set
	 */
	public void setTimelineId(String timelineId) {
		this.timelineId = timelineId;
	}

}
