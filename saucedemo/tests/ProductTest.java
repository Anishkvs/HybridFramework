package com.saucedemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import com.testbase.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductTest extends TestBase {
	
	@BeforeClass
	public void loginApp()  {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login application");
	}
	
 @Test(priority = 5)
    public void TC008_addToCart() throws InterruptedException {
		//test = extent.createTest("TC008_Choose the product");
 
    	System.out.println("Choose the product");  	
    	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    	driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    	driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    	driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
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
  		driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
  		Thread.sleep(1000);
    
    }
    
    @Test(priority = 8)
    public void TC017_verifyShoppingCartButton() throws InterruptedException
    {
    	//test = extent.createTest("TC017_Verify_Shopping_Cart_Button");
  		driver.findElement(By.className("shopping_cart_link")).click();
    	
    }
	
    @Test(priority = 4)
	public void TC013_sortAscendingOrder()
	{
    	//test = extent.createTest("TC013_Sort_Ascending_Order");
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Name (A to Z)");

	}
	
    @Test(priority = 1)
	public void TC014_sortDescendingOrder()
	{
    	//test = extent.createTest("TC014_Sort Descending Order");
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Name (Z to A)");

	}
    
    @Test(priority = 2)
	public void TC015_sortLowToHigh()
	{
    	//test = extent.createTest("TC015_Sort_Low_To_High");
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Price (low to high)");

	}
    
    @Test(priority = 3)
	public void TC016_sortHighToLow()
	{
    	//test = extent.createTest("TC016_Sort_High_To_Low");
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Price (high to low)");

	}
	
 
	@Test(priority = 14)
	 public void TC025_verifyContinueButtonWithAllDetails() throws InterruptedException {
 //CheckOut Information
		Thread.sleep(1000);
		clear();
		//test = extent.createTest("TC025_Verify_Continue_Button");
	    driver.findElement(By.id("first-name")).sendKeys("FirstName");
	    driver.findElement(By.id("last-name")).sendKeys("LastName");
	    driver.findElement(By.id("postal-code")).sendKeys("689531");
	    driver.findElement(By.id("continue")).click();
	    Thread.sleep(1000);
		    
		}
	 
    @Test(priority = 11)
	 public void TC022_verifyContinueButtonWithoutFirstName() throws InterruptedException {
    	//test = extent.createTest("TC022_Verify WithoutFirst Name"); 
    	driver.findElement(By.id("continue")).click();
		 Thread.sleep(2000);
		 
		}
    
    @Test(priority = 12)
	 public void TC023_verifyContinueButtonWithoutLastName() throws InterruptedException {
    	clear(); 
    	//test = extent.createTest("TC023_Verify Without Last Name");
    	driver.findElement(By.id("first-name")).sendKeys("FirstName");
         driver.findElement(By.id("postal-code")).sendKeys("689531");
         driver.findElement(By.id("continue")).click();
         Thread.sleep(2000);
		}

    @Test(priority = 13)
	 public void TC024_verifyContinueButtonWithoutPostalCode() throws InterruptedException {
    	clear();
    	//test = extent.createTest("TC022_Verify Without Postal");
    	driver.findElement(By.id("first-name")).sendKeys("FirstName");
		 driver.findElement(By.id("last-name")).sendKeys("LastName");
		 driver.findElement(By.id("continue")).click();
		 Thread.sleep(2000);   
		}
		
	
	@Test(priority = 9)
	 public void TC018_verifyRemoveButton() throws InterruptedException {
		
		//Scroll down Cart page and remove last product
			//test = extent.createTest("TC018_Verify Remove Button");    
			Thread.sleep(1000);
		    driver.findElement(By.id("remove-sauce-labs-onesie")).click();
		    Thread.sleep(2000);
		}
	 
    @Test(priority = 10)
     public void TC019_verifyCheckoutButton() {
    	//Click on CheckOut	
    	 //test = extent.createTest("TC019_Verify Checkout");
    	 driver.findElement(By.id("checkout")).click();
	}
		
    @Test(priority = 15)
    public void TC026_verifyFinishButtonInCheckoutPage() throws InterruptedException {
    	//test = extent.createTest("TC026 Verify Finish Button");
    	Thread.sleep(2000);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-450)", "");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='finish']")).click();

	}
		
		private void clear() {
				driver.findElement(By.id("first-name")).clear();
			    driver.findElement(By.id("last-name")).clear();
			    driver.findElement(By.id("postal-code")).clear();

			}   
    
	
	
	
	

	

}
