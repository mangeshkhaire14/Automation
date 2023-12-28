package com.mkautomation.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class SauceDemoLoginPage {

	WebDriver driver;
	WebDriverWait wait;
	private static final Logger log = LoggerFactory.getLogger(SauceDemoLoginPage.class);


	public SauceDemoLoginPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id=\"user-name\"]")
	public WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@id=\"login-button\"]")
	public WebElement loginButton;


	@Step
	public void waitForPageToLoad() {
		log.info("Waiting for login page to load...");
		wait.until(ExpectedConditions.visibilityOf(username));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(username)));
		log.info("login page loaded");
	}

	@Step("login with username {0} and password {1}")
	public void doLogin(String loginName,String loginPassword) {
		log.info("entering username");
		username.sendKeys(loginName);
		log.info("entering password");
		password.sendKeys(loginPassword);
		log.info("clicking on login button");
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
	}

	@Step("launching saucedemo web application")
	public void launchPage() {
		log.info("launching saucedemo page");
	}
}
