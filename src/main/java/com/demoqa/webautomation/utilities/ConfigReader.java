package com.demoqa.webautomation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Utility class to read configuration properties
 */
public class ConfigReader {

	private static Properties properties;

	static {
		try (FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/config.properties")) {

			properties = new Properties();
			properties.load(fis);

		} catch (IOException e) {
			System.err.println("Failed to load config.properties file");
			e.printStackTrace();
		}
	}


	/**
	 * Get property value by key
	 */
	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	/**
	 * Get application URL
	 */
	public static String getUrl() {
		return properties.getProperty("app.url");
	}

	/**
	 * Get browser name
	 */
	public static String getBrowser() {
		return properties.getProperty("browser", "chrome");
	}

	/**
	 * Get timeout value
	 */
	public static int getTimeout() {
		return Integer.parseInt(properties.getProperty("app.timeout", "10"));
	}

	/**
	 * Get page load timeout
	 */
	public static int getPageLoadTimeout() {
		return Integer.parseInt(properties.getProperty("page.load.timeout", "60s"));
	}

	/**
	 * Check if headless mode is enabled
	 */
	public static boolean isHeadless() {
		return Boolean.parseBoolean(properties.getProperty("headless", "false"));
	}

	/**
	 * Check if browser should be maximized
	 */
	public static boolean shouldMaximize() {
		return Boolean.parseBoolean(properties.getProperty("maximize", "true"));
	}

	/**
	 * Get username
	 */
	public static String getUsername() {
		return properties.getProperty("username");
	}

	/**
	 * Get password
	 */
	public static String getPassword() {
		return properties.getProperty("password");
	}
}
