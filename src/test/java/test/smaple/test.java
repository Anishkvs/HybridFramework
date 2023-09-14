package test.smaple;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","D:\\driver\\firefox\\geckodriver.exe");
		
		//WebDriverManager.firefoxdriver().setup();
		
		//WebDriverManager.chromedriver().setup();
		 // WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.co.in/");
		//Thread.sleep(5000);
		driver.navigate().refresh();
		//Thread.sleep(5000);
		driver.quit();

	}

	

}
