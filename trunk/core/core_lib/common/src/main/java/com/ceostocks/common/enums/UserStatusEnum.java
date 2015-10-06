package com.ceostocks.common.enums;

public enum UserStatusEnum {
	ACTIVATED(1), DEACTIVATED(-1);

	private Integer userStatusCode;

	UserStatusEnum(Integer userStatusCode) {
		this.userStatusCode = userStatusCode;
	}

	/**
	 * @return the userStatusCode
	 */
	public Integer getUserStatusCode() {
		return userStatusCode;
	}

}
