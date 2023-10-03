package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;
import com.testbase.TestBase2;

public class SauceDemoCheckOutInfoPage extends TestBase2 {
	WebDriver driver;
	
	public SauceDemoCheckOutInfoPage(WebDriver driver)
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 public void checkOutInformation() throws InterruptedException {
		
 //CheckOut Information
	    driver.findElement(By.id("first-name")).sendKeys("FirstName");
	    driver.findElement(By.id("last-name")).sendKeys("LastName");
	    driver.findElement(By.id("postal-code")).sendKeys("689531");
	    driver.findElement(By.id("continue")).click();
	    Thread.sleep(2000);
		    
		}
	 
	 public void checkOutWithoutInformation() throws InterruptedException {
		 driver.findElement(By.id("continue")).click();
		 Thread.sleep(2000);
		 
				}
	 public void checkOutWithoutLastName() throws InterruptedException {
		 driver.findElement(By.id("first-name")).sendKeys("FirstName");
         driver.findElement(By.id("postal-code")).sendKeys("689531");
         driver.findElement(By.id("continue")).click();
         Thread.sleep(2000);
		}

	 public void checkOutWithoutPostalCode() throws InterruptedException {
		 driver.findElement(By.id("first-name")).sendKeys("FirstName");
		 driver.findElement(By.id("last-name")).sendKeys("LastName");
		 driver.findElement(By.id("continue")).click();
		 Thread.sleep(2000);   
		}
		
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
