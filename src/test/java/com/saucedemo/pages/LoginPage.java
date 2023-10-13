package com.saucedemo.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.saucedemo.keywords.Keywords;

public class LoginPage {

	Keywords locator = new Keywords();

	/**
	 * Method for doLogin() is used to login Saucedemo application
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @param username
	 * @param password
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void doLogin(WebDriver driver, String username, String password) throws IOException, InterruptedException {

		driver.navigate().refresh();
		Thread.sleep(1000);
		locator.type(driver, "username_ID", username);
		locator.type(driver, "password_ID", password);
		locator.click(driver, "loginButton_ID");
	}

	/**
	 * Method for verifyHomePageTitle() is verify the actual and expected Saucedemo
	 * application page title
	 * 
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 */

	public void verifyHomePageTitle(WebDriver driver) {
		
		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
		locator.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Launch Product page");

	}

	/**
	 * Method for loginButton() is used click on the login button
	 * @author Anish
	 * @since 12/October/2023
	 * @param driver
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void loginButton(WebDriver driver) throws IOException, InterruptedException {

		locator.click(driver, "loginButton_ID");
		Thread.sleep(1000);
	}

}
