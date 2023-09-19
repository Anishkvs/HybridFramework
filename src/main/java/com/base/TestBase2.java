package com.base;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase2 {
	
	public WebDriver driver;
	
	public void TestBase(WebDriver driver)
	{
		this.driver = driver;
	}

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver","D:\\driver\\firefox\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");


	}
	@AfterSuite
	public void tearDown()  {
		driver.close();
	}
}
