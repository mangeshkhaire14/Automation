package com.mkautomation.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormWebPage {

	WebDriver driver;
	WebDriverWait wait;
	
	public FormWebPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[id='first-name']")
	public WebElement firstName;
	
	@FindBy(css="input[id='last-name']")
	public WebElement lastName;
	
	@FindBy(css="input[id='job-title']")
	public WebElement jobTitle;
	
	@FindBy(css="input[aria-label=\"Radio button\"]")
	public List<WebElement> levelOfEducation;
	
	@FindBy(css="input[type=\"checkbox\"]")
	public List<WebElement> gender;
	
	@FindBy(css="input[id='datepicker']")
	public WebElement dateOfBirth;
	
	@FindBy(xpath="//a[text()=\"Submit\"]")
	public WebElement submitButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-success')]")
	public WebElement successMessage;
	
	/*public WebElement firstName=driver.findElement(By.id("#first-name"));
	public WebElement lastName=driver.findElement(By.id("#last-name"));
	public WebElement jobTitle=driver.findElement(By.id("#job-title"));
	*/
	
	public void selectLevelOfEducation(String education){
		
		for(WebElement level:levelOfEducation) {
			
			if(level.getText().equalsIgnoreCase(education)) {
				level.click();
				break;
			}
		}
	}
	
	public void selectGender(String genderName){
		
		for(WebElement value:gender) {
			
			if(value.getText().equalsIgnoreCase(genderName)) {
				value.click();
				break;
			}
		}
	}

	public void selectDateOfBirth(String dob) {
		dateOfBirth.sendKeys(dob);
	}


	public innerTest getInnerTest(){
		return new innerTest();
	}

	public class innerTest {

		public void getMethod1(){

		}
	}

}
