package com.page;

import java.io.IOException;
import java.util.ArrayList;
import org.testng.annotations.Test;
import com.testbase.TestBase;

public class SauceDemoApplication extends TestBase {

	@Test
	public void SauceDemo() throws IOException, InterruptedException {

		LoginTest login = new LoginTest(driver);
		login.launchUrl();

		DataDriven obj = new DataDriven();
		ArrayList data = obj.getData("Login");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));

		login.TC002_invalidCredentials(data.get(1).toString(), data.get(2).toString());
		ArrayList datatwo = obj.getData("LoginTwo");
		login.TC004_validPasswordInvalidUsername(datatwo.get(1).toString(), datatwo.get(2).toString());
		ArrayList datathree = obj.getData("LoginThree");
		login.TC003_validUsernameInvalidPassword(datathree.get(1).toString(), datathree.get(2).toString());
		ArrayList datafour = obj.getData("LoginFour");

		login.TC005_loginWithoutCredentials();

		login.TC001_loginValidCredentials(datafour.get(1).toString(), datafour.get(2).toString());
		// login.tearDown();

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
		ArrayList info = obj.getData("AddInfoOne");
		System.out.println("AddInfoOne");
		check.TC022_verifyContinueButtonWithoutFirstName();

		check.TC023_verifyContinueButtonWithoutLastName(info.get(1).toString(), info.get(2).toString());
		//ArrayList infotwo = obj.getData("AddInfoTwo");
		//System.out.println("AddInfoTwo");
		//check.TC024_verifyContinueButtonWithoutPostalCode(infotwo.get(1).toString(), infotwo.get(2).toString());
		ArrayList infothree = obj.getData("AddInfoThree");
		System.out.println("AddInfoThree");
		
		check.TC025_verifyContinueButtonWithAllDetails(infothree.get(1).toString(), infothree.get(2).toString(), infothree.get(3).toString());
		
		System.out.println("Click on Finish Button");
		check.TC026_verifyFinishButtonInCheckoutPage();
		

	}

}
