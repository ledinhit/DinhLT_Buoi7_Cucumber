Feature: Create customer

  Scenario: Create customer success
    Given Set up
    And Login to site
    When Select Customer in Lest menu
    And Select List customers
    And Click button create customer
    And Enter customer information
    And Click button Save Customer
    Then verify success message
    And Close Browser