package com.saucedemo.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.keywords.Keywords;

public class LoginPage {

	Keywords locator = new Keywords();

	public void doLogin(WebDriver driver, String username, String password) throws IOException, InterruptedException {
		
		driver.navigate().refresh();
		Thread.sleep(1000);
		locator.type(driver, "username_ID", username);
		locator.type(driver, "password_ID", password);
		locator.click(driver, "loginButton_ID");
	}

	@Test
	public void verifyHomePageTitle(WebDriver driver) {

		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Launch Product page");		
		
	}

	public void loginButton(WebDriver driver) throws IOException, InterruptedException {
		
		locator.click(driver, "loginButton_ID");
		Thread.sleep(1000);
	}



}
