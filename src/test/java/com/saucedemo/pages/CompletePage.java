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
	public void verifyThankYouMessage(WebDriver driver ) {
		By Locator = By.xpath("//h2[contains(text(),'Thank you for your order!')]");
		WebElement actual = driver.findElement(Locator);
		String actualText = locator.getText(driver, actual); 
		String expectedText = "Thank you for your order!";
		locator.assertEquals(actualText, expectedText);

	}

}
