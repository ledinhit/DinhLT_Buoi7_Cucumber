Feature: Create customer

  Scenario: Create customer success
    Given Open the Chrome and launch the application (Customer)
    And Set the variables for the Create Customer function
    And Login to site
    When Select Customer in left menu
    And Select List customers
    And Click button create customer
    And Enter customer information (name,code, email,phone, address, district, ward, payment type)
    And Click button Save Customer
    Then Create customer successfully