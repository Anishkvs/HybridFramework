package com.saucedemo.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.saucedemo.keywords.Keywords;

public class ProductPage {

	Keywords locator = new Keywords();

	/**
	 * Method for addToCartBackPack() is used to add product from the cart.
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void addToCartBackPack(WebDriver driver) throws IOException {

		locator.click(driver, "addToCartBackPack_ID");

	}

	/**
	 * Method for addToCartBikeLight() is used to add product from the cart.
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void addToCartBikeLight(WebDriver driver) throws IOException {

		locator.click(driver, "addToCartBikeLight_ID");

	}

	/**
	 * Method for addToCartTShirt() is used to add product from the cart.
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void addToCartTShirt(WebDriver driver) throws IOException {

		locator.click(driver, "addToCartTShirt_ID");

	}

	/**
	 * Method for addToCartFleeceJacket() is used to add product from the cart.
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void addToCartFleeceJacket(WebDriver driver) throws IOException {

		locator.click(driver, "addToCartFleeceJacket_ID");

	}

	/**
	 * Method for sortProduct() is used to sort the product from the cart.
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void sortProduct(WebDriver driver) throws IOException {

		locator.click(driver, "sortProduct_XPATH");

	}

	/**
	 * Method for deSelectAddToCart() is used to de-select the product from the
	 * cart.
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void deSelectAddToCart(WebDriver driver) throws IOException {

		locator.click(driver, "deSelectAddToCart_ID");
	}

	/**
	 * Method for removeButtonInCart() is used to remove the product from the cart.
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
	 * Method for scrolldown() is used to add the sauce-labs-onesie product from the
	 * cart.
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void scrolldown(WebDriver driver) throws IOException {

		locator.click(driver, "scrolldownToLabs_ID");
	}

	/**
	 * Method for shoppingCartButton() is used to click on the shopping cart button
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 */
	public void shoppingCartButton(WebDriver driver) throws IOException {

		locator.click(driver, "shoppingCartButton_ID");

	}

}
