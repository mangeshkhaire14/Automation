package com.mkautomation.codingchallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Noon {
    public static void main(String args[]) {

        Noon noon=new Noon();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("stable");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.noon.com/uae-en/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        noon.sectionName("Recommended for you",driver);
        noon.sectionName("Trending deals in Televisions",driver);
        noon.sectionName("Bestsellers in electronics",driver);

        driver.quit();
    }

    public void sectionName(String sectionName,WebDriver driver) {

        List<WebElement> carouselElements = driver.findElements(By.xpath("//div[@data-qa=\"widget_productCarousel\"]//h2"));

        for(int i=1;i<=carouselElements.size();i++){
            WebElement element = driver.findElement(By.xpath("(//div[@data-qa=\"widget_productCarousel\"]//h2)["+i+"]"));
            if(element.getText().equalsIgnoreCase(sectionName)){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        try {

            while (true) {
               // List<WebElement> productNames = driver.findElements(By.xpath("(//div[@data-qa='widget_productCarousel'])[1]//div[@data-qa='product-name']"));
                List<WebElement> productNames = driver.findElements(By.xpath("(//div[@data-qa=\"widget_productCarousel\"])["+i+"]//div[@data-qa='product-name']"));

                for (WebElement productName : productNames) {
                    System.out.println(productName.getText());
                }
                /*int n = driver.findElements(By.xpath("(//div[@data-qa='widget_productCarousel'])[1]//div[contains(@class,'swiper-button-next')]")).size();
                System.out.println("n=" + n);
                if (n == 0) {
                    break;
                }*/
                //WebElement element1 = driver.findElement(By.xpath("(//div[@data-qa='widget_productCarousel'])[1]//div[contains(@class,'swiper-button-next')]"));
                WebElement nextButton = driver.findElement(By.xpath("(//div[@data-qa=\"widget_productCarousel\"])["+i+"]//div[contains(@class,'swiper-button-next')]"));
               // JOptionPane.showInputDialog(1);
                if(nextButton.getAttribute("class").contains("disabled")){
                 //   JOptionPane.showInputDialog("break");
                    break;
                }
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("arguments[0].click();", nextButton);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        }
    }
}
