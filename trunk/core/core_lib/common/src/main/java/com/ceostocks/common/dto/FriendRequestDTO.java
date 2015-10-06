package com.ceostocks.common.dto;

public class FriendRequestDTO {
	private String friendRequestFrom;
	private String friendRequestTo;
	private String isRequestRequestAccepted;
	
	public FriendRequestDTO(){
		
	}

	/**
	 * @param friendRequestFrom
	 * @param friendRequestTo
	 * @param isRequestRequestAccepted
	 */
	public FriendRequestDTO(String friendRequestFrom, String friendRequestTo, String isRequestRequestAccepted) {
		super();
		this.friendRequestFrom = friendRequestFrom;
		this.friendRequestTo = friendRequestTo;
		this.isRequestRequestAccepted = isRequestRequestAccepted;
	}

	/**
	 * @return the friendRequestFrom
	 */
	public String getFriendRequestFrom() {
		return friendRequestFrom;
	}

	/**
	 * @param friendRequestFrom
	 *            the friendRequestFrom to set
	 */
	public void setFriendRequestFrom(String friendRequestFrom) {
		this.friendRequestFrom = friendRequestFrom;
	}

	/**
	 * @return the friendRequestTo
	 */
	public String getFriendRequestTo() {
		return friendRequestTo;
	}

	/**
	 * @param friendRequestTo
	 *            the friendRequestTo to set
	 */
	public void setFriendRequestTo(String friendRequestTo) {
		this.friendRequestTo = friendRequestTo;
	}

	/**
	 * @return the isRequestRequestAccepted
	 */
	public String getIsRequestRequestAccepted() {
		return isRequestRequestAccepted;
	}

	/**
	 * @param isRequestRequestAccepted
	 *            the isRequestRequestAccepted to set
	 */
	public void setIsRequestRequestAccepted(String isRequestRequestAccepted) {
		this.isRequestRequestAccepted = isRequestRequestAccepted;
	}

}
