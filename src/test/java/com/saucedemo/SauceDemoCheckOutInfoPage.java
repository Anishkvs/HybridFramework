package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class SauceDemoCheckOutInfoPage extends TestBase {
	WebDriver driver;
	
	public SauceDemoCheckOutInfoPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 public void CheckoutInformation() throws InterruptedException {
		
 //CheckOut Information
	    driver.findElement(By.id("first-name")).sendKeys("FirstName");
	    driver.findElement(By.id("last-name")).sendKeys("LastName");
	    driver.findElement(By.id("postal-code")).sendKeys("689531");
	    Thread.sleep(2000);
		    
		}
	 
     
		
		
			   
    
	
	
	
	
}
