package com.saucedemo.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.saucedemo.keywords.Keywords;

public class LoginPage {

	Keywords locator = new Keywords();

	public void doLogin(WebDriver driver, String username, String password) throws IOException {

		locator.type(driver, "username_ID", username);
		locator.type(driver, "password_ID", password);
		locator.click(driver, "loginButton_ID");

	}



//	public void clear() throws InterruptedException {
//		Thread.sleep(1000);
//		driver.findElement(By.id("user-name")).clear();
//		driver.findElement(By.xpath("//input[@id='password']")).clear();
//
//	}


}
