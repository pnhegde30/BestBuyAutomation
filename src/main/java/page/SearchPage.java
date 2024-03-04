package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	WebDriver driver; 
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library 
	@FindBy(how = How.XPATH, using = "//input[@ids='gh-search-input]")
	WebElement search_bar;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']/ancestor::div/div[1]/header/div[1]/div/div[1]/div/form/button[2]")
	WebElement searchBarClick;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'MacBook Pro 13.3\" Laptop - Apple M2 chip - 8GB Mem')]")
	WebElement scrollTo;
	
	@FindBy(how = How.XPATH, using = "//button[@type='button' and @data-sku-id='6509652']")
	WebElement addToCart1;
	
	
	//Methods to interact with the elements 
	
	public void useSearchBar(String text) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		search_bar.sendKeys(text);
	}
	
	public void enterSearch() { 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		searchBarClick.click(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void scrollFunction(WebElement scrollTo) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView()", scrollTo);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void addToCartMacBook1() throws InterruptedException{ 
		scrollFunction(scrollTo);
		addToCart1.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//Unused in this page
	private void explicitWait(String visibleElement) 
	{
		// Created for timing issues
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(visibleElement)));
		
		try { 
			Thread.sleep(2000);
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
