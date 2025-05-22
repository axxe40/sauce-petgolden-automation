Feature: Logout 

  Scenario: User successfully logs out
    Given I am logged in to the application
    When I click the logout button
    Then I should be redirected to the login page
