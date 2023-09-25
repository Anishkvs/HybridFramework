package com.page.object;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.base.TestBase;

@Test
public class SauceDemoApplication extends TestBase{
	
	@Test
	public void runTest() throws IOException, InterruptedException  {
		
		System.setProperty("webdriver.gecko.driver","D:\\driver\\firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		
		LoginTest login = new LoginTest(driver);
		login.launchUrl();
		
		DataDriven obj = new DataDriven();
		ArrayList data = obj.getData("Login");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		
		login.TC002_invalidCredentials(data.get(1).toString(), data.get(2).toString());	
		
		login.TC004_validPasswordInvalidUsername(data.get(3).toString(), data.get(4).toString());
		
		login.TC003_validUsernameInvalidPassword(data.get(5).toString(), data.get(6).toString());
		
		login.TC005_loginWithoutCredentials();
		
		login.TC001_loginValidCredentials(data.get(7).toString(), data.get(8).toString());
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
		
		CheckOutInfoTest check = new CheckOutInfoTest(driver);
		ArrayList info = obj.getData("Add info");
		
		check.TC022_verifyContinueButtonWithoutFirstName();
		
		check.TC023_verifyContinueButtonWithoutLastName(info.get(1).toString(), info.get(2).toString());
		check.TC024_verifyContinueButtonWithoutPostalCode(info.get(3).toString(), info.get(4).toString());
		check.TC025_verifyContinueButtonWithAllDetails(info.get(5).toString(), info.get(6).toString(), info.get(3).toString());
		
		
//		check.TC023_verifyContinueButtonWithoutLastName("FirstName", "689544");
//		check.TC024_verifyContinueButtonWithoutPostalCode("FirstName", "LastName");
//		check.TC025_verifyContinueButtonWithAllDetails("FirstName", "LastName", "689544");
		check.TC026_verifyFinishButtonInCheckoutPage();
		
		
		
	}

	


}
