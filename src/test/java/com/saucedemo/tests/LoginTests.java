package com.saucedemo.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.TestBase;

public class LoginTests extends TestBase {


	@BeforeClass
	public void launchApplication() {
		//driver.get("https://www.saucedemo.com/");
		
	}
	@Test(priority = 5)
	public void TC001_loginValidCredentials() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login application");
		verifyHomePageTitle();
	}

	@Test(priority = 1)
	public void TC002_invalidCredentials() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user1");
		driver.findElement(By.id("password")).sendKeys("secret_sauce1");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login with wrong credential ");
		driver.navigate().refresh();

	}

	@Test(priority = 2)
	public void TC004_validPasswordInvalidUsername() {
		driver.findElement(By.id("user-name")).sendKeys("Wrong-user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login with wrong user");
		driver.navigate().refresh();

	}

	@Test(priority = 3)
	public void TC003_validUsernameInvalidPassword() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("Wrong-pass");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login with wrong password");
		driver.navigate().refresh();

	}

	@Test(priority = 4)
	public void TC005_loginWithoutCredentials() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("Wrong-pass");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login without credential");
		driver.navigate().refresh();

	}

	@Test
	public void TC007_navigateBrowserBack() {
		driver.navigate().back();
	}

	@Test
	public void TC006_navigateBrowserForward() {
		driver.navigate().forward();
	}

//	@Test
//	public void verifyLogin() {
//		wrongCredentialLogin();
//		wrongUserLogin();
//		wrongPassLogin();
//		withoutCredentialLogin();
//
//	}

	
	

	
	private void verifyHomePageTitle() {

		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Launch Product page");

	}
	
	public void AfterTest() {
		driver.quit();

	}

}
