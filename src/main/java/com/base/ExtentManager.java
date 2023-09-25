package com.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeClass
	public ExtentReports setReport() {
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
		extent.setSystemInfo("Build No", "v1.8");
		
		return extent;

	}
	
	
	@AfterClass
	public void endReport() {
		
		extent.flush();
	}
	


	
	
	
}
