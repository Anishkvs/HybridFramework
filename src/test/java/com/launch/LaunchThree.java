package com.launch;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.base.TestBase3;

public class LaunchThree extends TestBase{
	
	@Test
	public void LaunchBrowser() {
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		}

	
	//@AfterTest
	public void endReport() {
		
		//extent.flush();
	}
	

}
