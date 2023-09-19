package com.launch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Launch {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","D:\\driver\\firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.co.in/");
		
		
		
		
		
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();

		//WebDriverManager.firefoxdriver().setup();
		
		
		//Thread.sleep(3000);
		driver.navigate().refresh();
		//Thread.sleep(3000);
		driver.quit();

	}

	

}
