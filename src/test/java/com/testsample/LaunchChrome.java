package com.testsample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {
	
	public static void main(String[] args) throws InterruptedException {
	
		/*
		 *  org.openqa.selenium.remote.NoSuchDriverException:
		 */
			WebDriver driver = new ChromeDriver();
      		driver.get("https://www.google.co.in");
      		
	}

	

}













/*
 * java.lang.IllegalStateException:
 * The path to the driver executable must be set by the webdriver.chrome.driver system property
 * Current Selenium v4.6.0
 */