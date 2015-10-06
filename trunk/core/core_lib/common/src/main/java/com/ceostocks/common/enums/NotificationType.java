package com.ceostocks.common.enums;

public enum NotificationType {
	FRIEND_REQUEST(1), DEACTIVATED(-1);

	private Integer notifyCode;

	NotificationType(Integer notifyCode) {
		this.notifyCode = notifyCode;
	}

	/**
	 * @return the notifyCode
	 */
	public Integer getNotifyCode() {
		return notifyCode;
	}

}
