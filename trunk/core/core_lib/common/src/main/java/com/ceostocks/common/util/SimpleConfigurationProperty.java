package com.ceostocks.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource
public class SimpleConfigurationProperty implements ConfigurationProperty {

	private Properties properties = new Properties();

	public SimpleConfigurationProperty() {
		String appConfigFolder = System.getProperty("catalina.home") + System.getProperty("file.separator") + "bin" + System.getProperty("file.separator")
				+ "AppConfig";
		if (System.getProperty("appConfigFolder") != null) {
			File f = new File(System.getProperty("appConfigFolder") + System.getProperty("file.separator") + "AppConfig");
			if (f.exists() && f.isDirectory()) {
				appConfigFolder = System.getProperty("appConfigFolder") + System.getProperty("file.separator") + "AppConfig";
			}
			f = null;
		}
		loadPriperty(appConfigFolder);
	}

	private void loadPriperty(String appConfigFolder) {
		String configFile = appConfigFolder + System.getProperty("file.separator") + "applicationConfig.properties";
		try {
			InputStream inputStream = new FileInputStream(configFile);
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getProperty(String key) {
		if (key != null) {
			return properties.getProperty(key);
		}
		return null;
	}

	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * @param properties
	 *            the properties to set
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
