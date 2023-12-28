package com.mkautomation.test.ui;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mkautomation.util.RobotUtility;

public class ExampleTest {

	private static WebDriver driver;

	public static void main(String args[]) throws InterruptedException, AWTException {

	//	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		/*
		DevTools dev = ((ChromiumDriver) driver).getDevTools();
		dev.createSession();
		dev.send(Network.enable(Optional.<Integer>empty(), Optional.<Integer>empty(), Optional.<Integer>empty()));
		Map<String, Object> map = new HashMap<>();
		map.put("Authorization", "Basic " + new String(new Base64().encode("mkhaire:Aug@Gslab#2021".getBytes())));
		dev.send(Network.setExtraHTTPHeaders(new Headers(map)));

		*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String username="mkhaire";
		String password="Aug@Gslab#2021";
		//String URL="https://"+username+":"+password+"@"+"iwa.avaya.com/siteminderagent/ntlm/creds.ntc";

		String URL="https://demoqa.com/automation-practice-form";

		RobotUtility.closeAuthenticationPopUp();
		driver.get(URL);

		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstName.sendKeys("Test");

		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.sendKeys("Demo");

		WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
		userEmail.sendKeys("testdemo@test.com");

		List<WebElement> genderList = driver.findElements(By.xpath("//input[@name=\"gender\"]"));

		for (WebElement gender : genderList) {
			if (gender.getAttribute("value").equalsIgnoreCase("Male")) {
				gender.click();
				gender.click();

			}
		}


		WebElement userNumber = driver.findElement(By.xpath("//input[@id='userNumber']"));
		userNumber.sendKeys("9999999999");

		WebElement subject = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
		subject.sendKeys("Selenium Test");

		WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id=\"currentAddress\"]"));
		currentAddress.sendKeys("Test Location");

		WebElement submitButton = driver.findElement(By.xpath("//button[@id=\"submit\"]"));
		submitButton.click();
		driver.quit();

	}
}
