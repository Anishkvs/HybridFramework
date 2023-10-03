package com.saucedemo.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.testbase.TestBase;

public class LoginTests extends TestBase {


	
	@Test(priority = 5)
	public void TC001_loginValidCredentials() {
		//extent.createTest("TC001: Login Application");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login application");
		verifyHomePageTitle();
	}

	@Test(priority = 1)
	public void TC002_invalidCredentials() {
		//test = extent.createTest("TC002: Login with wrong credential");
		driver.findElement(By.id("user-name")).sendKeys("standard_user1");
		driver.findElement(By.id("password")).sendKeys("secret_sauce1");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login with wrong credential ");
		driver.navigate().refresh();

	}

	@Test(priority = 2)
	public void TC004_validPasswordInvalidUsername() {
		//test = extent.createTest("TC004: Login with wrong user");
		driver.findElement(By.id("user-name")).sendKeys("Wrong-user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login with wrong user");
		driver.navigate().refresh();

	}

	@Test(priority = 3)
	public void TC003_validUsernameInvalidPassword() {
		//test = extent.createTest("TC003: Login with wrong password");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("Wrong-pass");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login with wrong password");
		driver.navigate().refresh();

	}

	@Test(priority = 4)
	public void TC005_loginWithoutCredentials() {
		//test = extent.createTest("TC005: Login without credential");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("Wrong-pass");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login without credential");
		driver.navigate().refresh();

	}

	@Test
	public void TC007_navigateBrowserBack() {
		//test = extent.createTest("TC007: Navigate Browser Back after login");
		driver.navigate().back();
	}

	@Test
	public void TC006_navigateBrowserForward() {
		//test = extent.createTest("TC006: Navigate Browser Forward before login");
		driver.navigate().forward();
	}

	
	private void verifyHomePageTitle() {

		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Launch Product page");
		//driver.quit();
	}
	
	public void AfterTest() {
		
		driver.quit();

	}

}
