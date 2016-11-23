package com.app.utility.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * This class is used to load the property values.
 * 
 * @author Piyush Pratap Singh
 * @version 1.0
 */
public class AppPropertyBuilder {

	private static Map<String, Properties> propertiesMap = new HashMap<String, Properties>();

	public static String getAppConfigFolder() {
		String appConfigFolder = System.getProperty("catalina.home") + System.getProperty("file.separator") + "bin"
				+ System.getProperty("file.separator") + "AppConfig_gcd";
		if (System.getProperty("appConfigFolder") != null) {
			File f = new File(
					System.getProperty("appConfigFolder") + System.getProperty("file.separator") + "AppConfig");
			if (f.exists() && f.isDirectory()) {
				appConfigFolder = System.getProperty("appConfigFolder") + System.getProperty("file.separator")
						+ "AppConfig";
			}
			f = null;
		}
		return appConfigFolder;
	}

	/**
	 * This is default constructor.
	 * 
	 * @throws FileNotFoundException
	 */
	private AppPropertyBuilder(String dbId) {
		if (propertiesMap.get(dbId) == null) {
			propertiesMap.put(dbId, new Properties());
			String configFile = getAppConfigFolder() + System.getProperty("file.separator")
					+ MultiDBPropertyBuilder.getDBAliasName(dbId) + System.getProperty("file.separator")
					+ "appProperty.properties";
			InputStream inputStream = null;
			// FileInputStream(configFile);
			// System.out.println(configFile);
			try {
				inputStream = new FileInputStream(configFile);
				propertiesMap.get(dbId).load(inputStream);
			} catch (FileNotFoundException e) {
				System.out.println("property file " + configFile + " not found.");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
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

	public static String getProperty(String key, String dbId) {
		if (propertiesMap.get(dbId) == null)
			new AppPropertyBuilder(dbId);
		String value = propertiesMap.get(dbId).getProperty(key);
		return value;
	}

	/**
	 * This method is used to get the property value
	 * 
	 * @param key
	 * @param forceReadFile
	 * @return {@link String}
	 */
	public static String getProperty(String key, String dbId, boolean forceReadFile) {
		if (propertiesMap.get(dbId) == null || forceReadFile) {
			propertiesMap.remove(dbId);
			new AppPropertyBuilder(dbId);
		}
		String value = propertiesMap.get(dbId).getProperty(key);
		return value;
	}

	public static Map<String, String> getPropertyMap(String dbId) {

		Map<String, String> propertyMap = new HashMap<String, String>();

		if (propertiesMap.get(dbId) != null)
			propertiesMap.remove(dbId);
		new AppPropertyBuilder(dbId);

		for (Map.Entry<Object, Object> entry : propertiesMap.get(dbId).entrySet()) {
			propertyMap.put(((String) entry.getKey()).replace(".", ""), (String) entry.getValue());
		}

		return propertyMap;
	}
}
