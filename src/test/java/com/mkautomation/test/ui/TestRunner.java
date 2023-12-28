package com.mkautomation.test.ui;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.mkautomation.util.FileReaderManager;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/resources/",
	glue= {"com.mkautomation.steps"},
	//plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
	monochrome = true
	)
public class TestRunner {
	
	/*
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getExtentReportConfigPath()));
	}*/
	

}
