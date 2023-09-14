package test.sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * java.lang.IllegalStateException:
		 * The path to the driver executable must be set by the webdriver.chrome.driver system property
		 * Current Selenium v4.6.0
		 */
		
		    WebDriver driver = new ChromeDriver();
      		driver.get("https://www.google.co.in");
      		Thread.sleep(3000);
      		driver.navigate().refresh();
	}

	

}
