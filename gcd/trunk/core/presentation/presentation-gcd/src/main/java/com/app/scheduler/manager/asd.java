package com.app.scheduler.manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class asd {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		Date date = null;
		try {
			date = sdf.parse("00:00:01");
			System.out.println(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
