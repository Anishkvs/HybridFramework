package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.saucedemo.keywords.Keywords;
import com.testbase.TestBase;

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
	WebElement sortProduct;
	
	@FindBy(id="remove-sauce-labs-bike-light")
	WebElement deSelectAddToCart;
	
	@FindBy(className="shopping_cart_link")
	WebElement shoppingCartButton;
	
	@FindBy(id="remove-sauce-labs-onesie")
	WebElement removeButtonInCart;
	
	@FindBy(id="checkout")
	WebElement checkoutButton;
	
	@FindBy(id="add-to-cart-sauce-labs-onesie")
	WebElement scrolldown;
	
	Keywords page = new Keywords();

	
	 @Test(priority = 1)
		public void TC014_sortDescendingOrder() throws InterruptedException
		{
	    	sortProduct.click();
	    	Thread.sleep(2000);
	    	//page.selectOptionByVisibleText("Name (Z to A)");
	    	//test = extent.createTest("TC014_Sort Descending Order");
			driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();	
			Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
			
	    	list.selectByVisibleText("Name (Z to A)");

		}
	    
	    @Test(priority = 2)
		public void TC015_sortLowToHigh()
		{
	    	sortProduct.click();
			//page.selectOptionByVisibleText("Price (low to high)");

	 		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
			list.selectByVisibleText("Price (low to high)");

		}
	    
	    @Test(priority = 3)
		public void TC016_sortHighToLow()
		{
	    	sortProduct.click();
			//page.selectOptionByVisibleText("Price (high to low)");
	  		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
			list.selectByVisibleText("Price (high to low)");

		}
	    
	    @Test(priority = 4)
		public void TC013_sortAscendingOrder()
		{
	    	sortProduct.click();
			//page.selectOptionByVisibleText("Name (A to Z)");
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
  	    scrolldown.click();
  	  //  driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
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
	 
  
	public void tearDown() {
		driver.close();
	}
	
	
}


