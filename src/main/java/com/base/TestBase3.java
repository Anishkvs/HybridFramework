package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Listeners;
//import com.listeners.CustomListeners;

//@Listeners(CustomListeners.class)

public class TestBase3 {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	
//	@BeforeClass
//	public void setUp() {
//
//		System.setProperty("webdriver.gecko.driver", "D:\\driver\\firefox\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		//driver.get("https://www.saucedemo.com/");
//
	//}
	@BeforeClass
	public void setUpOne() throws IOException {
		
		if(driver==null)
		{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
		}
		
	
	if(config.getProperty("browser").equals("firefox")) {
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	
	} else if(config.getProperty("browser").equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}else if(config.getProperty("browser").equals("edge")) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\msedgedriver.exe");
		driver = new EdgeDriver();
    }
	
	driver.get("https://www.saucedemo.com/");
	//driver.get(config.getProperty("applicationurl"));
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	
	}
	
	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
		driver.quit();
		}
	}
	
	
}
	
