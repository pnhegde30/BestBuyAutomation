Feature: Search/Add/Delete MacBook from BestBuy.com 

@SEARCH_MACBOOK 
Scenario Outline: Search for MacBook 
	Given I am on the Best Buy home page 
	When I close the add modal and search for <searchTerm> 
	Then One of the laptops listed should be 13.3 8GB Memory and 256GB SSD 
	
Examples: 
	| searchTerm  | 
	| MacBook Pro |