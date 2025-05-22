Feature: Add product to cart

  Scenario: User adds the first product to the cart
    Given I open the login page
    When I enter valid username and password
    And I add the first product to the cart
    Then I should see the cart icon showing 1 item
