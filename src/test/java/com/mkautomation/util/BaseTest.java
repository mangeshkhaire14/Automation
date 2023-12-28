package com.mkautomation.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

	public static WebDriver driver;

	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	DriverManager driverManager=new DriverManager();
	public Wait<WebDriver> wait;

	/*public void setUP() throws MalformedURLException{
		driver=driverManager.getDriver();
		driver.manage().window().maximize();
		jsonObject = JsonUtil.readJsonFile(testdataFilePath);
	}
*/

	public WebDriver initializeDriver(){

		driver=driverManager.createDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		tdriver.set(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}

}
