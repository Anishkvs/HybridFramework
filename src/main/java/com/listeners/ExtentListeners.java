package com.listeners;

import java.util.Date;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListeners implements ITestListener, ISuiteListener {

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	
	//private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		
		ExtentTest test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
        testReport.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("Test Success");

	}

	public void onTestFailure(ITestResult result) {

		if(result.getStatus() == ITestResult.FAILURE) {
   		 
   		 String methodName = result.getMethod().getMethodName(); 
   		 String logText = "<b>" + "Test Case: - "+methodName.toUpperCase()+ "  Failed"+"</b>";	 
   		 Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED); 
   		 test.fail(m);
		System.out.println("Test Failed");
	}
	}

	public void onTestSkipped(ITestResult result) {

		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);
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
