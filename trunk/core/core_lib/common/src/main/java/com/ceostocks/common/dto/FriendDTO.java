package com.ceostocks.common.dto;

public class FriendDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4371645003428999669L;

	private String userIndex;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private String dob;
	private String country;
	private String profilePic;
	private String userSessionId;
	private String timelineId;
	private Integer userFriendStatus;

	public FriendDTO() {

	}

	/**
	 * @param userIndex
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param emailId
	 * @param dob
	 * @param country
	 * @param profilePic
	 * @param userSessionId
	 * @param timelineId
	 */
	public FriendDTO(String userIndex, String firstName, String middleName, String lastName, String emailId, String dob, String country, String profilePic,
			String userSessionId, String timelineId, Integer userFriendStatus) {
		super();
		this.userIndex = userIndex;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.dob = dob;
		this.country = country;
		this.profilePic = profilePic;
		this.userSessionId = userSessionId;
		this.timelineId = timelineId;
		this.userFriendStatus = userFriendStatus;
	}

	/**
	 * @return the userIndex
	 */
	public String getUserIndex() {
		return userIndex;
	}

	/**
	 * @param userIndex
	 *            the userIndex to set
	 */
	public void setUserIndex(String userIndex) {
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

	/**
	 * @return the userFriendStatus
	 */
	public Integer getUserFriendStatus() {
		return userFriendStatus;
	}

	/**
	 * @param userFriendStatus
	 *            the userFriendStatus to set
	 */
	public void setUserFriendStatus(Integer userFriendStatus) {
		this.userFriendStatus = userFriendStatus;
	}

}
