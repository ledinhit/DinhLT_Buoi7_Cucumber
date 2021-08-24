Feature: Create Order

  Scenario: Create Order success
    Given Set up variable for Order
    And Login
    When Select Order in Lest menu
    And Select create Order
    And Select customer
    And Create new product
    And Click button Save Order
    Then verify product name and sku in new order
    And Close Browser - Order