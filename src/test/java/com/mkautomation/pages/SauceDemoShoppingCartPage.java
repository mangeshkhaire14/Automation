package com.mkautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SauceDemoShoppingCartPage {

	WebDriver driver;
	WebDriverWait wait;

	public SauceDemoShoppingCartPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class=\"title\"][text()=\"Your Cart\"]")
	public WebElement shoppingCartPageTitle;

	@FindBy(id="checkout")
	public WebElement checkoutButton;

	public void waitForPageToLoad() {
		wait.until(ExpectedConditions.visibilityOf(shoppingCartPageTitle));
	}

}
