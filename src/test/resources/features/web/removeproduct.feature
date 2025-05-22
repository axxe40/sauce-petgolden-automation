Feature: Remove product from cart

  Scenario: User removes the product from the cart
    Given I open the login page
    When I enter valid username and password
    And I add the first product to the cart
    And I remove the product from the cart
    Then I should see the cart icon showing 0 item
