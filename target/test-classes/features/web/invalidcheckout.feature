Feature: Invalid Checkout 

  Scenario: User attempts to checkout without entering first name
    Given I open the login page
    When I enter valid username and password
    And I add a product to the cart
    And I proceed to checkout
    And I leave the first name field empty
    And I fill in the last name with "Doe" and postal code with "12345"
    And I click continue on the checkout page
    Then I should see an error message "Error: First Name is required"
