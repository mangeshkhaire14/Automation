package com.mkautomation.listeners;

import com.mkautomation.util.BaseTest;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener extends AllureTestNg implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestStart(ITestResult testResult) {
        System.out.println("Test Started...");
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        System.out.println("Test Succeed...");
        Object testClass = testResult.getInstance();
        WebDriver driver= BaseTest.getDriver();
        if (driver instanceof WebDriver) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(testResult));
            takeScreenshot(driver);
        }
        saveTextLog(getTestMethodName(testResult) + " passed and screenshot taken!");

    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        System.out.println("Test Failed...");
        Object testClass = testResult.getInstance();
        WebDriver driver= BaseTest.getDriver();
        if (driver instanceof WebDriver) {
            System.out.println("Screenshot captured for test case:" + getTestMethodName(testResult));
            takeScreenshot(driver);
        }
        saveTextLog(getTestMethodName(testResult) + " failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

}
