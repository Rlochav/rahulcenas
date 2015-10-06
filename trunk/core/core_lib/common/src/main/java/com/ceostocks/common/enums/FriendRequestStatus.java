package com.ceostocks.common.enums;

public enum FriendRequestStatus {

	ADD_AS_FRIEND(1), FRIEND_REQUEST_SENT(2), CONFIRM_FRIEND_REQUEST(3), FRIENDS(4), PENDING(5);

	private Integer status;

	FriendRequestStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

}
