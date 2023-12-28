package com.mkautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SauceDemoProductPage {

	WebDriver driver;
	WebDriverWait wait;

	public SauceDemoProductPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class=\"app_logo\"]")
	public WebElement appLogo;

	@FindBy(xpath="//div[@class=\"inventory_item_name \"][text()=\"Sauce Labs Onesie\"]")
	public WebElement product;

	@FindBy(xpath="//button[contains(text(),\"Add to cart\")]")
	public WebElement addToCartButton;

	@FindBy(xpath="//*[@class=\"shopping_cart_link\"]")
	public WebElement shoppingCartLink;

	@FindBy(xpath="//div[@class=\"inventory_item_price\"]")
	public List<WebElement> priceList;

	public void waitForPageToLoad() {
		wait.until(ExpectedConditions.visibilityOf(appLogo));
	}

}
