package test.smaple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test2 {
	
	public static void main(String[] args) {
		
		
		   WebDriver driver = new ChromeDriver();
      		driver.get("https://www.google.co.in/");
      		//Thread.sleep(5000);
      		driver.navigate().refresh();
	}

	

}
