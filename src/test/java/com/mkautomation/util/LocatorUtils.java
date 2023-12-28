package com.mkautomation.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LocatorUtils {

	static Properties properties = null;

	public static By getBy(String locatorKey) {
		
		String objectFileName = "src/test/resources/config/object.properties";
		properties = loadPropertiesFile(objectFileName);
		
		String[] locator=properties.getProperty(locatorKey).split("#");
		
		String locatorStrategy=locator[0].trim().toLowerCase();
		String locatorValue=locator[1].trim();
		System.out.println("Locator Strategy:"+locatorStrategy);
		System.out.println("Locator Value:"+locatorValue);
		
		switch(locatorStrategy) {
			case "xpath":
				return By.xpath(locatorValue);
			case "css":
				return By.cssSelector(locatorValue);
			case "id":
				return By.id(locatorValue);
			case "name":
				return By.name(locatorValue);
			case "link":
				return By.linkText(locatorValue);
			case "tagname":
				return By.tagName(locatorValue);
			case "partiallink":
				return By.partialLinkText(locatorValue);
			case "classname":
				return By.className(locatorValue);
				
		}
		throw new RuntimeException("Invalid locator strategy"+locatorStrategy);
	}
	
	public static WebElement getWebElement(String locatorKey) {
		
		LocatorUtils.getBy(locatorKey);
		return null;
		
	}
	
	public static Properties loadPropertiesFile(String propFilePath) {
		Properties properties = null;
		try {
			properties = new Properties();
			InputStream fis = new FileInputStream(propFilePath);
			properties.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	public static void main(String args[]) {
		LocatorUtils.getBy("locator");
		//WebElement element=new LocatorUtils().getWebElement("page.username");
	}
	
}
