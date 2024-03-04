package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	
	//public TestBase(WebDriver driver){
	// }
	
	public static WebDriver initDriver() { 
		//The initial setup for WebDriver. Using both the WebDriverManager and the ChromeDirver 
		//Need to comment / uncomment out either of the top two lines
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void tearDown() throws InterruptedException { 
		//Closes the Driver after the scenario is tested 
		Thread.sleep(3000);
		driver.close(); 
		driver.quit();
	}

}
