package com.listeners;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
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
		extent.setSystemInfo("Build No", "v1.9");
		
		return extent;

	}
	
	
	@AfterTest
	public void endReport() {
		
		extent.flush();
	}
	
	@Test
      public void doLogin() {

    	  test =extent.createTest("Login");
    	  
	}
	@Test
      public void doReg() {

    	  test =extent.createTest("Reg");
    	  Assert.fail("Fail reg");
	}
	 @Test
      public void skip() {

    	  test =extent.createTest("Skip");
    	  throw new SkipException("test skip");
	}
	
     @AfterMethod
	public void tearDown(ITestResult result)  {
		
    	 if(result.getStatus() == ITestResult.FAILURE) {
    		 
    		 String methodName = result.getMethod().getMethodName();
    		 
    		 String logText = "<b>" + "Test Case: - "+methodName.toUpperCase()+ "  Failed"+"</b>";
    		 
    		 Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED); 
    		 test.fail(m);
    		 
    	 }else if (result.getStatus() == ITestResult.SKIP) {
    		 
    		 String methodName = result.getMethod().getMethodName();
    		 
    		 String logText = "<b>" + "Test Case: - "+methodName.toUpperCase()+ "  SKIPPED"+"</b>";
    		 
    		 Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW); 
    		 test.skip(m);
    
    		 
    	 }else if (result.getStatus() == ITestResult.SUCCESS) {
    		 
    		 String methodName = result.getMethod().getMethodName();
    		 
    		 String logText = "<b>" + "Test Case: - "+methodName.toUpperCase()+ "  PASSES"+"</b>";
    		 
    		 Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN); 
    		 test.pass(m);
    				 
    	 }
    	 
	}
	
	
}
