package com.listeners;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CustomListeners implements ITestListener, ISuiteListener {

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	
	public void onTestStart(ITestResult result) {
		//extent.createTest("Saucedemo Application");
		
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Success");

	}

	public void onTestFailure(ITestResult result) {

		System.out.println("Test Failed");
	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("Test Skipped");
	}

	public void onStart() {

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
		
		
		//return extent;
	}

	public void onFinish(ITestContext context) {
		//extent.flush();
	}

}
