package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.saucedemo.keywords.Keywords;

public class CompletePage {

	Keywords locator = new Keywords();

	/**
	 * Method for verifyThankYouMessage() is used to verify the actual and expected
	 * text.
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 */
	public void verifyThankYouMessage(WebDriver driver) {

		WebElement actual = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your order!')]"));
		locator.assertEquals(actual.getText(), "Thank you for your order!");

	}

}
