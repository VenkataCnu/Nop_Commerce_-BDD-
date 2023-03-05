Feature: Login 

  Scenario Outline: Title of your scenario outline
   Given user launch the browser
    When user opens the url "http://admin-demo.nopcommerce.com"
    And user enters the username as <user> and password as <pwd>
    And user click on login 
    Then page title should be "Dashboard / nopCommerce administration"
    And user close the browser

    Examples: 
      | user  | pwd | status  |
      | user1@gmail.com |  abcdef | Fail |
      | user2@gmail.com | ghijkl | Fail    |
      | admin@yourstore.com | admin | Success   |
      
