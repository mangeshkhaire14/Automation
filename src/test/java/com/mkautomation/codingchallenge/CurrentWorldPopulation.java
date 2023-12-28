package com.mkautomation.codingchallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class CurrentWorldPopulation {

    public static void main(String args[]){

        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setBrowserVersion("stable");

        WebDriver driver= new ChromeDriver(chromeOptions);
        driver.get("https://www.worldometers.info/world-population/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        int countdown=20000;

        String currentWorldPopulation;//=driver.findElement(By.xpath("//span[@rel=\"current_population\"]")).getText();
        String todaysBirths;//=driver.findElement(By.xpath("//span[@rel=\"births_today\"]")).getText();
        String todaysDeaths;//=driver.findElement(By.xpath("//span[@rel=\"dth1s_today\"]")).getText();
        String populationGrowthToday;//=driver.findElement(By.xpath("//span[@rel=\"absolute_growth\"]")).getText();
        long start = System.currentTimeMillis();

        while(true) {

            currentWorldPopulation = driver.findElement(By.xpath("//span[@rel=\"current_population\"]")).getText();
            todaysBirths = driver.findElement(By.xpath("//span[@rel=\"births_today\"]")).getText();
            todaysDeaths = driver.findElement(By.xpath("//span[@rel=\"dth1s_today\"]")).getText();
            populationGrowthToday = driver.findElement(By.xpath("//span[@rel=\"absolute_growth\"]")).getText();

            System.out.println("currentWorldPopulation:" + currentWorldPopulation);
            System.out.println("todaysBirths:" + todaysBirths);
            System.out.println("todaysDeaths:" + todaysDeaths);
            System.out.println("populationGrowthToday:" + populationGrowthToday);
            long end = System.currentTimeMillis();
            long totalTime=((end-start)/1000)%60;
            System.out.println("Total Time in Seconds:" + totalTime);

            if(totalTime==20) {
                System.out.println("Total Time in Seconds:" + totalTime);
                break;
            }

        }

        driver.quit();

    }
}
