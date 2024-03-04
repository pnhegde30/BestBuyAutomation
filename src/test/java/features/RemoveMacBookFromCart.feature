Feature: Search/Add/Delete MacBook from BestBuy.com

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