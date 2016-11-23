package com.app.utility.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtil {

	public static Date calcateDateTime(Date date, boolean setZero) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		if (setZero) {
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
		} else {
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
		}
		return calendar.getTime();
	}

	public static Date getUTCdatetimeAsDate(String dateFormat, Date date) {
		// note: doesn't check for null
		return stringDateToDate(getUTCdatetimeAsString(dateFormat, date, "UTC"), dateFormat);
	}

	/**
	 * GMT+05:30
	 * 
	 * @param dateFormat
	 * @param date
	 * @return
	 */
	public static String getUTCdatetimeAsString(String dateFormat, Date date, String timeZone) {
		final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		if (timeZone != null && !timeZone.isEmpty())
			sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		else
			sdf.setTimeZone(TimeZone.getDefault());
		final String utcTime = sdf.format(date);

		return utcTime;
	}

	public static Date getLocaldatetimeAsDate(String dateFormat, Date date) {
		return stringDateToDate(getUTCdatetimeAsString(dateFormat, date, null), dateFormat);
	}

	public static Date stringDateToDate(String StrDate, String dateFormatStr) {
		Date dateToReturn = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatStr);

		try {
			dateToReturn = (Date) dateFormat.parse(StrDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dateToReturn;
	}

	/*
	 * YYYYMMDDHHMMSSFFF
	 */
	public static String getDateTimeStamp() {

		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String year = "" + calendar.get(Calendar.YEAR);
		String month = "" + (1 + calendar.get(Calendar.MONTH));
		if (month.length() == 1)
			month = "0" + month;
		String day = "" + calendar.get(Calendar.DAY_OF_MONTH);
		if (day.length() == 1)
			day = "0" + day;
		String hr = "" + calendar.get(Calendar.HOUR_OF_DAY);
		if (hr.length() == 1)
			hr = "0" + hr;
		String min = "" + calendar.get(Calendar.MINUTE);
		if (min.length() == 1)
			min = "0" + min;
		String sec = "" + calendar.get(Calendar.SECOND);
		if (sec.length() == 1)
			sec = "0" + sec;
		String milisec = "" + calendar.get(Calendar.MILLISECOND);
		if (milisec.length() == 1)
			milisec = "00" + milisec;
		if (milisec.length() == 2)
			milisec = "0" + milisec;

		return year + month + day + hr + min + sec + milisec;
	}

	// Use one of the constants from Calendar, e.g. DATE, WEEK_OF_YEAR,
	// or MONTH, as the calUnit variable. Supply two Date objects.
	// This method returns the number of days, weeks, months, etc.
	// between the two dates. In other words it returns the result of
	// subtracting two dates as the number of days, weeks, months, etc.
	public static long getDateDiff(Date d1, Date d2, int calUnit) {
		if (d1.after(d2)) { // make sure d1 < d2, else swap them
			Date temp = d1;
			d1 = d2;
			d2 = temp;
		}
		GregorianCalendar c1 = new GregorianCalendar();
		c1.setTime(d1);
		GregorianCalendar c2 = new GregorianCalendar();
		c2.setTime(d2);
		for (long i = 1;; i++) {
			c1.add(calUnit, 1); // add one day, week, year, etc.
			if (c1.after(c2))
				return i - 1;
		}
	}

	public static Date dateAddHour(Date dDate, int hour) {
		if (dDate == null)
			return null;
		Calendar c = Calendar.getInstance();
		c.setTime(dDate);
		c.add(Calendar.HOUR, hour); // number of days to add
		return c.getTime();
	}

	public static String parseDateToString(Date dDate, String formate) {
		if (dDate == null)
			return null;

		DateFormat dateFormatter = new SimpleDateFormat(formate);
		String sDate = null;
		try {
			sDate = dateFormatter.format(dDate);
		} catch (Exception e) {
			System.out.println("com.app.utility.common.DateUtil.parseDateToString() Error while Date to String conversion : " + e.getLocalizedMessage());
		}
		return sDate;
	}

	public static String getDateTimeWithTimeZone() {
		String Dtime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date());
		StringBuffer sb = new StringBuffer();
		sb.append(Dtime);
		sb.insert(26, ":");
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getDateTimeWithTimeZone());
	}
}
