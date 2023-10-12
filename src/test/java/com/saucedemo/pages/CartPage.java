package com.saucedemo.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.saucedemo.keywords.Keywords;

public class CartPage {

	Keywords locator = new Keywords();

	/**
	 * Method for continueShoppingButton() is used to click on shopping button
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void continueShoppingButton(WebDriver driver) throws IOException {
		locator.click(driver, "continueShoppingButton_ID");
	}

	/**
	 * Method for removeButtonInCart(), is used to click on remove button
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void removeButtonInCart(WebDriver driver) throws IOException {
		locator.click(driver, "removeButtonInCart_ID");
	}

	/**
	 * Method of checkoutButton() is used to click on Checkout button
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void checkoutButton(WebDriver driver) throws IOException {
		locator.click(driver, "checkoutButton_ID");

	}

}
