package com.ceostocks.common.enums;

public enum Privacy {
	PUBLIC(1), FRIENDS(2), ONLY_ME(3), SECRET(4), CLOSED(5);

	private Integer privacyCode;

	Privacy(Integer visibilityCode) {
		this.privacyCode = visibilityCode;
	}

	/**
	 * @return the visibilityCode
	 */
	public Integer getPrivacyCode() {
		return privacyCode;
	}

	/**
	 * @return the visibilityCode
	 */
	public static Integer getCodeByName(String privacyName) {
		Privacy[] types = Privacy.values();
		for (Privacy type : types) {
			if (type.name().equalsIgnoreCase(privacyName))
				return type.getPrivacyCode();
		}
		throw new IllegalArgumentException();
	}

	/**
	 * @return the PrivacyName
	 */
	public static String getNameByCode(Integer privacyCode) {
		Privacy[] types = Privacy.values();
		for (Privacy type : types) {
			if (type.privacyCode.equals(privacyCode))
				return type.name();
		}
		throw new IllegalArgumentException();
	}

}
