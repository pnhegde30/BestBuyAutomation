package page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) 
	{
		this.driver = driver; 
	}
	
	//Element Library 
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Go to Cart')]")
	WebElement goToCart1;
	
	@FindBy(how = How.XPATH, using = "//button[@class='c-button-link cart-item__remove' and @title='Remove']")
	WebElement removeCart1;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'MacBook Pro 13.3\"Laptop - Apple M2 chip - 8GB Memory - 256 SSD (Latest Model) - Space Gray')]")
	WebElement goToTotalPrice1; 
	
	//Possible alternative xpaths 
		//a[@class='c-button c-button-secondary c-button-sm c-button-block ']
		//div[@id='cartApp']/div[2]/div[1]/div/div[4]/div[1]/div/div/div
	
	//Methods to interact with the WebElements
	
	public void clickGoToCart() {
		//A popup comes up after you click on Go to Cart 
		//Just need to click anywhere on the page to click out of it 
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		explicitWait("//a[contains(text(), 'Go to Cart')]");
	}
	
	public void findTotalPrice() {
		//Find the total price in the cart 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		explicitWait("//a[contains(text(), 'MacBook Pro 13.3\\\"Laptop - Apple M2 chip - 8GB Memory - 256 SSD (Latest Model) - Space Gray')]");
		Actions click = new Actions(driver); 
		click.click(goToTotalPrice1).perform();
	}
	
	public void removeFromCart() {
		//Removes the MacBook from the cart 
		findTotalPrice();
		scrollFunction(removeCart1);
		
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			System.out.println(e);
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		removeCart1.click();
	}

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
	
	private void scrollFunction(WebElement scrollTo) {
		//Scrollss to desired WebElement 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", scrollTo);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}


}

