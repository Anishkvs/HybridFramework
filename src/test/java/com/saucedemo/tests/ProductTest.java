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

	@Test(priority = 1, description = "Sort the product in descending order.")
	public void TC014_sortDescendingOrder() throws InterruptedException, IOException {

		Thread.sleep(2000);
		product.sortProduct(driver);
		By dropdownLocator = By.xpath("//select[@class='product_sort_container']");
		String optionText = "Name (Z to A)";
		page.selectOptionByVisibleText(driver, dropdownLocator, optionText);

	}

	@Test(priority = 2, description = "Sort the product price from low to high.")
	public void TC015_sortLowToHigh() throws IOException {
		product.sortProduct(driver);

		By dropdownLocator = By.xpath("//select[@class='product_sort_container']");
		String optionText = "Price (low to high)";
		page.selectOptionByVisibleText(driver, dropdownLocator, optionText);

	}

	@Test(priority = 3, description = "Sort the product price from high to low.")
	public void TC016_sortHighToLow() throws IOException {
		product.sortProduct(driver);

		By dropdownLocator = By.xpath("//select[@class='product_sort_container']");
		String optionText = "Price (high to low)";
		page.selectOptionByVisibleText(driver, dropdownLocator, optionText);

	}

	@Test(priority = 4, description = "Sort the product in ascending order.")
	public void TC013_sortAscendingOrder() throws IOException {
		product.sortProduct(driver);
		
		By dropdownLocator = By.xpath("//select[@class='product_sort_container']");
		String optionText = "Name (A to Z)";
		page.selectOptionByVisibleText(driver, dropdownLocator, optionText);

	}

	@Test(priority = 5, description = "Add a product to the cart.")
	public void TC008_addToCart() throws InterruptedException, IOException {

		product.addToCartBackPack(driver);

	}

	@Test(priority = 6, description = "Add all the products to the cart.")
	public void TC009_addToAllCart() throws InterruptedException, IOException {
		System.out.println("Choose the product");
		product.addToCartBikeLight(driver);
		product.addToCartTShirt(driver);
		product.addToCartFleeceJacket(driver);
		scrollDownProduct();
	}

	private void scrollDownProduct() throws InterruptedException, IOException {

		System.out.println("Scroll Down");
		;
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0,-450)", "");
		product.scrolldown(driver);
		Thread.sleep(2000);
	}

	@Test(priority = 7, description = "De-select a product from the cart.")
	public void TC012_deSelectAddToCart() throws InterruptedException, IOException {

		System.out.println("Scroll Up");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

		// Remove 2nd product
		product.deSelectAddToCart(driver);
		Thread.sleep(1000);
	}

	@Test(priority = 8, description = "Click on the shopping cart button in the product page.")
	public void TC017_verifyShoppingCartButton() throws InterruptedException, IOException {
		product.shoppingCartButton(driver);

	}

	@Test(priority = 9, description = "Verify the remove button from the product page.")
	public void TC018_verifyRemoveButton() throws InterruptedException, IOException {

		Thread.sleep(1000);
		product.removeButtonInCart(driver);
		Thread.sleep(1000);
	}

	@Test(priority = 10, description = "Verify the checkout button from the cart page.")
	public void TC019_verifyCheckoutButton() throws IOException {

		cart.checkoutButton(driver);

	}

	@Test(priority = 11, description = "Verify the continue shopping button in the information page.")
	public void TC020_verifyContinueShoppingButton() {
		info.countinueButtonIsDisplayed(driver);
		System.out.println("Verify continue button");

	}

	@Test(priority = 12, description = "Verify the cancel button in the information page.")
	public void TC021_verifyCancelButton() {
		info.cancelButtonIsDisplayed(driver);
		System.out.println("Verify cancel button");
	}

	@Test(priority = 13, description = "Verify clicking on the continue button without user information.")
	public void TC022_verifyContinueButtonWithoutFirstName() throws IOException, InterruptedException {
		info.countinueButtonInCheckoutPage(this.driver);
		info.clearInfo(this.driver);
	}

	@Test(priority = 14, description = "Verify clicking on the continue button without a last name.")
	public void TC023_verifyContinueButtonWithoutLastName() throws IOException, InterruptedException {
		ArrayList<String> data = new Keywords().getData("AddInfoOne");
		System.out.println("AddInfoOne");
		info.verifyCart(driver, data.get(1).toString(), "", data.get(3).toString() );
		
		info.countinueButtonInCheckoutPage(this.driver);
		info.clearInfo(this.driver);

	}

	@Test(priority = 15, description = "Verify clicking on the continue button without a postal code.")
	public void TC024_verifyContinueButtonWithoutPostalCode() throws IOException, InterruptedException {
		ArrayList<String> infotwo = new Keywords().getData("AddInfoTwo");
		System.out.println("AddInfoTwo");
		info.verifyCart(driver, infotwo.get(1).toString(), infotwo.get(2).toString(), "");
		info.countinueButtonInCheckoutPage(this.driver);
		info.clearInfo(this.driver);
	}

	@Test(priority = 16, description = "Verify clicking on the continue button with all details.")
	public void TC025_verifyContinueButtonWithAllDetails() throws IOException, InterruptedException {
		Thread.sleep(2000);
		ArrayList<String> infothree = new Keywords().getData("AddInfoThree");
		System.out.println("AddInfoThree");
		info.verifyCart(driver, infothree.get(1).toString(), infothree.get(2).toString(), infothree.get(3).toString());
		info.countinueButtonInCheckoutPage(this.driver);

	}

	@Test(priority = 17, description = "Verify the cancel button in the checkout page.")
	public void TC027_verifyCancelButtonInCheckoutPage() throws IOException {
		overview.cancelButtonIsDisplayed(this.driver);
	}


	@Test(priority = 18, description = "Verify clicking on the finish button in the checkout page last name.")
	public void TC026_verifyFinishButtonInCheckoutPage() throws IOException {

		overview.finishButtonInCheckoutPage(this.driver);

	}

	@Test(priority = 19, description = "Verify browser back possibilities.")
	public void TC007_navigateBrowserBack() throws InterruptedException {
		page.navigateBack(this.driver);
		Thread.sleep(2000);
	}

	@Test(priority = 20, description = "Verify browser forward possibilities.")
	public void TC006_navigateBrowserForward() throws InterruptedException {
		page.navigateForward(this.driver);
		Thread.sleep(2000);

	}
	
	@Test(priority = 21, description = "Verify the 'Thank you' message in the overview page.")
	public void TC030_verifyThankYouMessageInOverviewPage() {
		complete.verifyThankYouMessage(this.driver);
		
	}
	
}
