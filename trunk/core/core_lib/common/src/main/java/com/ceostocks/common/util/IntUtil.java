package com.ceostocks.common.util;

public class IntUtil {

	public static Integer getInteger(String sVal) {
		if (sVal != null)
			return Integer.parseInt(sVal);
		return null;
	}
}
