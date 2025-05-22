Feature: Performance Glitch Login

  Scenario: Login with performance glitch user
    Given I open the login page
    When I enter username "performance_glitch_user" and password "secret_sauce"
    Then I should see the inventory page
