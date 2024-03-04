Feature: Search/Add/Delete MacBook from BestBuy.com 

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