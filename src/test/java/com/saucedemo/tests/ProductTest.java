package com.saucedemo.tests;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.saucedemo.keywords.Keywords;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckOutInfoPage;
import com.saucedemo.pages.CheckOutOverviewPage;
import com.saucedemo.pages.CompletePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import com.saucedemo.runner.TestRunner;

public class ProductTest extends TestRunner {

	Keywords page = new Keywords();
	LoginTest log = new LoginTest();
	LoginPage login = new LoginPage();
	ProductPage product = new ProductPage();
	CartPage cart = new CartPage();
	CheckOutInfoPage info = new CheckOutInfoPage();
	CheckOutOverviewPage overview = new CheckOutOverviewPage();
	CompletePage complete = new CompletePage();
	

	@BeforeClass
	public void setUp() throws IOException, InterruptedException {
		ArrayList<String> datafour = new Keywords().getData("LoginFour");
		login.doLogin(driver, datafour.get(1).toString(), datafour.get(2).toString());

	}

	@Test(priority = 1)
	public void TC014_sortDescendingOrder() throws InterruptedException, IOException {

		Thread.sleep(2000);
		product.sortProduct(driver);
		By dropdownLocator = By.xpath("//select[@class='product_sort_container']");
		String optionText = "Name (Z to A)";
		page.selectOptionByVisibleText(driver, dropdownLocator, optionText);

	}

	@Test(priority = 2)
	public void TC015_sortLowToHigh() throws IOException {
		product.sortProduct(driver);

		By dropdownLocator = By.xpath("//select[@class='product_sort_container']");
		String optionText = "Price (low to high)";
		page.selectOptionByVisibleText(driver, dropdownLocator, optionText);

	}

	@Test(priority = 3)
	public void TC016_sortHighToLow() throws IOException {
		product.sortProduct(driver);

		By dropdownLocator = By.xpath("//select[@class='product_sort_container']");
		String optionText = "Price (high to low)";
		page.selectOptionByVisibleText(driver, dropdownLocator, optionText);

	}

	@Test(priority = 4)
	public void TC013_sortAscendingOrder() throws IOException {
		product.sortProduct(driver);
		
		By dropdownLocator = By.xpath("//select[@class='product_sort_container']");
		String optionText = "Name (A to Z)";
		page.selectOptionByVisibleText(driver, dropdownLocator, optionText);

	}

	@Test(priority = 5)
	public void TC008_addToCart() throws InterruptedException, IOException {
		// test = extent.createTest("TC008_Choose the product");
		product.addToCartBackPack(driver);

	}

	@Test(priority = 6)
	public void TC009_addToAllCart() throws InterruptedException, IOException {
		// test = extent.createTest("TC008_Choose the product");

		System.out.println("Choose the product");
		product.addToCartBikeLight(driver);
		product.addToCartTShirt(driver);
		product.addToCartFleeceJacket(driver);
		//page.scroll(driver, -450);
		scrollDownProduct();
	}

	private void scrollDownProduct() throws InterruptedException, IOException {
		// scroll down Product page
		System.out.println("Scroll Down");
		;
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0,-450)", "");
		product.scrolldown(driver);
		Thread.sleep(2000);
	}

	@Test(priority = 7)
	public void TC012_deSelectAddToCart() throws InterruptedException, IOException {

		// test = extent.createTest("TC012: de-Select Add To Cart");
		System.out.println("Scroll Up");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

		// Remove 2nd product
		product.deSelectAddToCart(driver);
		Thread.sleep(1000);
	}

	@Test(priority = 8)
	public void TC017_verifyShoppingCartButton() throws InterruptedException, IOException {
		product.shoppingCartButton(driver);

	}

	@Test(priority = 9)
	public void TC018_verifyRemoveButton() throws InterruptedException, IOException {

		Thread.sleep(1000);
		product.removeButtonInCart(driver);
		Thread.sleep(1000);
	}

	@Test(priority = 10)
	public void TC019_verifyCheckoutButton() throws IOException {

		cart.checkoutButton(driver);

	}

	@Test(priority = 11)
	public void TC020_verifyContinueShoppingButton() {
		info.countinueButtonIsDisplayed(driver);
		System.out.println("Verify continue button");

	}

	 @Test(priority = 12)
	public void TC021_verifyCancelButton() {
		info.cancelButtonIsDisplayed(driver);
		System.out.println("Verify cancel button");
	}

	@Test(priority = 13)
	public void TC022_verifyContinueButtonWithoutFirstName() throws IOException, InterruptedException {
		info.countinueButtonInCheckoutPage(this.driver);
		info.clearInfo(this.driver);
	}

	@Test(priority = 14)
	public void TC023_verifyContinueButtonWithoutLastName() throws IOException, InterruptedException {
		ArrayList<String> data = new Keywords().getData("AddInfoOne");
		System.out.println("AddInfoOne");
		info.verifyCart(driver, data.get(1).toString(), null, data.get(3).toString() );
		
		info.countinueButtonInCheckoutPage(this.driver);
		info.clearInfo(this.driver);

	}

	@Test(priority = 15)
	public void TC024_verifyContinueButtonWithoutPostalCode() throws IOException, InterruptedException {
		ArrayList<String> infotwo = new Keywords().getData("AddInfoTwo");
		System.out.println("AddInfoTwo");
		info.verifyCart(driver, infotwo.get(1).toString(), infotwo.get(2).toString(), null);
		info.countinueButtonInCheckoutPage(this.driver);
		info.clearInfo(this.driver);
	}

	@Test(priority = 16)
	public void TC025_verifyContinueButtonWithAllDetails() throws IOException, InterruptedException {
		Thread.sleep(2000);
		ArrayList<String> infothree = new Keywords().getData("AddInfoThree");
		System.out.println("AddInfoThree");
		info.verifyCart(driver, infothree.get(1).toString(), infothree.get(2).toString(), infothree.get(3).toString());
		info.countinueButtonInCheckoutPage(this.driver);

	}

	@Test(priority = 17)
	public void TC027_verifyCancelButtonInCheckoutPage() throws IOException {
		overview.cancelButtonIsDisplayed(this.driver);
	}


	@Test(priority = 18)
	public void TC026_verifyFinishButtonInCheckoutPage() throws IOException {

		overview.finishButtonInCheckoutPage(this.driver);

	}

	@Test(priority = 19)
	public void TC007_navigateBrowserBack() throws InterruptedException {
		page.navigateBack(this.driver);
		Thread.sleep(2000);
	}

	@Test(priority = 20)
	public void TC006_navigateBrowserForward() throws InterruptedException {
		page.navigateForward(this.driver);
		Thread.sleep(2000);

	}
	@Test(priority = 21)
	public void TC030_verifyThankYouMessageInOverviewPage() {
		complete.verifyThankYouMessage(driver);
		
	}
	
}
