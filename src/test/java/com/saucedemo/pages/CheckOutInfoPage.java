package com.saucedemo.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.keywords.Keywords;

public class CheckOutInfoPage {

	Keywords locator = new Keywords();

	/**
	 * Method for verifyCart() is used to enter the firstname, lastname and postal
	 * code to the Your information page
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @param firstname
	 * @param lastname
	 * @param Postal
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void verifyCart(WebDriver driver, String firstname, String lastname, String Postal)
			throws IOException, InterruptedException {

		clearInfo(driver);
		driver.findElement(By.id("first-name")).sendKeys(firstname);
		driver.findElement(By.id("last-name")).sendKeys(lastname);
		driver.findElement(By.id("postal-code")).sendKeys(Postal);

	}

	/**
	 * Method for cancelButtonInCheckoutPage() is used to click on the cancel button
	 * in the checkout page
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void cancelButtonInCheckoutPage(WebDriver driver) throws IOException {

		locator.click(driver, "cancel_ID");
	}

	/**
	 * Method for countinueButtonInCheckoutPage() is used to click on the continue
	 * button in the checkout page.
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void countinueButtonInCheckoutPage(WebDriver driver) throws IOException, InterruptedException {

		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
	}

	/**
	 * Method for countinueButtonIsDisplayed() is used to check the continue button
	 * is displayed on the page
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 */
	public void countinueButtonIsDisplayed(WebDriver driver) {

		driver.findElement(By.id("continue")).isDisplayed();

	}

	/**
	 * Method for cancelButtonIsDisplayed() is used to check the cancel button is
	 * displayed on the page
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 */
	public void cancelButtonIsDisplayed(WebDriver driver) {

		driver.findElement(By.id("cancel")).isDisplayed();
	}

	/**
	 * Method for clearInfo() is used to clear the firstname, lastname and postal
	 * code from the your information page
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void clearInfo(WebDriver driver) throws InterruptedException, IOException {
		Thread.sleep(1000);
		driver.findElement(By.id("first-name")).clear();
		driver.findElement(By.id("last-name")).clear();
		driver.findElement(By.id("postal-code")).clear();
		Thread.sleep(1000);
	}
}
