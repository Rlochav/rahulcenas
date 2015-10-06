package com.ceostocks.model.user;

public class UserMasterFilter {

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String EMAIL_ID = "emailId";
	public static final String TIMELINE_ID = "timeLineId";
	public static final String ACTIVATE_CODE = "activateCode";

	private String firstName;
	private String lastName;
	private String emailId;
	private String timeLineId;
	private String activateCode;

	private boolean ofFlag;

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
	 * @return the ofFlag
	 */
	public boolean getOfFlag() {
		return ofFlag;
	}

	/**
	 * @param ofFlag
	 *            the ofFlag to set
	 */
	public void setOfFlag(boolean ofFlag) {
		this.ofFlag = ofFlag;
	}

}
