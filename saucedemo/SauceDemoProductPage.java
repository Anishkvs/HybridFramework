package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.testbase.TestBase;
import com.testbase.TestBase2;

import org.openqa.selenium.support.ui.Select;

public class SauceDemoProductPage extends TestBase2 {
	
	WebDriver driver;
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public SauceDemoProductPage(WebDriver driver)
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    public void chooseProduct() throws InterruptedException {
		
    	System.out.println("Choose the product");
    	//Choose product
    	Thread.sleep(5000);
    	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    	driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    	driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    	driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
			
	}
    
    public void scrollDownProduct() throws InterruptedException
    {
    	//scroll down Product page
  		System.out.println("Scroll Down");;
  		JavascriptExecutor jss = (JavascriptExecutor) driver;
  	    jss.executeScript("window.scrollBy(0,-450)", "");
  	    driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		Thread.sleep(2000);
  	
    }
	
    public void scrollUpProduct() throws InterruptedException
    {
    	System.out.println("Scroll Up");
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
  		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
  		
  //Remove 2nd product
  		driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
  		Thread.sleep(1000);
    
    }
    public void chooseCart() throws InterruptedException
    {
  		driver.findElement(By.className("shopping_cart_link")).click();
    	
    }
	
	public void sortAscending()
	{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Name (A to Z)");

	}
	
	public void sortDescending()
	{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Name (Z to A)");

	}
	public void sortLowToHigh()
	{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Price (low to high)");

	}
	public void sortHighToLow()
	{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Price (high to low)");

	}
	
	public void filterVerify() {
		sortDescending();
		sortHighToLow();
		sortLowToHigh();
		sortAscending();

	}
}
