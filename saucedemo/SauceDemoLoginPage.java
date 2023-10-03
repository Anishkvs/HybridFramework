package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testbase.TestBase;
import com.testbase.TestBase2;

public class SauceDemoLoginPage extends TestBase2 {
	WebDriver driver;
	
	public SauceDemoLoginPage(WebDriver driver)
	{
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 public void launchApplication() {
			driver.get("https://www.saucedemo.com/");
			System.out.println("Launch application");
		}
	 
    public void login() {
    	driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();		
		System.out.println("Login application");
    }
    
    public void wrongCredentialLogin() {
    	driver.findElement(By.id("user-name")).sendKeys("standard_user1");
		driver.findElement(By.id("password")).sendKeys("secret_sauce1");
		driver.findElement(By.id("login-button")).click();		
		System.out.println("Login application");
		driver.navigate().refresh();
		
    }
    
    public void wrongUserLogin() {
    	driver.findElement(By.id("user-name")).sendKeys("Wrong-user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();		
		System.out.println("Login application");
		driver.navigate().refresh();

    }
    public void wrongPassLogin() {
    	driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("Wrong-pass");
		driver.findElement(By.id("login-button")).click();		
		System.out.println("Login application");
		driver.navigate().refresh();

    }
    
    public void withoutCredentialLogin() {
    	driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("Wrong-pass");
		driver.findElement(By.id("login-button")).click();		
		System.out.println("Login application");
		driver.navigate().refresh();

    }
    
    public void navigateBack() {
    	driver.navigate().back();
    }
    
    public void navigateForward() {
    	driver.navigate().forward();
    }
    
    public void verifyLogin() {
    	wrongCredentialLogin();
    	wrongUserLogin();
    	wrongPassLogin();
    	withoutCredentialLogin();

	}
	
    public void verifyBrowserBackAndFowardPossibilites() {
    	navigateBack();
    	navigateForward();
    	
	}
	
public void verifyHomePage() {
		
		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("Launch Product page");
//		loginPage.VerifyHomePage();
			/*
			 * Assert issue: Exception in thread "main" java.lang.UnsupportedClassVersionError:
			 *  org/testng/Assert has been compiled by a more recent version of the Java Runtime 
			 *  (class file version 55.0), this version of the Java Runtime only recognizes 
			 *  class file versions up to 52.0
			 */
	}
    
	
	
}
