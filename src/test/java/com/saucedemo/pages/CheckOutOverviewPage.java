package com.saucedemo.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.saucedemo.keywords.Keywords;

public class CheckOutOverviewPage  {
	
	Keywords locator = new Keywords();
	
	public void cancelButtonInCheckoutPage(WebDriver driver) throws IOException {

		locator.click(driver, "cancelButtonInCheckoutPage_ID");
		//driver.findElement(By.id("cancel")).click();
	}
	//scroll down 
	public  void finishButtonInCheckoutPage(WebDriver driver) throws IOException {
		
		locator.click(driver, "finishButtonInCheckoutPage_XPATH");
	//	driver.findElement(By.xpath("//button[@id='finish']")).click();
		
	}
	
	public  void cancelButtonIsDisplayed(WebDriver driver) throws IOException {
		locator.click(driver, "cancelButtonIsDisplayed_ID");
		//driver.findElement(By.id("cancel")).isDisplayed();
	}
	
	
}
