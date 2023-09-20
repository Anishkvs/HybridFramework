package com.launch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LaunchTwo {
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;



	@BeforeTest
	public void setReport() {
		String path = System.getProperty("user.dir")+"\\report\\index.html"; 

		htmlReporter = new ExtentSparkReporter(path);

		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Reports - Sauce Demo");
		htmlReporter.config().setReportName("Sauce Demo Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("QA", "Anish");
		extent.setSystemInfo("Company", "Aspire");
		extent.setSystemInfo("Build No", "v1.7");

	}
	
	@Test
	public void LaunchBrowser() {
		test = extent.createTest("Login Test");
		System.setProperty("webdriver.gecko.driver","D:\\driver\\firefox\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.co.in/");
		driver.quit();
	}

	
	@AfterTest
	public void endReport() {
		
		extent.flush();
	}
	

}
