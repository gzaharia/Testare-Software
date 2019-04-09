@Run
Feature: eCommerce site (Nike), selected products (Red T-Shirts)

  Scenario: Get a list of products by title and price
    Given user is already on the 'nike.com' home page
    When user select and click a category of products to buy
    Then the list of selected products are displayed in the console