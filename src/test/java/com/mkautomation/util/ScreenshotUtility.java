package com.mkautomation.util;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.File;


public class ScreenshotUtility {

	private static Logger log = LoggerFactory.getLogger(ScreenshotUtility.class);
	public static ThreadLocal<byte[]> screenshots=ThreadLocal.withInitial(()->null);

	public static void captureScreenshot(WebDriver driver,String screenshotName) {
		try {
			log.info("Step: Taking screenshot from the current screen - Started");

			Thread.sleep(2000);
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);

			File destinationPath = new File("./target/screenshots/" + screenshotName + ".png");
			FileUtils.copyFile(source, destinationPath);

			log.info("Step: Taking screenshot from the current screen - Successful");
		} catch (Exception e) {
			log.info("Step: Taking screenshot from the current screen - Failed");
		}
	}

	public static void captureScreenshot(WebDriver driver, String screenshotName, int instance) {
		try {
			log.info("Step: Taking screenshot from instance no. {} - Started", instance);

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);

			File destinationPath = new File("./target/screenshots/" + screenshotName + ".png");
			FileUtils.copyFile(source, destinationPath);

			log.info("Step: Taking screenshot from instance no. {} - Successful", instance);
		} catch (Exception e) {
			log.info("Step: Taking screenshot from instance no. {} - Failed", instance);
		}
	}
	
	public static void takeScreenshot(WebDriver driver,io.cucumber.core.api.Scenario scenario) {
		try {
			log.info("Step: Taking screenshot from the current screen for embedding in report- Started");

			Thread.sleep(2000);
		    final byte[] screenshot = ((TakesScreenshot)
		    		driver).getScreenshotAs(OutputType.BYTES);

		    scenario.embed(screenshot, "image/png");
			log.info("Step: Taking screenshot from the current screen - Successful");
		} catch (Exception e) {
			log.info("Step: Taking screenshot from the current screen - Failed");
		}
	}

	public static void attachScreenshotToAllureReport(WebDriver driver,String screenshotName) {
		try {
			log.info("Step: Taking screenshot from the current screen - Started");

			Thread.sleep(2000);
			byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment(screenshotName,new ByteArrayInputStream(screenshot));

			log.info("Step: Taking screenshot from the current screen - Successful");
		} catch (Exception e) {
			log.info("Step: Taking screenshot from the current screen - Failed");
		}
	}

	public static void captureScreenshot(WebDriver driver) {
		try {
			log.info("Step: Taking screenshot from the current screen - Started");

			byte[] screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			screenshots.set(screenshot);
			log.info("Step: Taking screenshot from the current screen - Successful");
		} catch (Exception e) {
			log.info("Step: Taking screenshot from the current screen - Failed");
			e.printStackTrace();
		}
	}

	public static byte[] getScreenshot(){
		return screenshots.get();
	}

	@Attachment(value = "Screenshot", type = "image/png")
	public static byte[] takeScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}
