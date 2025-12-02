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

  Scenario: User can navigate to home page from cart
    Given Logged User in cart page
    When  user click on specif product
    Then he will be redirect successfully to this product page

  Scenario: Choose certain product option to add to cart
    Given  Logged User in home page
    When  user choose specific product variant
    Then this variant will be added successfully to cart

  Scenario: User can see total price in cart
    Given  Logged User in home page
    When  user navigate to shopping cart
    Then  user can see totals displau successfully

  Scenario: User can navigate to the checkout page successfully from the cart page
    Given Logged User in cart page
    When the user click on the checkout button
    Then the user will be redirected successfully to the checkout page

  Scenario: User Can't update quanity to out of stock value
    Given Logged User in cart page
    When  modify the product quantity to value exceeding max stock value
    Then product quantity can not be updated  successfully

  Scenario: User can remove item from cart
    Given Logged User in cart page
    When user click remove specific product
    Then product will be deleted successfully

  Scenario: User can add shipped Product to cart
    Given Logged User in home page
    When user add a product requires shipping to cart
    Then product added successfully


  Scenario: User is on checkout page
    Given Logged User in checkout page
    When user checks page
    Then user can find page title successfully

  Scenario: User can see existing address options
    Given Logged User in checkout page
    When user checks page
    Then user can find existing address successfully


  Scenario: User can choose existing address options
    Given Logged User in checkout page
    When user checks page
    Then user can choose existing address successfully

  Scenario: User will be notified if enter a new address missing first name in checkout
    Given Logged User in checkout page
    When entering new address details, missing first name
    Then the user will be notified by an error message missing first name

  Scenario: User will be notified if enter a new address missing address 1 in checkout
    Given Logged User in checkout page
    When entering new address details, missing address 1
    Then the user will be notified by an error message missing address 1

  Scenario: User will be notified if enter a new address missing city in checkout
    Given Logged User in checkout page
    When entering new address details, missing city
    Then the user will be notified by an error message missing city

  Scenario: User will be notified if enter a new address missing post code in checkout
    Given Logged User in checkout page
    When entering new address details, missing post code
    Then the user will be notified by an error message missing post code


  Scenario: User will be notified if enter a new address missing city in checkout
    Given Logged User in checkout page
    When entering new address details, missing region
    Then the user will be notified by an error message missing region

  Scenario: User will be notified if enter a new address missing last name in checkout
    Given Logged User in checkout page
    When entering new address details, missing last name
    Then the user will be notified by an error message last name

  Scenario: User can new shipping address
    Given Logged User in checkout page
    When entering valid new address details
    Then address will be added successfully

  Scenario: User can new choose shipping method
    Given Logged User in checkout page
    When user choose shipping method
    Then success message will be displayed

  Scenario: User can new choose payment method
    Given Logged User in checkout page
    When user choose payment method
    Then payment success message will be displayed

  Scenario: User can place order
    Given Logged User in checkout page
    When user place order
    Then order placed success message will be displayed


