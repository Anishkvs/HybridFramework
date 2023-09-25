package com.launch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchChrome {
	
	public static void main(String[] args) throws InterruptedException {
	
		/*
		 *  org.openqa.selenium.remote.NoSuchDriverException:
		 */
//			WebDriver driver = new ChromeDriver();
//      	driver.get("https://www.google.co.in");
//      		
      		ChromeOptions chromeOptions = new ChromeOptions();
      		chromeOptions.setBrowserVersion("117");
      		WebDriver driver = new ChromeDriver(chromeOptions);
      		driver.get("https://www.google.co.in");
      		
	}

	

}













/*
 * java.lang.IllegalStateException:
 * The path to the driver executable must be set by the webdriver.chrome.driver system property
 * Current Selenium v4.6.0
 */