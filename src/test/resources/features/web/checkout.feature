Feature: Checkout

  Scenario: Successful checkout process
    Given I am logged in and have an item in the cart
    When I proceed to checkout and fill in my information
    And I finish the checkout
    Then I should see the confirmation page
