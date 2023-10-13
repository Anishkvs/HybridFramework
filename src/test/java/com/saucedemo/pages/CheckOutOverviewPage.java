package com.saucedemo.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.saucedemo.keywords.Keywords;

public class CheckOutOverviewPage {

	Keywords locator = new Keywords();

	/**
	 * Method of cancelButtonInCheckoutPage() is used to click on the cancel button
	 * in the Checkout overview page
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void cancelButtonInCheckoutPage(WebDriver driver) throws IOException {

		locator.click(driver, "cancelButtonInCheckoutPage_ID");

	}

	/**
	 * Method of finishButtonInCheckoutPage() is used to click on the finish button
	 * in the Checkout overview page
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void finishButtonInCheckoutPage(WebDriver driver) throws IOException {

		 locator.click(driver, "finishButtonInCheckoutPage_XPATH");

	}

	/**
	 * Method of cancelButtonIsDisplayed() is used to click on the cancel button
	 * in the Checkout overview page
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void cancelButtonIsDisplayed(WebDriver driver) throws IOException {

		driver.findElement(By.id("cancel")).isDisplayed();
	}

}
