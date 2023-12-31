package com.mkautomation.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.mkautomation.enums.DriverType;


public class ConfigurationManager {
	
	protected Properties properties;
	String propertyFile = "src//test//resources//config//application.properties";

	public ConfigurationManager() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFile));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("configuration.properties not found at " + propertyFile);
		}
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName.equals("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equals("iexplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException(
					"Please provide valid browser value from configuration.properties file:"+browserName);
	}

}
