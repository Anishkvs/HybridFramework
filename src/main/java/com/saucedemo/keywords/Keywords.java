package com.saucedemo.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Keywords {

	/**
	 * Methods for DropDown - VisibleText, Assertion - Verify PageTitle,
	 * clickElement, sendKeysToElement
	 * 
	 * @author Anish
	 * @since 04/October/2023
	 * @param driver
	 * @param text
	 */
	public void selectOptionByVisibleText(WebElement dropdownElement, WebDriver driver, By locator, String text) {

		dropdownElement = driver.findElement(locator);
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(text);
	}

	public void verifyHomePageTitle(WebDriver driver) {

		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
	}

	public void clickElement(WebElement element, WebDriver driver, By locator) {
		element = driver.findElement(locator);
		element.click();
	}

	public void sendKeysToElement(WebElement element, WebDriver driver, By locator, String text) {
		element = driver.findElement(locator);
		element.sendKeys(text);
	}

}
