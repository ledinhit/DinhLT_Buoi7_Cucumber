Feature: Create Product

  Scenario: Create product success
    Given Open the Chrome and launch the application (Product)
    And Set the variables for the Create Product function
    And Login to site (product)
    When Select Product in left menu
    And Select List Product
    And Click button create product
    And Enter product information (name, sku, barcode, weight, retailPrice, wholesalePrice, cost, inventory, unit)
    And Click button Save Product
    Then Create product successfully