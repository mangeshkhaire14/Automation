package com.mkautomation.codingchallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class PerParasite {
    public static void main(String args[]) {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("stable");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://petdiseasealerts.org/forecast-map");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        List<WebElement> regions=driver.findElements(By.xpath("//*[local-name()='svg']//*[name()='g'][@class='region']"));
        for(WebElement element:regions){
            System.out.println(element.getAttribute("id"));
            if(element.getAttribute("id").equalsIgnoreCase("california")){
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
                break;
            }
        }
        //driver.quit();
    }

}
