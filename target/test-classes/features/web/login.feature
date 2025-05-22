Feature: Login

  Scenario: Successful login
    Given I open the login page
    When I enter valid username and password
    Then I should see the inventory page
