package com.app.mvc.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class GlobalTimeHandler {

	public static String getTimeZoneUtcTime(String timeZone) {
		TimeZone tz = TimeZone.getTimeZone(timeZone);
		Calendar cal = GregorianCalendar.getInstance(tz);
		int offsetInMillis = tz.getOffset(cal.getTimeInMillis());

		String offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000), Math.abs((offsetInMillis / 60000) % 60));
		offset = (offsetInMillis >= 0 ? "+" : "-") + offset;

		return offset;
	}
}
