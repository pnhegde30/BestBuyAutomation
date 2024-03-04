package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import page.CartPage;
import page.SearchPage;
import util.TestBase;


public class StartingPageStepDefinition {
	
	//Starting page comment 
	
	WebDriver driver;
	TestBase testBase; 
	SearchPage searchPage;
	CartPage cartPage;
	
	//Run this method before the other method. Instantiates the WebDriver 
	@Before
	public void beforeRun() {
		driver = TestBase.initDriver();
		searchPage = PageFactory.initElements(driver, SearchPage.class);
		cartPage = PageFactory.initElements(driver, CartPage.class);
	}
	
	//Basic Given used to retrieve link 
	@Given("^I am on the Best Buy home page$")
	public void user_is_on_best_buy_home_page() throws Throwable { 
		driver.get("https://wwww.bestbuy.com/");
	}
	
	// \"([^\"]*)]\"
	//Search for the MacBook in the searchbar and click on enter 
	@And("^I close the add modal and search for (.*)$")
	public void add_modal_and_search_for(String searchTerm) throws Throwable { 
		searchPage.useSearchBar(searchTerm);
		searchPage.enterSearch();
	}
	
	//Adds the MacBook to the cart 
	@When("^I click the Add to cart button next to laptop$")
	public void click_button_next_to_laptop() throws Throwable { 
		searchPage.addToCartMacBook1();
	}
	
	//Goes to the cart 
	@When("^I click on the Go to cart button$")
	public void click_additional_button() throws Throwable { 
		cartPage.clickGoToCart();
	}
	
	//Verifies the laptop is present 
	@Then("^One of the laptops listed should be 13.3 8GB Memory and 256GB SSD$")
	public void confirm_laptop_specs() throws Throwable { 
		String actualMacbook = "MacBook Pro 13.3"+ '"' + "Laptop - Apple M2 chip - 8GB Memory - 256GB SSD (Latest Model) - Space Gray";
		WebElement resultMacbook = driver.findElement(By.xpath("//a[contains(text(),'MacBook Pro 13.3\" Laptop - Apple M2 chip - 8GB Mem')]"));
		Assert.assertEquals(resultMacbook.getText(), actualMacbook,
				"Titles did not match. Actual: " + resultMacbook.getText() + "Expected: " + actualMacbook);
	}
	
	//Verifies the correct laptop is selected 
	@Then("^I should see a modal window with the cart subtotal$")
	public void seel_modal_window_with_cart_subtotal() throws Throwable { 
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sub-total v-fw-medium']")));
		
		try { 
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		String actualCartTotal = "$1,299.00";
		WebElement cartSubTotal = driver.findElement(By.xpath("//div[@class='sub-total v-fw-medium']"));
		Assert.assertEquals(actualCartTotal, cartSubTotal.getText(), 
				"Subcart total does not match Actual: " + actualCartTotal + "Expected" + cartSubTotal.getText());
	}
	
	//Verifies that the laptop is in the cart
	@Then("^I should see the laptop and the order summary with Total price$")
	public void see_laptop_and_order_summary_with_total_price() throws Throwable { 
		cartPage.findTotalPrice();
		String expectedCartEntry = "MacBook Pro 13.3\" Laptop - Apple M2 chip - 8GB Memory - 256GB SSD (Latest Model) - Space Gray";
		WebElement actualCartEntry = driver.findElement(By.xpath("//a[contains(text(),'MacBook Pro 13.3\" Laptop - Apple M2 chip - 8GB Memory - 256GB SSD (Latest Model) - Space Gray')]"));
		Assert.assertEquals(expectedCartEntry, actualCartEntry.getText(), "Titles do not match");
	}
	
	//Click on the remove button to remove laptop from the cart
	@When("^I click the Remove link under the item number drop down$")
	public void click_link_under_item_number_drop_down() throws Throwable { 
		cartPage.removeFromCart();
	}
	
	@Then("^My anonymous cart should be empty$")
	public void anonymous_cart_should_be_empty() throws Throwable { 
		String expectedEmptyCart = "Your list is currently empty";
		
		try { 
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		WebElement actualEmptyCart = driver.findElement(By.xpath("//h3[contains(text(),'Your list is currently empty')]"));
		Assert.assertEquals(expectedEmptyCart, actualEmptyCart.getText(), "Cart does not match");
	}
	
	//Runs after each scenario. Closes the WebDriver 
	@After 
	public void afterRun() throws InterruptedException { 
		TestBase.tearDown();
	}
	

}
