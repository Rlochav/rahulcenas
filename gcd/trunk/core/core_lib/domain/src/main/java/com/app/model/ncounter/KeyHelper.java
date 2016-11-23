/**
 * 
 */
package com.app.model.ncounter;

import com.app.model.param.SystemParam;

/**
 * @author Piyush Pratap Singh
 * 
 */
public class KeyHelper {
	public KeyHelper(String keyName, SystemParam systemParam) {
		super();
		this.keyName = keyName;
		this.systemParam = systemParam;
	}

	private String keyName;
	public static String paramCode = "APPCODE";
	private SystemParam systemParam;

	/**
	 * @return the keyName
	 */
	public String getKeyName() {
		return keyName;
	}

	/**
	 * @param keyName
	 *            the keyName to set
	 */
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	/**
	 * @return the systemParam
	 */
	public SystemParam getSystemParam() {
		return systemParam;
	}

	/**
	 * @param systemParam
	 *            the systemParam to set
	 */
	public void setSystemParam(SystemParam systemParam) {
		this.systemParam = systemParam;
	}

}
