Feature: Adding a customer

@Sanity_Testing
  Scenario: Adding a customer 
    Given user launche the browser
    When user opens the applications with url "http://admin-demo.nopcommerce.com"
    And user enters the user name as "admin@yourstore.com" and password as "admin"
    And user click on login button
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on customer menu
    And user click on add button
    Then user can view the add customer page as "Add a new customer / nopCommerce administration"
    When user enters the customer details
    And click on save button
    Then User can view confirmation message "The new customer has been added successfully." 
    And close the browser
    

