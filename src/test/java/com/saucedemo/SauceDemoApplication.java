package com.saucedemo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;

public class SauceDemoApplication {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver","D:\\driver\\firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
		loginPage.LaunchApplication();
		loginPage.Login();
	//	loginPage.VerifyHomePage();
		/*
		 * Assert issue: Exception in thread "main" java.lang.UnsupportedClassVersionError:
		 *  org/testng/Assert has been compiled by a more recent version of the Java Runtime 
		 *  (class file version 55.0), this version of the Java Runtime only recognizes 
		 *  class file versions up to 52.0
		 */
		
		SauceDemoProductPage product = new SauceDemoProductPage(driver);
		product.ChooseProduct();
		product.ScrollDownProduct();
		product.ScrollUpProduct();
		product.ChooseCart();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-450)", "");	

		SauceDemoCartPage cart = new SauceDemoCartPage(driver);
		cart.RemoveProductInCart();
		cart.ClickOnCheckOut();
		SauceDemoCheckOutInfoPage info = new SauceDemoCheckOutInfoPage(driver);
		info.CheckoutInformation();

//Click on Continue
	    driver.findElement(By.id("continue")).click();
	    
//CheckOut Overview
	    js.executeScript("window.scrollBy(0,-450)", "");
	    driver.findElement(By.id("finish")).click();
	    
//Verify Thankyou Page   
	    
	    String BackHomeButton= driver.findElement(By.xpath("//button[contains(@class,'btn btn_primary')]")).getText();
	    System.out.println(BackHomeButton+ " is displayed");
	    
	}

	

}
