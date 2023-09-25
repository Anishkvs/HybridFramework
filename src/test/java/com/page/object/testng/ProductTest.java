package com.page.object.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.base.TestBase;

public class ProductTest extends TestBase {
	
	WebDriver driver;
	
	public ProductTest(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	WebElement addToCartBackPack;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	WebElement addToCartBikeLight;
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement addToCartTShirt;
	
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
	WebElement addToCartFleeceJacket;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	WebElement sortDescendingOrder;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	WebElement sortLowToHigh;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	WebElement sortHighToLow;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	WebElement sortAscendingOrder;
	
	@FindBy(id="remove-sauce-labs-bike-light")
	WebElement deSelectAddToCart;
	
	@FindBy(className="shopping_cart_link")
	WebElement shoppingCartButton;
	
	@FindBy(id="remove-sauce-labs-onesie")
	WebElement removeButtonInCart;
	
	@FindBy(id="checkout")
	WebElement checkoutButton;
	
	@FindBy(id="continue")
	WebElement continueButtonInInfoPage;
	
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement postalCode;
	
	@FindBy(xpath="//button[@id='finish']")
	WebElement finishButtonInCheckoutPage;
	

    @Test(priority = 1)
	public void TC014_sortDescendingOrder()
	{
    	sortDescendingOrder.click();
    	//test = extent.createTest("TC014_Sort Descending Order");
		//driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Name (Z to A)");

	}
    
    @Test(priority = 2)
	public void TC015_sortLowToHigh()
	{
    	sortLowToHigh.click();
 		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Price (low to high)");

	}
    
    @Test(priority = 3)
	public void TC016_sortHighToLow()
	{
    	sortHighToLow.click();
  		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Price (high to low)");

	}
    
    @Test(priority = 4)
	public void TC013_sortAscendingOrder()
	{
    	sortAscendingOrder.click();
		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Name (A to Z)");
	}
	
	@Test(priority = 5)
    public void TC008_addToCart() throws InterruptedException {
		//test = extent.createTest("TC008_Choose the product");
	    
    	System.out.println("Choose the product");  	  	
    	addToCartBackPack.click();
    	addToCartBikeLight.click();
    	addToCartTShirt.click();
    	addToCartFleeceJacket.click();
    	scrollDownProduct();
	}

	//@Test(priority = 6)
    private void scrollDownProduct() throws InterruptedException
    {
    	//scroll down Product page
  		System.out.println("Scroll Down");;
  		JavascriptExecutor jss = (JavascriptExecutor) driver;
  	    jss.executeScript("window.scrollBy(0,-450)", "");
  	    driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		Thread.sleep(2000);  	
    }
	
    @Test(priority = 7)
    public void TC012_deSelectAddToCart() throws InterruptedException
    {
    	
    	//test = extent.createTest("TC012: de-Select Add To Cart");
    	System.out.println("Scroll Up");
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
  		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
  		
  //Remove 2nd product
  		deSelectAddToCart.click();
  		Thread.sleep(1000);   
    }
    
    @Test(priority = 8)
    public void TC017_verifyShoppingCartButton() throws InterruptedException
    {
    	shoppingCartButton.click();
     	
    }
	
    @Test(priority = 9)
	 public void TC018_verifyRemoveButton() throws InterruptedException {
		
			Thread.sleep(1000);
			removeButtonInCart.click();
		    Thread.sleep(1000);
		}
	 
   @Test(priority = 10)
    public void TC019_verifyCheckoutButton() {
 	
	   checkoutButton.click();
	}
	 
   @Test(priority = 11)
	 public void TC022_verifyContinueButtonWithoutFirstName() throws InterruptedException {
  
	   continueButtonInInfoPage.click();
	   Thread.sleep(2000);
		 
		}
  
  @Test(priority = 12)
	 public void TC023_verifyContinueButtonWithoutLastName(String firstInfoName, String userPostalCode) throws InterruptedException {
  	
	  firstName.sendKeys(firstInfoName);
	  postalCode.sendKeys(userPostalCode);
	  continueButtonInInfoPage.click();
	    Thread.sleep(2000);
		
     }

  @Test(priority = 13)
	 public void TC024_verifyContinueButtonWithoutPostalCode(String firstInfoName, String lastInfoName) throws InterruptedException {
	  clearInfo();
  	
	  firstName.sendKeys(firstInfoName);
	  lastName.sendKeys(lastInfoName);
	  continueButtonInInfoPage.click();
  	  Thread.sleep(1000);   
		}
		
  @Test(priority = 14)
	 public void TC025_verifyContinueButtonWithAllDetails(String firstInfoName, String lastInfoName, String userPostalCode) throws InterruptedException {
//CheckOut Information
		clearInfo();
		firstName.sendKeys(firstInfoName);
		lastName.sendKeys(lastInfoName);
		postalCode.sendKeys(userPostalCode);
		continueButtonInInfoPage.click();
	}
	 
     @Test(priority = 15)
 public void TC026_verifyFinishButtonInCheckoutPage() throws InterruptedException {
 	//test = extent.createTest("TC026 Verify Finish Button");
    	 Thread.sleep(2000);
    	 JavascriptExecutor jss = (JavascriptExecutor) driver;
    	 jss.executeScript("window.scrollBy(0,-450)", "");    
 	
		 Thread.sleep(2000);
		 finishButtonInCheckoutPage.click();

	}
		
		private void clearInfo() 
		{
			firstName.clear();
			lastName.clear();
			postalCode.clear();
		
		}   
	
	
	public void tearDown() {
		driver.close();
	}
	
	
}


