package com.oris.util;
import java.util.Properties;

/**
 * 
 * @author Ross Zarsuela
 *
 */

public class Config {
	private static Properties properties;

	public static Properties getProperties() {
		return properties;
	}

	public static String getProperties(String key) {
		return getProperties().getProperty(key);
	}

	public void setProperties(Properties properties) {
		Config.properties = properties;
	}

}