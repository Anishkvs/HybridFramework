package com.saucedemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProductTest extends TestBase {
	
	
	@BeforeClass
	public void loginApp() throws InterruptedException {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Login application");
	}
	
 @Test 
    public void chooseProduct() throws InterruptedException {
	 ProductTest ob = new ProductTest();
	 ob.loginApp();
	 
    	System.out.println("Choose the product");
    	//Choose product
    	Thread.sleep(5000);
    	driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    	driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    	driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    	driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
			
	}
    
    @Test
    public void scrollDownProduct() throws InterruptedException
    {
    	//scroll down Product page
  		System.out.println("Scroll Down");;
  		JavascriptExecutor jss = (JavascriptExecutor) driver;
  	    jss.executeScript("window.scrollBy(0,-450)", "");
  	    driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		Thread.sleep(2000);
  	
    }
	
    @Test(priority=4)
    public void scrollUpProduct() throws InterruptedException
    {
    	System.out.println("Scroll Up");
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
  		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
  		
  //Remove 2nd product
  		driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
  		Thread.sleep(1000);
    
    }
    
    @Test
    public void chooseCart() throws InterruptedException
    {
  		driver.findElement(By.className("shopping_cart_link")).click();
    	
    }
	
    @Test
	public void sortAscending()
	{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Name (A to Z)");

	}
	
    @Test
	public void sortDescending()
	{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Name (Z to A)");

	}
    
    @Test
	public void sortLowToHigh()
	{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Price (low to high)");

	}
    
    @Test
	public void sortHighToLow()
	{
		driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
		Select list = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		list.selectByVisibleText("Price (high to low)");

	}
	
    @Test
	public void filterVerify() {
		sortDescending();
		sortHighToLow();
		sortLowToHigh();
		sortAscending();

	}
    
	
	@Test
	 public void checkOutInformation() throws InterruptedException {
 //CheckOut Information
	    driver.findElement(By.id("first-name")).sendKeys("FirstName");
	    driver.findElement(By.id("last-name")).sendKeys("LastName");
	    driver.findElement(By.id("postal-code")).sendKeys("689531");
	    driver.findElement(By.id("continue")).click();
	    Thread.sleep(2000);
		    
		}
	 
    @Test
	 public void checkOutWithoutInformation() throws InterruptedException {
		 driver.findElement(By.id("continue")).click();
		 Thread.sleep(2000);
		 
		}
    
    @Test
	 public void checkOutWithoutLastName() throws InterruptedException {
		 driver.findElement(By.id("first-name")).sendKeys("FirstName");
         driver.findElement(By.id("postal-code")).sendKeys("689531");
         driver.findElement(By.id("continue")).click();
         Thread.sleep(2000);
		}

    @Test
	 public void checkOutWithoutPostalCode() throws InterruptedException {
		 driver.findElement(By.id("first-name")).sendKeys("FirstName");
		 driver.findElement(By.id("last-name")).sendKeys("LastName");
		 driver.findElement(By.id("continue")).click();
		 Thread.sleep(2000);   
		}
		
    @Test
	public void checkOutVerify() throws InterruptedException {
		
		checkOutWithoutInformation();
		driver.navigate().refresh();
		checkOutWithoutLastName();
		driver.navigate().refresh();
		checkOutWithoutPostalCode();
		driver.navigate().refresh();
		checkOutInformation();

		}
	
	@Test
	 public void removeProductInCart() throws InterruptedException {
		
		//Scroll down Cart page and remove last product
		    Thread.sleep(1000);
		    driver.findElement(By.id("remove-sauce-labs-onesie")).click();
		    Thread.sleep(2000);
		}
	 
    @Test
     public void clickOnCheckOut() {
    	//Click on CheckOut	
    	 driver.findElement(By.id("checkout")).click();
	}
		
		
			   
    
	
	
	
	

	

}
