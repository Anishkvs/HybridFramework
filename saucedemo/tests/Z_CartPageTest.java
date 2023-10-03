package com.saucedemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testbase.TestBase;


public class Z_CartPageTest extends TestBase {
	

	
	@Test
	 public void removeProductInCart() throws InterruptedException {
		
		//Scroll down Cart page and remove last product
		    Thread.sleep(1000);
		    driver.findElement(By.id("remove-sauce-labs-onesie")).click();
		    Thread.sleep(2000);
		}
	 
    @Test
     public void clickOnCheckOut() {
    	//Click on CheckOut	
    	 driver.findElement(By.id("checkout")).click();
	}
		
		
			   
    
	
	
	
	
}
