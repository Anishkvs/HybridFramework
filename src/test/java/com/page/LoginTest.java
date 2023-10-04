package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.keywords.Keywords;


import com.testbase.TestBase;

public class LoginTest extends TestBase {

	WebDriver driver;

	public LoginTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@class='submit-button btn_action']")
	WebElement loginButton;

	Keywords page = new Keywords();
	
	@Test(priority = 5)
	public void TC001_loginValidCredentials(String name, String pass) {

		userName.sendKeys(name);
		password.sendKeys(pass);
		loginButton.click();
		System.out.println("Login application");
		page.verifyHomePageTitle(driver);
		//verifyHomePageTitle();

	}

	@Test(priority = 1)
	public void TC002_invalidCredentials(String name, String pass) {
		// test = extent.createTest("TC002: Login with wrong credential");
		userName.sendKeys(name);
		password.sendKeys(pass);
		loginButton.click();
		System.out.println("Login with wrong credential ");
		clearCredentials();
		driver.navigate().refresh();

	}

	@Test(priority = 2)
	public void TC004_validPasswordInvalidUsername(String name, String pass) {
		// test = extent.createTest("TC004: Login with wrong user");
		userName.sendKeys(name);
		password.sendKeys(pass);
		loginButton.click();
		System.out.println("Login with wrong user");
		clearCredentials();
		driver.navigate().refresh();

	}

	@Test(priority = 3)
	public void TC003_validUsernameInvalidPassword(String name, String pass) {
		// test = extent.createTest("TC003: Login with wrong password");
		userName.sendKeys(name);
		password.sendKeys(pass);
		loginButton.click();
		System.out.println("Login with wrong password");
		clearCredentials();
		driver.navigate().refresh();

	}

	@Test(priority = 4)
	public void TC005_loginWithoutCredentials() throws InterruptedException {
		// test = extent.createTest("TC005: Login without credential");
		Thread.sleep(1000);
		loginButton.click();
		System.out.println("Login without credential");
		clearCredentials();
		driver.navigate().refresh();

	}

	@Test
	public void TC007_navigateBrowserBack() {
		// test = extent.createTest("TC007: Navigate Browser Back after login");
		driver.navigate().back();
	}

	@Test
	public void TC006_navigateBrowserForward() {
		// test = extent.createTest("TC006: Navigate Browser Forward before login");
		driver.navigate().forward();
	}

	@Test
	private void verifyHomePageTitle() {

		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Launch Product page");
		// driver.quit();
	}

	public void AfterTest() {

		driver.quit();

	}

	@Test
	public void launchUrl() {

		driver.get(config.getProperty("applicationurl"));

	}

	private void clearCredentials() {
		userName.clear();
		password.clear();

	}

	@Test
	public void tearDown() {
		driver.close();
	}

}
