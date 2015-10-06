package com.ceostocks.common.util;

import java.util.Random;

public class TokenUtil {

	private static String alphabet = "abcdefghijklmnopqrstuvqxyz";
	private static String number = "0123456789";
	private static String specialChars = "@%";

	public static String getToken(boolean alphabet, boolean number, boolean specialChars, int lenght) {
		StringBuffer pattern = new StringBuffer();
		StringBuffer token = new StringBuffer();
		if (alphabet)
			pattern.append(TokenUtil.alphabet);
		if (number)
			pattern.append(TokenUtil.number);
		if (specialChars)
			pattern.append(TokenUtil.specialChars);
		if (pattern.length() > 0) {
			String strPattern = pattern.toString();
			Random random = new Random();
			for (int i = 0; i < lenght; i++) {
				token.append(strPattern.charAt(random.nextInt(strPattern.length())));
			}
			return token.toString();
		}
		return null;
	}
}
