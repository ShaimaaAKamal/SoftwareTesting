Feature: Login Feature

  Scenario: InValid user login using empty username and valid password
    Given User is on login page
    When User enter empty username and valid password
    Then User should not be logged


  Scenario: InValid user login using valid username and empty password
    Given User is on login page
    When User enter valid username and empty password
    Then User should not be logged

  Scenario: InValid user login using empty username and password
    Given User is on login page
    When User doesn't enter  username and password
    Then User should not be logged

  Scenario: InValid user login using invalid username and valid password
    Given User is on login page
    When User enter invalid username and valid password
    Then User should not be logged

  Scenario: InValid user login using valid username and invalid password
    Given User is on login page
    When User enter valid username and invalid password
    Then User should not be logged

  Scenario: InValid user login using invalid username and invalid password
    Given User is on login page
    When User enter invalid username and invalid password
    Then User should not be logged

  Scenario: Valid user login
    Given User is on login page
    When User enters valid username and password
    Then User should be logged in successfully

  Scenario: Registered user add product to cart
    Given Logged User in home page
    When  click add product to  cart btn
    Then product added successfully


  Scenario: Modify added to cart quantity
    Given Logged User in cart page
    When  modify the product quantity
    Then product quantity updated  successfully


  Scenario: User Can't update quanity to out of stock value
    Given Logged User in cart page
    When  modify the product quantity to value exceeding max stock value
    Then product quantity can not be updated  successfully

  Scenario: User can navigate to home page from cart
    Given Logged User in cart page
    When  user click on specif product
    Then he will be redirect successfully to this product page

  Scenario: Choose certain product option to add to cart
    Given  Logged User in home page
    When  user choose specific product variant
    Then this variant will be added successfully to cart