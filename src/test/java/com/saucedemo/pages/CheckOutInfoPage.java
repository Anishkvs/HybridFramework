package com.saucedemo.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.keywords.Keywords;

public class CheckOutInfoPage {

	Keywords locator = new Keywords();

	public void verifyCart(WebDriver driver, String firstname, String lastname, String Postal) throws IOException {

		locator.select(driver, "firstname_ID", firstname);
		locator.select(driver, "lastname_ID", lastname);
		locator.select(driver, "postalcode_ID", Postal);

		//driver.findElement(By.id("first-name")).sendKeys(firstname);
		//driver.findElement(By.id("last-name")).sendKeys(lastname);
		//driver.findElement(By.id("postal-code")).sendKeys(Postal);
	}

	public void cancelButtonInCheckoutPage(WebDriver driver) throws IOException {

		locator.click(driver, "cancel_ID");
		//driver.findElement(By.id("cancel")).click();
	}

	public void countinueButtonInCheckoutPage(WebDriver driver) throws IOException {
		
		locator.click(driver, "continue_ID");
		//driver.findElement(By.id("continue")).click();
	}

	public void countinueButtonIsDisplayed(WebDriver driver) {
	
		driver.findElement(By.id("continue")).isDisplayed();

	}

	public void cancelButtonIsDisplayed(WebDriver driver) {

		driver.findElement(By.id("cancel")).isDisplayed();
	}

	public void clearInfo(WebDriver driver) throws InterruptedException, IOException {
		Thread.sleep(1000);
		driver.findElement(By.id("first-name")).clear();
		driver.findElement(By.id("last-name")).clear();
		driver.findElement(By.id("postal-code")).clear();
		Thread.sleep(1000);
	}
}
