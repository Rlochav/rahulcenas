package com.ceostocks.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.ceostocks.common.exception.CeoStocksAppException;

/**
 * This class is used to load the db property values.
 * 
 * @author Piyush Pratap Singh
 * @version 1.0
 */
public class MultiDBPropertyBuilder {

	private static Properties properties;

	public static String userPrifix_001 = getProperty("UserPrifix.001");
	public static String userPrifix_002 = getProperty("UserPrifix.002");
	public static String userPrifix_003 = getProperty("UserPrifix.003");
	public static String userPrifix_004 = getProperty("UserPrifix.004");
	public static String userPrifix_005 = getProperty("UserPrifix.005");
	public static String userPrifix_006 = getProperty("UserPrifix.006");

	public static String domainName_001 = getProperty("DomainName.001");
	public static String domainName_002 = getProperty("DomainName.002");
	public static String domainName_003 = getProperty("DomainName.003");
	public static String domainName_004 = getProperty("DomainName.004");
	public static String domainName_005 = getProperty("DomainName.005");
	public static String domainName_006 = getProperty("DomainName.006");

	/**
	 * This is default constructor.
	 * 
	 * @throws FileNotFoundException
	 */
	private MultiDBPropertyBuilder() {
		if (properties == null) {
			properties = new Properties();
			String configFile = CeoStocksConfigProperty.getAppConfigFolder() + System.getProperty("file.separator") + "appMultiBD.properties";
			InputStream inputStream = null;
			try {
				inputStream = new FileInputStream(configFile);
				properties.load(inputStream);
			} catch (FileNotFoundException e) {
				System.out.println("property file " + configFile + " not found.");
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				IOUtil.close(inputStream);
			}
		}

	}

	/**
	 * This method is used to get the property value
	 * 
	 * @param key
	 * @return {@link String}
	 */

	public static String getProperty(String key) {
		if (properties == null)
			new MultiDBPropertyBuilder();
		String value = properties.getProperty(key);
		return value;
	}

	public static String getProperty(String key, boolean readForcefully) {
		if (readForcefully) {
			new MultiDBPropertyBuilder();
		} else {
			if (properties == null)
				new MultiDBPropertyBuilder();
		}
		String value = properties.getProperty(key);
		return value;
	}

	public static String getDBAliasName(String dbId) {
		if (dbId.equals(MultiDBPropertyBuilder.userPrifix_002))
			return getProperty("Alias.002");
		else if (dbId.equals(MultiDBPropertyBuilder.userPrifix_003))
			return getProperty("Alias.003");
		else if (dbId.equals(MultiDBPropertyBuilder.userPrifix_004))
			return getProperty("Alias.004");
		else if (dbId.equals(MultiDBPropertyBuilder.userPrifix_001))
			return getProperty("Alias.001");
		else if (dbId.equals(MultiDBPropertyBuilder.userPrifix_005))
			return getProperty("Alias.005");
		else if (dbId.equals(MultiDBPropertyBuilder.userPrifix_006))
			return getProperty("Alias.006");
		else {
			try {
				System.out.println("++++++++++++++ DBAliasName not found for dbId : " + (dbId == null ? "null" : dbId) + " ++++++++++++++");
				throw new CeoStocksAppException("Invalid dbId");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	public static String getDbIdByDomainName(String domainName) {
		if (MultiDBPropertyBuilder.domainName_001 != null && MultiDBPropertyBuilder.domainName_001.trim().length() > 4
				&& domainName.indexOf(MultiDBPropertyBuilder.domainName_001) > -1)
			return MultiDBPropertyBuilder.userPrifix_001;
		else if (MultiDBPropertyBuilder.domainName_002 != null && MultiDBPropertyBuilder.domainName_002.trim().length() > 4
				&& domainName.indexOf(MultiDBPropertyBuilder.domainName_002) > -1)
			return MultiDBPropertyBuilder.userPrifix_002;
		else if (MultiDBPropertyBuilder.domainName_003 != null && MultiDBPropertyBuilder.domainName_003.trim().length() > 4
				&& domainName.indexOf(MultiDBPropertyBuilder.domainName_003) > -1)
			return MultiDBPropertyBuilder.userPrifix_003;
		else if (MultiDBPropertyBuilder.domainName_004 != null && MultiDBPropertyBuilder.domainName_004.trim().length() > 4
				&& domainName.indexOf(MultiDBPropertyBuilder.domainName_004) > -1)
			return MultiDBPropertyBuilder.userPrifix_004;
		else if (MultiDBPropertyBuilder.domainName_005 != null && MultiDBPropertyBuilder.domainName_005.trim().length() > 4
				&& domainName.indexOf(MultiDBPropertyBuilder.domainName_005) > -1)
			return MultiDBPropertyBuilder.userPrifix_005;
		else if (MultiDBPropertyBuilder.domainName_006 != null && MultiDBPropertyBuilder.domainName_006.trim().length() > 4
				&& domainName.indexOf(MultiDBPropertyBuilder.domainName_006) > -1)
			return MultiDBPropertyBuilder.userPrifix_006;
		else {
			try {
				System.out
						.println("++++++++++++++ domainName not found in MultiDBProperty : " + (domainName == null ? "null" : domainName) + " ++++++++++++++");
				throw new CeoStocksAppException("Invalid Domain Name " + domainName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}

}
