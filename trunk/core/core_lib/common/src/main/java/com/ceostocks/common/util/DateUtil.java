package com.ceostocks.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String dateFormat = "MM/dd/yyyy";
	public static String dateTimeFormat = "MM/dd/yyyy HH:mm:ss";

	public static Date parseStringToDate(String sDate, String format) {
		Date date = null;
		DateFormat df = new SimpleDateFormat(format);
		try {
			date = df.parse(sDate);
		} catch (ParseException e) {
			date = null;
		}
		return date;
	}

	public static String parseDateToString(Date date, String format) {
		String sDate = null;
		if (date != null) {
			DateFormat df = new SimpleDateFormat(format);
			sDate = df.format(date);
		}
		return sDate;
	}

	public static String getTimeStampAsStr() {
		return System.currentTimeMillis() + "";
	}
}
