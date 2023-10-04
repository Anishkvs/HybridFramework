package com.saucedemo.runner;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import com.listeners.AutomationReports;
import com.saucedemo.base.AutomationBase;

@Listeners(AutomationReports.class)

public class TestRunner extends AutomationBase {

	@BeforeClass
	@Parameters({ "browserName" })
	public void setUp(String browserName) throws IOException {
		startBrowserSession(browserName);

	}

}
