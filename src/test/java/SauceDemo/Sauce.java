package SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class Sauce {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver","D:\\driver\\firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		
		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
		System.out.println("Launch Product page");
		
//Choose product
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();

		Thread.sleep(1000);	
		
//scroll down Product page
		System.out.println("Scroll Down");;
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,-450)", "");
	
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		Thread.sleep(2000);
		System.out.println("Scroll Up");;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		
//Remove 2nd product
		driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("shopping_cart_link")).click();

//Scroll down Cart page and remove last product
	    js.executeScript("window.scrollBy(0,-450)", "");
	    Thread.sleep(1000);
	    driver.findElement(By.id("remove-sauce-labs-onesie")).click();
	    Thread.sleep(2000);
//Click on CheckOut
	    driver.findElement(By.id("checkout")).click();
//CheckOut Information
	    driver.findElement(By.id("first-name")).sendKeys("FirstName");
	    driver.findElement(By.id("last-name")).sendKeys("LastName");
	    driver.findElement(By.id("postal-code")).sendKeys("689531");
	    Thread.sleep(2000);
	    
//Click on Continue
	    driver.findElement(By.id("continue")).click();
	    
//CheckOut Overview
	    js.executeScript("window.scrollBy(0,-450)", "");
	    driver.findElement(By.id("finish")).click();
	    
//Verify Thankyou Page   
	    
	    String BackHomeButton= driver.findElement(By.xpath("//button[contains(@class,'btn btn_primary')]")).getText();
	    System.out.println(BackHomeButton+ " is displayed");
	    
	}

	

}
