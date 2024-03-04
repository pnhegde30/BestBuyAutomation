Feature: Search/Add/Delete MacBook from BestBuy.com

@ADD_MACBOOK
Scenario Outline: Add MacBook to Cart
	Given I am on the Best Buy home page
	And I close the add modal and search for the <searchTerm> 
	When I click the Add to cart button next to laptop 
	Then I should see a modal window with the cart subtotal 
	
	Examples: 
	| searchTerm  | 
	| MacBook Pro | 