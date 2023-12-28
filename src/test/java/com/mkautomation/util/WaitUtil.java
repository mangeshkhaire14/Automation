package com.mkautomation.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

	public static final long DEFAULT_TIMEOUT = Long
			.valueOf((String) System.getProperty("default.timeout", (String) "60"));

	static WebDriverWait wait=null;

	static WebDriver driver;
	/*
	@SuppressWarnings("deprecation")
	public static void waitForPresent(String locator, long timeout) {

		//WebDriverWait wait = new WebDriverWait(FunctionsLibrary.driver, timeout);
		// wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(By));
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				 .withTimeout(600, TimeUnit.SECONDS) 
				 .pollingEvery(5, TimeUnit.SECONDS)
				 .ignoring(NoSuchElementException.class);
		 WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	            public WebElement apply(WebDriver driver) {
	            	try {
	            		return driver.findElement(LocatorUtils.getBy(locator));
	            	}catch(Exception e) {
	            		return null;
	            	}
	            }
	        });
	}

	*/
	public static void waitForLoaderToDismiss() {

		try {
			wait= new WebDriverWait(driver,Duration.ofSeconds(120));
			By locator = By.xpath("//div[@class=\"ant-spin-container ant-spin-blur\"]");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

		}catch(Exception e) {
			
		}

	}

	public static void waitForPresent(String locator, long... timeout) {

		if (timeout != null) {
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeout[0]));

		}
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(LocatorUtils.getBy(locator)));
			System.out.println(String.format((String) "%s to be present", locator));

		} catch (Exception e) {

		}
	}

	public static void waitForVisible(WebElement element, long... timeout) {

	//	System.out.println("DEFAULT_TIMEOUT:"+DEFAULT_TIMEOUT);
		wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));

		/*if (timeout != null) {
			wait = new WebDriverWait(FunctionsLibrary.driver, timeout[0]);
		}*/
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println(String.format((String) "%s to be visible", (Object[]) new Object[] { element }));
		} catch (Exception e) {

		}

	}
	
	public static void waitForVisible(String element, long... timeout) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(LocatorUtils.getBy(element)));
			//System.out.println(String.format((String) "%s to be visible", (Object[]) new Object[] { element }));
		} catch (Exception e) {
			System.out.println("Element: "+element+" Wait Timeout : "+DEFAULT_TIMEOUT+" Sec");
		}

	}

	public static void waitForNotVisible(WebElement element) {

		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {

		}
	}

	public static void waitForPresent(WebElement element) {

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(LocatorUtils.getBy("")));
		} catch (Exception e) {

		}
	}

	/*
	@SuppressWarnings("deprecation")
	public static Wait<WebDriver> wait(WebElement element) {

		// Waiting 30 seconds for an element to be present on the page, checking // for
		// its presence once every 5 seconds.
		/*
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) .withTimeout(30,
		 * TimeUnit.SECONDS) .pollingEvery(5, TimeUnit.SECONDS)
		 * .ignoring(NoSuchElementException.class);
		 * 
		 * WebElement foo = wait.until(new Function<WebDriver, WebElement>() { public
		 * WebElement apply(WebDriver driver) { return driver.findElement(By.id("foo"));
		 * } });
		 */

		//return new FluentWait((WebElement) element).withTimeout(60, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS);
	//}
	

	public static void waitForAppLoaderToDismiss() {

		try {
			wait= new WebDriverWait(driver,Duration.ofSeconds(90));
			By locator = By.xpath("//div[@class=\"app-loader\"]");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		}catch(Exception e) {
			
		}

	}
		
	public static void main(String args[]) {

		int a = 8;
		int b = 10;
		String expected = "Test Automation Guru";
		String actual = "Test Automation Guru";
		
		System.out.println("It works");
		//assertion.assertAll();

	}
	

	
	
}
