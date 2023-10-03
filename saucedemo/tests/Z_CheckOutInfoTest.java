package com.saucedemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testbase.TestBase;

public class Z_CheckOutInfoTest extends TestBase {
	
	

	
	
	@Test
	 public void checkOutInformation() throws InterruptedException {
 //CheckOut Information
	    driver.findElement(By.id("first-name")).sendKeys("FirstName");
	    driver.findElement(By.id("last-name")).sendKeys("LastName");
	    driver.findElement(By.id("postal-code")).sendKeys("689531");
	    driver.findElement(By.id("continue")).click();
	    Thread.sleep(2000);
		    
		}
	 
    @Test
	 public void checkOutWithoutInformation() throws InterruptedException {
		 driver.findElement(By.id("continue")).click();
		 Thread.sleep(2000);
		 
		}
    
    @Test
	 public void checkOutWithoutLastName() throws InterruptedException {
		 driver.findElement(By.id("first-name")).sendKeys("FirstName");
         driver.findElement(By.id("postal-code")).sendKeys("689531");
         driver.findElement(By.id("continue")).click();
         Thread.sleep(2000);
		}

    @Test
	 public void checkOutWithoutPostalCode() throws InterruptedException {
		 driver.findElement(By.id("first-name")).sendKeys("FirstName");
		 driver.findElement(By.id("last-name")).sendKeys("LastName");
		 driver.findElement(By.id("continue")).click();
		 Thread.sleep(2000);   
		}
		
    @Test
	public void checkOutVerify() throws InterruptedException {
		
		checkOutWithoutInformation();
		driver.navigate().refresh();
		checkOutWithoutLastName();
		driver.navigate().refresh();
		checkOutWithoutPostalCode();
		driver.navigate().refresh();
		checkOutInformation();

		}
			   
    
	
	
	
	
}
