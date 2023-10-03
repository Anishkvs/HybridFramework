package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import com.testbase.TestBase;
import com.testbase.TestBase2;

public class SauceDemoCartPage extends TestBase2 {
	WebDriver driver;
	
	public SauceDemoCartPage(WebDriver driver)
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 public void removeProductInCart() throws InterruptedException {
		
		//Scroll down Cart page and remove last product
		    Thread.sleep(1000);
		    driver.findElement(By.id("remove-sauce-labs-onesie")).click();
		    Thread.sleep(2000);
		}
	 
     public void clickOnCheckOut() {
    	//Click on CheckOut	
    	 driver.findElement(By.id("checkout")).click();
	}
		
		
			   
    
	
	
	
	
}
