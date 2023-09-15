package com.testsample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SampleLaunch {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","D:\\driver\\firefox\\geckodriver.exe");
		
		
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//WebDriverManager.firefoxdriver().setup();
		
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.co.in/");
		//Thread.sleep(3000);
		driver.navigate().refresh();
		//Thread.sleep(3000);
		driver.quit();

	}

	

}
