package com.saucedemo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.testbase.TestBase2;

import org.openqa.selenium.JavascriptExecutor;

public class SauceDemoApplication extends TestBase2{
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver","D:\\driver\\firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
		loginPage.launchApplication();
		loginPage.verifyLogin();
		loginPage.login(); Thread.sleep(2000);
		loginPage.verifyBrowserBackAndFowardPossibilites();
	
		SauceDemoProductPage product = new SauceDemoProductPage(driver);
		
		product.filterVerify();
		product.chooseProduct();
		product.scrollDownProduct();
		product.scrollUpProduct();
		product.chooseCart();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-450)", "");	

		SauceDemoCartPage cart = new SauceDemoCartPage(driver);
		cart.removeProductInCart();
		cart.clickOnCheckOut();
		SauceDemoCheckOutInfoPage info = new SauceDemoCheckOutInfoPage(driver);
		info.checkOutVerify();
		//info.checkoutInformation();

//Click on Continue
	   // driver.findElement(By.id("continue")).click();
	    
//CheckOut Overview
	    js.executeScript("window.scrollBy(0,-450)", "");
	    driver.findElement(By.id("finish")).click();
	    
//Verify Thankyou Page   
	    
	    String BackHomeButton= driver.findElement(By.xpath("//button[contains(@class,'btn btn_primary')]")).getText();
	    System.out.println(BackHomeButton+ " is displayed");
	    
	}

	

}
