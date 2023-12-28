package com.mkautomation.util;

import static org.junit.Assert.fail;

import java.io.File;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssertionUtil {

	@Rule
	public static ErrorCollector collector = new ErrorCollector();
	protected StringBuffer verificationErrors = new StringBuffer();
	
	static WebDriver driver;

	public static void assertVisible(WebElement element) {
		try {
			WaitUtil.waitForVisible(element);
		} catch (Exception e) {

		}
		if (!element.isDisplayed()) {
			throw new AssertionError(
					(Object) ("Expected element " + (Object) element + "should be visible : but found not visible"));
		}
	}

	public static void assertNotVisible(WebElement element) {
		try {
			WaitUtil.waitForVisible(element);
		} catch (Exception e) {

		}
		if (element.isDisplayed()) {
			throw new AssertionError(
					(Object) ("Expected element " + (Object) element + "should be visible : but found not visible"));
		}
	}

	public static void assertTextPresent(WebElement element, Matcher<String> text) {
		try {
			WaitUtil.waitForVisible(element);
		} catch (Exception e) {

		}
		String actualText = element.getText();
		if (!text.matches((Object) actualText)) {
			String msg = String.format((String) "Expected %s text should be %s : but found %s",
					(Object[]) new Object[] { element, text, actualText });
			throw new AssertionError((Object) msg);
		}

	}

	public static void assertPresent(WebElement element) {
		try {
			WaitUtil.waitForPresent(element);
		} catch (Exception e) {

		}
		if (!element.isDisplayed()) {
			throw new AssertionError(
					(Object) ("Expected element " + element + " Should present : but found not present"));
		}
	}

	public static void assertPresent(String loc) {
		try {
			WaitUtil.waitForPresent(loc);
		} catch (Exception e) {

		}
		if (!isPresent(loc)) {
			throw new AssertionError((Object) ("Expected element should present : but found not present"));
		}
	}

	public static boolean isPresent(String loc) {
		try {

			return driver.findElements(LocatorUtils.getBy(loc)).size() > 0;

		} catch (Exception e) {
			System.out.println("isPresent Exception-");
			return false;
		}

	}

	public static void main(String args[]) {

		int a = 5;
		int b = 10;
		// new AssertionUtil().verifyTrue(a>b, "fail", "pass");
		if (b > a) {
			assert false;
		}

		collector.checkThat(5, Matchers.equalTo(6));
		System.out.println("And it executes");

	}

	public void assertVisible(String elementLocator, String elementName) {
		String failMsg = "Expected element " + elementName + " should be visible : but found not visible";
		String successMsg = "Expected element " + elementName + " is visible";
		boolean flag = false;
		try {
			WaitUtil.waitForVisible(elementLocator);
			flag = true;
		} catch (Throwable e) {
		}
		assertTrue(flag, failMsg, successMsg);
	}

	public void assertTrue(boolean b, String failMsg, String successMsg) {
		if (!b) {
			// addAssertionLog(failMsg,"Fail");
			throw new AssertionError(failMsg);
		}
		addAssertionLog(successMsg, "Pass");
	}

	public boolean verifyTrue(boolean b, String failMessage, String successMessage) {
		try {
			assertTrue(b, failMessage, successMessage);
			return true;
		} catch (Error e) {
			addVerificationError(e);
			return false;
		}
	}

	public boolean verifyVisible(String elementLocator, String elementName) {
		try {
			assertVisible(elementLocator, elementName);
			return true;
		} catch (Error e) {
			addVerificationError(e);
			return false;
		}
	}

	public void addAssertionLog(String log, String messageType) {

		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().contains("windows".toLowerCase())) {

			if (messageType.equals("Fail")) {
				System.out.println("\n" + "\u001B[91m" + log + "\u001B[0m");
				verificationErrors.append(log);

			} else if (messageType.equals("Pass")) {
				System.out.println("\n" + "\u001B[92m" + log + "\u001B[0m");
			}
		} else {

			if (messageType.equals("Fail")) {
				// System.out.println("\n"+"\033[91m"+log+"\033[0m");
				System.out.println("\n" + log);

				verificationErrors.append(log);

			} else if (messageType.equals("Pass")) {
				// System.out.println("\n"+"\033[92m"+log+"\033[0m");
				System.out.println("\n" + log);
			}

		}
	}

	public void addVerificationError(Throwable e) {
		addAssertionLog(e.getMessage(), "Fail");
	}

	public void addVerificationError(String message) {
		addAssertionLog(message, "Fail");
	}

	public void clearVerificationErrors() {
		System.out.println("it executes");
		verificationErrors = new StringBuffer();
	}

	public void checkForVerificationErrors() {
		String verificationErrorString = verificationErrors.toString().trim();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	public void addVerificationLogger(String message, String status) {
		if (status.equalsIgnoreCase("pass")) {
			addAssertionLog(message, "Pass");
		} else {
			throw new AssertionError((Object) (message));
		}

	}
}
