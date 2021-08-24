Feature: Create Product

  Scenario: Create product success
    Given Set up variable for product
    And Login to site (product)
    When Select Product in Lest menu
    And Select List Product
    And Click button create product
    And Enter product information
    And Click button Save Product
    Then verify success message create product
    And Close Browser (product)