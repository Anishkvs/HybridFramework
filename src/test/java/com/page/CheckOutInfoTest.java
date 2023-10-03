package com.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.testbase.TestBase;

public class CheckOutInfoTest extends TestBase {
	
	WebDriver driver;
	
	public CheckOutInfoTest(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
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
	 public void TC022_verifyContinueButtonWithoutFirstName() throws InterruptedException {
  
	   continueButtonInInfoPage.click();
	   Thread.sleep(2000);
		 
		}
  
  @Test(priority = 2)
	 public void TC023_verifyContinueButtonWithoutLastName(String firstInfoName, String userPostalCode) throws InterruptedException {
	  clearInfo();
	  firstName.sendKeys(firstInfoName);
	  postalCode.sendKeys(userPostalCode);
	  continueButtonInInfoPage.click();
	  Thread.sleep(2000);
		
     }

  @Test(priority = 3)
	 public void TC024_verifyContinueButtonWithoutPostalCode(String firstInfoName, String lastInfoName) throws InterruptedException {
	  clearInfo();
  	
	  firstName.sendKeys(firstInfoName);
	  lastName.sendKeys(lastInfoName);
	  continueButtonInInfoPage.click();
  	  Thread.sleep(1000); 
  	 
		}
		
  @Test(priority = 4)
	 public void TC025_verifyContinueButtonWithAllDetails(String firstInfoName, String lastInfoName, String userPostalCode) throws InterruptedException {
//CheckOut Information
  	  Thread.sleep(2000); 

		clearInfo();
	  	  Thread.sleep(2000); 

		firstName.sendKeys(firstInfoName);
		lastName.sendKeys(lastInfoName);
		postalCode.sendKeys(userPostalCode);
		continueButtonInInfoPage.click();
	}
	 
		private void clearInfo() 
		{
			firstName.clear();
			lastName.clear();
			postalCode.clear();
		
		}   

	     @Test(priority = 5)
	 public void TC026_verifyFinishButtonInCheckoutPage() throws InterruptedException {
	 	//test = extent.createTest("TC026 Verify Finish Button");
	    	 Thread.sleep(2000);
	    	 JavascriptExecutor jss = (JavascriptExecutor) driver;
	    	 jss.executeScript("window.scrollBy(0,-450)", "");   
	    	 System.out.println("Scroll down one");
	    	 jss.executeScript("window.scrollBy(0,-450)", "");    
	    	 System.out.println("Scroll down two");
			 Thread.sleep(2000);
			 finishButtonInCheckoutPage.click();

		}

	
	

}


