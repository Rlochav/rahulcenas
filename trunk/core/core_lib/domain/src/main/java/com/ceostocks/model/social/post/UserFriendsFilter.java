package com.ceostocks.model.social.post;

import java.math.BigDecimal;

public class UserFriendsFilter {
	public static final String USER_FRIENDS_PK = "userFriendsPK";
	public static final String REQUESTER_ID = "requesterId";
	public static final String ACCEPTER_ID = "accepterId";
	public static final String IS_REQUEST_ACCEPTED = "isRequestAccepted";
	public static final String IS_SEEN = "isSeen";

	private BigDecimal requesterId;
	private BigDecimal accepterId;
	private Boolean isRequestAccepted;
	private Boolean isSeen;

	/**
	 * @return the requesterId
	 */
	public BigDecimal getRequesterId() {
		return requesterId;
	}

	/**
	 * @param requesterId
	 *            the requesterId to set
	 */
	public void setRequesterId(BigDecimal requesterId) {
		this.requesterId = requesterId;
	}

	/**
	 * @return the accepterId
	 */
	public BigDecimal getAccepterId() {
		return accepterId;
	}

	/**
	 * @param accepterId
	 *            the accepterId to set
	 */
	public void setAccepterId(BigDecimal accepterId) {
		this.accepterId = accepterId;
	}

	/**
	 * @return the isRequestAccepted
	 */
	public Boolean getIsRequestAccepted() {
		return isRequestAccepted;
	}

	/**
	 * @param isRequestAccepted
	 *            the isRequestAccepted to set
	 */
	public void setIsRequestAccepted(Boolean isRequestAccepted) {
		this.isRequestAccepted = isRequestAccepted;
	}

	/**
	 * @return the isSeen
	 */
	public Boolean getIsSeen() {
		return isSeen;
	}

	/**
	 * @param isSeen
	 *            the isSeen to set
	 */
	public void setIsSeen(Boolean isSeen) {
		this.isSeen = isSeen;
	}

}
