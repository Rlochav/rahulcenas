package com.app.utility.common;

public class StringUtil {

	public static String getLastByFSlas(String text) {
		try {
			int lastIndex = text.lastIndexOf("/");
			return text.substring(lastIndex + 1, text.length());
		} catch (Exception e) {
			return null;
		}
	}

	public static String getWithoutSpecial(String str) {
		try {
			String val = str.replaceAll("[^a-zA-Z0-9]", "-");
			return val;
		} catch (Exception e) {
			return null;
		}
	}

	public static String getStartFromIndex(String s) {
		if (s != null) {
			int lastIndex = s.lastIndexOf("/");
			s = s.substring(0, lastIndex);
			return s;
		}
		return null;
	}
}
