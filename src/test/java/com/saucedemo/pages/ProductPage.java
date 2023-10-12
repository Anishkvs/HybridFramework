package com.saucedemo.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.saucedemo.keywords.Keywords;

public class ProductPage {	

	Keywords locator = new Keywords();

	public void addToCartBackPack(WebDriver driver) throws IOException {

		locator.click(driver, "addToCartBackPack_ID");

	}
	public void addToCartBikeLight(WebDriver driver) throws IOException {

		locator.click(driver, "addToCartBikeLight_ID");

	}
	public void addToCartTShirt(WebDriver driver) throws IOException {

		locator.click(driver, "addToCartTShirt_ID");

	}
	public void addToCartFleeceJacket(WebDriver driver) throws IOException {

		locator.click(driver, "addToCartFleeceJacket_ID");

	}
	public void sortProduct(WebDriver driver) throws IOException {

		locator.click(driver, "sortProduct_XPATH");

	}
	public void deSelectAddToCart(WebDriver driver) throws IOException {

		locator.click(driver, "deSelectAddToCart_ID");
	}
	
	public void removeButtonInCart(WebDriver driver) throws IOException {

		locator.click(driver, "removeButtonInCart_ID");
	}

	public void scrolldown(WebDriver driver) throws IOException {
		//Scroll down and click the product
		locator.click(driver, "scrolldownToLabs_ID");
	}
	
	public void shoppingCartButton(WebDriver driver) throws IOException {

		locator.click(driver, "shoppingCartButton_ID");

	}
	
}


