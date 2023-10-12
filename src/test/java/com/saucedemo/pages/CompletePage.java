package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.saucedemo.keywords.Keywords;

public class CompletePage  {

	Keywords locator = new Keywords();

	public void verifyThankYouMessage(WebDriver driver) {
		
		
        WebElement actual= driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]"));		
		locator.assertEquals(actual, "Thank you for your order!");
		
	}
	
	
}
