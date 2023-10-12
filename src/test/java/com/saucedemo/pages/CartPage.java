package com.saucedemo.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.saucedemo.keywords.Keywords;

public class CartPage {
	
	Keywords locator = new Keywords();
	
	public void continueShoppingButton(WebDriver driver) throws IOException {
		locator.click(driver, "continueShoppingButton_ID");
	}
	
	public void removeButtonInCart(WebDriver driver) throws IOException {
		locator.click(driver, "removeButtonInCart_ID");
	}

	public void checkoutButton(WebDriver driver) throws IOException {
		locator.click(driver, "checkoutButton_ID");
	
	}
	
	
}
