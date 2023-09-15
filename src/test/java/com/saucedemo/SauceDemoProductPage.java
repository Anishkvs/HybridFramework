package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;

public class SauceDemoProductPage extends TestBase {
	
	WebDriver driver;
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public SauceDemoProductPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    public void ChooseProduct() throws InterruptedException {
		
    	System.out.println("Choose the product");
    	//Choose product
    	Thread.sleep(5000);
    	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    	driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    	driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    	driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
			
	}
    
    public void ScrollDownProduct() throws InterruptedException
    {
    	//scroll down Product page
  		System.out.println("Scroll Down");;
  		JavascriptExecutor jss = (JavascriptExecutor) driver;
  	    jss.executeScript("window.scrollBy(0,-450)", "");
  	    driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		Thread.sleep(2000);
  	
    }
	
    public void ScrollUpProduct() throws InterruptedException
    {
    	System.out.println("Scroll Up");
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
  		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
  		
  //Remove 2nd product
  		driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
  		Thread.sleep(1000);
    
    }
    public void ChooseCart() throws InterruptedException
    {
  		driver.findElement(By.className("shopping_cart_link")).click();
    	
    }
	
	
	
	
}
