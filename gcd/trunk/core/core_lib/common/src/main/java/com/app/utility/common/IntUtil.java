package com.app.utility.common;

public class IntUtil {

	public static boolean isInteger(String sValue) {
		if (sValue == null)
			return false;
		try {
			Float fVal = Float.parseFloat(sValue.trim());
			if (fVal==fVal.intValue())
				return true;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isPositiveInteger(String sValue) {
		if (sValue == null)
			return false;
		try {
			Float fVal = Float.parseFloat(sValue.trim());
			if (fVal==fVal.intValue() && fVal.intValue() >= 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static Integer getInteger(String sValue) {
		if (sValue == null)
			return null;
		try {
			Float fVal = Float.parseFloat(sValue.trim());
			return fVal.intValue();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getString(Integer iValue) {
		try {
			if(iValue!=null)
			return ""+iValue;
		} catch (Exception e) {
		}
		return null;
	}
}
