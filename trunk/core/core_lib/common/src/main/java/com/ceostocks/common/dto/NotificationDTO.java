package com.ceostocks.common.dto;

import java.io.Serializable;

/**
 * 
 * @author Arun
 *
 */
public class NotificationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5603005165396008612L;

	/**
	 * User account timelineId.
	 */
	private String timelineId;
	/**
	 * accepter/requester name.
	 */
	private String userName;
	/**
	 * Logged-in user emailId.
	 */
	private String emailId;
	/**
	 * Message code to display message.
	 */
	private String messageCode;
	
	private String profilePic;

	public NotificationDTO() {
		// framework use
	}

	/**
	 * @param timelineId
	 * @param userName
	 * @param emailId
	 * @param messageCode
	 */
	public NotificationDTO(String timelineId, String userName, String emailId, String messageCode) {
		this.timelineId = timelineId;
		this.userName = userName;
		this.emailId = emailId;
		this.messageCode = messageCode;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the messageCode
	 */
	public String getMessageCode() {
		return messageCode;
	}

	/**
	 * @param messageCode
	 *            the messageCode to set
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	/**
	 * @return the profilePic
	 */
	public String getProfilePic() {
		return profilePic;
	}

	/**
	 * @param profilePic the profilePic to set
	 */
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

}
