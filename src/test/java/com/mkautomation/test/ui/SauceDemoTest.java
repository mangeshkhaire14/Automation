package com.mkautomation.test.ui;

import com.mkautomation.pages.SauceDemoLoginPage;
import com.mkautomation.pages.SauceDemoProductPage;
import com.mkautomation.pages.SauceDemoShoppingCartPage;
import com.mkautomation.util.BaseTest;
import com.mkautomation.util.JsonUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemoTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(SauceDemoTest.class);
    public static JSONObject jsonObject;
    public WebDriver driver;
    String testdataFilePath="src//test//resources//testdata//saucedemo.json";

    @BeforeMethod
    public void setUp(){
        jsonObject = JsonUtil.readJsonFile(testdataFilePath);
        driver = initializeDriver();
        driver.get("https://www.saucedemo.com/");

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

        String username = JsonUtil.getData(jsonObject, "login.username");
        String password = JsonUtil.getData(jsonObject, "login.password");

        SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage(driver);
        sauceDemoLoginPage.waitForPageToLoad();
      //  ScreenshotUtility.takeScreenshot(driver);
        sauceDemoLoginPage.doLogin(username, password);
    }

    @Test(description = "To verify successfull login into saucedemo web application",priority = 1)
    @Description("To verify successfull login into saucedemo web application")
    public void verify_login_successfull() {

        print("To verify successfull login into saucedemo web application");
        SauceDemoProductPage sauceDemoProductPage = new SauceDemoProductPage(driver);
        sauceDemoProductPage.waitForPageToLoad();
       // ScreenshotUtility.takeScreenshot(driver);
        // ScreenshotUtility.attachScreenshotToAllureReport(driver,"Product Page");
        Assert.assertTrue(sauceDemoProductPage.appLogo.isDisplayed());
    }

    @Test(description = "To add product into cart",priority = 2)
    public void addProduceIntoCard() {

        print("To add product into cart");
        SauceDemoProductPage sauceDemoProductPage = new SauceDemoProductPage(driver);
        sauceDemoProductPage.waitForPageToLoad();

        wait.until(ExpectedConditions.visibilityOf(sauceDemoProductPage.product));
        sauceDemoProductPage.product.click();
        wait.until(ExpectedConditions.visibilityOf(sauceDemoProductPage.addToCartButton));
        sauceDemoProductPage.addToCartButton.click();
        sauceDemoProductPage.shoppingCartLink.click();

        SauceDemoShoppingCartPage sauceDemoShoppingCartPage=new SauceDemoShoppingCartPage(driver);
        sauceDemoShoppingCartPage.waitForPageToLoad();
        sauceDemoShoppingCartPage.checkoutButton.click();
    }

    @Test(description = "To add product into cart which having maximum price",priority = 2)
    public void addProduceIntoCartHavingMaximumPrice() {

        SauceDemoProductPage sauceDemoProductPage = new SauceDemoProductPage(driver);
        sauceDemoProductPage.waitForPageToLoad();

        Double maxValuePrice= sauceDemoProductPage.priceList
                .stream()
                .mapToDouble(
                        e -> Double.parseDouble(e.getText().trim().replace("$","")))
                .max().getAsDouble();

        wait.until(ExpectedConditions.visibilityOf(sauceDemoProductPage.product));
        sauceDemoProductPage.product.click();
        wait.until(ExpectedConditions.visibilityOf(sauceDemoProductPage.addToCartButton));
        sauceDemoProductPage.addToCartButton.click();
        sauceDemoProductPage.shoppingCartLink.click();

        SauceDemoShoppingCartPage sauceDemoShoppingCartPage=new SauceDemoShoppingCartPage(driver);
        sauceDemoShoppingCartPage.waitForPageToLoad();
        sauceDemoShoppingCartPage.checkoutButton.click();
   }

    @Step("executing test case {0}")
    public void print(String text){
        log.info(text);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
