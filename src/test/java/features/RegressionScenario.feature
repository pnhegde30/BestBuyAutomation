@REGRESSION
Feature: Search/Add/Delete MacBook from BestBuy.com 
#Used Scenario Outlines for interchangeability with the seach terms 

@SEARCH_MACBOOK 
Scenario Outline: Search for MacBook 
	Given I am on the Best Buy home page 
	When I close the add modal and search for <searchTerm> 
	Then One of the laptops listed should be 13.3 8GB Memory and 256GB SSD 
	
Examples: 
	| searchTerm  | 
	| MacBook Pro |
	

@ADD_MACBOOK
Scenario Outline: Add MacBook to Cart
	Given I am on the Best Buy home page
	And I close the add modal and search for the <searchTerm> 
	When I click the Add to cart button next to laptop 
	Then I should see a modal window with the cart subtotal 
	
	Examples: 
	| searchTerm  | 
	| MacBook Pro | 
	

@SEE_CART_MACBOOK
Scenario Outline: See Cart with MacBook 
	Given I am on the Best Buy home page 
	And I close the add modal and search for <searchTerm>
	When I click the Add to cart button next to laptop
	And I click on the Go to cart button 
	Then I should see the laptop and the order summary with Total price
	
Examples: 
	 | searchTerm  | 
	 | MacBook Pro |
	 
	 
@REMOVE_MACBOOK
Scenario Outline: Remove MacBook from Cart 
	Given I am on the Best Buy home page 
	And I close the add modal and search for <searchTerm>
	When I click the Add to cart button next to laptop 
	And I click on the Go to cart button 
	When I click the Remove link under the item number drop down 
	Then My anonymous cart should be empty
	
Examples: 
	| searchTerm  | 
	| MacBook Pro |	