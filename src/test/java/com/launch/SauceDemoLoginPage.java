package com.launch;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.TestBase;

public class SauceDemoLoginPage extends TestBase {
	WebDriver driver;
	@Test
	 public void launchApplication() throws IOException {
		 DataDrivenExcel d = new DataDrivenExcel();
			ArrayList data = d.getData("Add profile");
			
			System.out.println(data.get(0));
			System.out.println(data.get(1));	
			System.out.println(data.get(2));	
			driver.get("https://www.saucedemo.com/");
			
			
			driver.findElement(By.id("user-name")).sendKeys(data.get(1).toString());
			driver.findElement(By.id("password")).sendKeys(data.get(2).toString());
			driver.findElement(By.id("login-button")).click();		
			System.out.println("Login application");
			
		}
	 
    
	
	
}
