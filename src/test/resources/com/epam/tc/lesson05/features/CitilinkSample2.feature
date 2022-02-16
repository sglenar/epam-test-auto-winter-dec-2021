Feature: Add products to compare functionality 12

  Scenario: Add products to compare
    Given I open Citilink Index page
    And I open catalog category 'Смартфоны' in 'Смартфоны и гаджеты' catalog
    When I add products with indexes '1, 2, 3' to compare list on Catalog page
    Then all added products should be displayed on Compare page


  Scenario: Add products to compare with starts instead if keywords
    * I open Citilink Index page
    * I open catalog category 'Смартфоны' in 'Смартфоны и гаджеты' catalog
    * I add products with indexes '1, 2, 3' to compare list on Catalog page
    * all added products should be displayed on Compare page
