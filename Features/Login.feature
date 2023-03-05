Feature: Login feature

  Scenario: Login with single credential
    Given user launch the browser
    When user opens the url "http://admin-demo.nopcommerce.com"
    And user enters the username as "admin@yourstore.com" and password as "admin" 
    And user click on login 
    Then page title should be "Dashboard / nopCommerce administration"
    And user close the browser

