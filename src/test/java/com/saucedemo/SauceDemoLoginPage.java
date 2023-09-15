package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.TestBase;

public class SauceDemoLoginPage extends TestBase {
	WebDriver driver;
	
	public SauceDemoLoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 public void LaunchApplication() {
			driver.get("https://www.saucedemo.com/");
			System.out.println("Launch application");
		}
	 
    public void Login() {
		
    	driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();		
		System.out.println("Login application");
    }
    
    public void VerifyHomePage() {
		
		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Launch Product page");
		
	}
    
	
	
	
	
}
