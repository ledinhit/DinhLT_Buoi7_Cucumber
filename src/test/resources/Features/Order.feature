Feature: Create Order


  Scenario: Create Order success
    Given Open the Chrome and launch the application (Order)
    And Set the variables for the Create Order function
    And Login
    When Select Order in the left menu
    And Select create Order and delivery
    And Select customer
    And Create new product
    And Click button Save Order
    Then Create order successfully