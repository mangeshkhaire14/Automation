package com.mkautomation.util;

import com.mkautomation.enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;


public class DriverManager {

    private WebDriver driver;
	private static DriverType driverType;
	ConfigurationManager configurationManager=new ConfigurationManager();
    
    public DriverManager() {
    	
    	driverType=configurationManager.getBrowser();
    }

    public WebDriver getDriver() {
    
		if(driver == null) {
			driver = createDriver();
		}
		return driver;

    }

    public WebDriver createDriver(){
    	
    	//log.info("========================Create New WebDriver=================================================");
        switch (driverType) {	    
        case FIREFOX : 
        	FirefoxOptions firefoxOptions=new FirefoxOptions();
        	firefoxOptions.setAcceptInsecureCerts(true);
        	//firefoxOptions.addArguments("use-fake-com.mkautomation.test.ui-for-media-stream");
        	//firefoxOptions.addPreference("media.navigator.permission.disabled",true);
        	 
        	//System.setProperty("webdriver.firefox.driver",configurationManager.properties.getProperty("firefox.driver.path"));

			// For setting browser profile for file download location
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setPreference("browser.download.folderList",2);
			firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
			firefoxProfile.setPreference("browser.download.dir",System.getProperty("user.dir"));
			firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");

			firefoxOptions.setProfile(firefoxProfile);
			driver = new FirefoxDriver(firefoxOptions);
	    	break;
        case CHROME : 
        	//System.setProperty("webdriver.chrome.driver",configurationManager.properties.getProperty("chrome.driver.path"));
        	ChromeOptions options = new ChromeOptions();
        	options.setAcceptInsecureCerts(true);
			options.addArguments("--remote-allow-origins=*");
			options.setBrowserVersion("stable");
			//options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
           // options.addArguments("use-fake-com.mkautomation.test.ui-for-media-stream");
       	 	//String node = "http://192.168.43.15:4444";

       		/*DesiredCapabilities caps = new DesiredCapabilities();
         	caps.setBrowserName("chrome");
        	driver = new RemoteWebDriver(new URL(node),caps);*/
			// For setting file download location
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
			options.setExperimentalOption("prefs", chromePrefs);

			driver = new ChromeDriver(options);

			break;
        case INTERNETEXPLORER : 
        	//System.setProperty("webdriver.ie.driver",configurationManager.properties.getProperty("ie.driver.path"));
        	driver = new InternetExplorerDriver();
    		break;
		default:
			//System.setProperty("webdriver.chrome.driver",configurationManager.properties.getProperty("chrome.driver.path"));
        	driver = new ChromeDriver();
        	break;
        }

		return driver;

    }
    
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
