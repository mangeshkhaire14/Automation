/*

package com.mkautomation.test;

import static org.junit.Assert.assertEquals;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.com.mkautomation.test.ui.ExpectedConditions;
import org.openqa.selenium.support.com.mkautomation.test.ui.FluentWait;
import org.openqa.selenium.support.com.mkautomation.test.ui.Wait;
import org.openqa.selenium.support.com.mkautomation.test.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.mkautomation.pages.FormWebPage;
import com.mkautomation.util.BaseTests;
import com.mkautomation.util.Utility;

public class WebFormTest extends BaseTests {

	
	@Test
	public void subMitForm() {
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(120)) 
			       .pollingEvery(Duration.ofMillis(2000))
			       .ignoring(NoSuchElementException.class); 
		
		Wait<WebDriver> wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		
		driver.get("https://formy-project.herokuapp.com/form");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.manage().window().maximize();
		
		FormWebPage formwebPage=new FormWebPage(driver);
		//formwebPage.waitForPageToLoad();
		formwebPage.firstName.sendKeys("John");
		formwebPage.lastName.sendKeys("Test");
		formwebPage.jobTitle.sendKeys("Test Engineer");
		formwebPage.selectLevelOfEducation("College");
		formwebPage.selectGender("Male");
		formwebPage.selectDateOfBirth("02/17/1933");
		formwebPage.getInnerTest().getMethod1();
		wait.until(ExpectedConditions.visibilityOf(formwebPage.submitButton));
		Utility.scrollIntoView(formwebPage.submitButton);
		formwebPage.submitButton.click();
		assertEquals("The form was successfully submitted!",formwebPage.successMessage.getText());
	}
	
	public static void main(String args[]) throws UnknownHostException {
		
		LocalDateTime dateTime = LocalDateTime.now().minusDays(1);
		LocalDateTime dateTime1 = LocalDateTime.now().plusMinutes(1);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		String formattedStartDate=OffsetDateTime.of(dateTime, ZoneOffset.ofHoursMinutes(5, 30)).format(formatter);
		OffsetDateTime startDate = OffsetDateTime.parse(formattedStartDate);
		String formattedEndDate = OffsetDateTime.of(dateTime1, ZoneOffset.ofHoursMinutes(5, 30)).format(formatter);
		OffsetDateTime endDate = OffsetDateTime.parse(formattedEndDate);
		
		System.out.println(dateTime);
		System.out.println(dateTime1);
		System.out.println(startDate);
		System.out.println(endDate);

		String ipAddress=Inet4Address.getLocalHost().getHostAddress();

		System.out.println("IP:"+ipAddress);



	}
}

*/
