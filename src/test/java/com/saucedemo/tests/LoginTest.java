package com.saucedemo.tests;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saucedemo.keywords.Keywords;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.runner.TestRunner;

public class LoginTest extends TestRunner {

	public static LoginPage login;

	@BeforeClass
	public void setUp() throws IOException {
		login = new LoginPage();
	}

	@Test(priority = 1)
	public void TC002_invalidCredentials() throws IOException, InterruptedException {
		ArrayList<String> data = new Keywords().getData("Login");
		login.doLogin(driver, data.get(1).toString(), data.get(2).toString());
//		login.clear();
	}

	@Test(priority = 2)
	public void TC004_validPasswordInvalidUsername() throws IOException, InterruptedException {
		ArrayList<String> datatwo = new Keywords().getData("LoginTwo");
		login.doLogin(driver, datatwo.get(1).toString(), datatwo.get(2).toString());
//		login.clear();
	}

	@Test(priority = 3)
	public void TC003_validUsernameInvalidPassword() throws IOException, InterruptedException {
		ArrayList<String> datathree = new Keywords().getData("LoginThree");
		login.doLogin(driver, datathree.get(1).toString(), datathree.get(2).toString());
//		login.clear();

	}

	@Test(priority = 4)
	public void TC005_loginWithoutCredentials() throws InterruptedException {
//		login.loginButton();
//		 login.clear();
	}

	@Test(priority = 5)
	public void TC001_loginValidCredentials() throws IOException {

		ArrayList<String> datafour = new Keywords().getData("LoginFour");
		login.doLogin(driver, datafour.get(1).toString(), datafour.get(2).toString());

	}
}
