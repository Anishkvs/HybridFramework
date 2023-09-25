package com.page.object.testng;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.saucedemo.SauceDemoLoginPage;

@Test
public class SauceDemoApplication {
	
	@Test
	public void runTest() throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver","D:\\driver\\firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
		
		
		LoginTest login = new LoginTest(driver);
		login.launchUrl();
		
		login.TC002_invalidCredentials("standard_userTest", "secret_sauce123");	
		login.TC004_validPasswordInvalidUsername("standard_userTest", "secret_sauce");
		login.TC003_validUsernameInvalidPassword("standard_user", "secret_sauce123");
		login.TC005_loginWithoutCredentials("", "");
		login.TC001_loginValidCredentials("standard_user", "secret_sauce");
		//login.tearDown();
		
		ProductTest product = new ProductTest(driver);
		product.TC014_sortDescendingOrder();
		product.TC015_sortLowToHigh();
		product.TC016_sortHighToLow();
		product.TC013_sortAscendingOrder();
		product.TC008_addToCart();
		product.TC012_deSelectAddToCart();
		product.TC017_verifyShoppingCartButton();
		product.TC018_verifyRemoveButton();
		product.TC019_verifyCheckoutButton();
		product.TC022_verifyContinueButtonWithoutFirstName();
		product.TC023_verifyContinueButtonWithoutLastName("FirstName", "689544");
		product.TC024_verifyContinueButtonWithoutPostalCode("FirstName", "LastName");
		product.TC025_verifyContinueButtonWithAllDetails("FirstName", "LastName", "689544");
		product.TC026_verifyFinishButtonInCheckoutPage();
		
		
		
	}

	


}
