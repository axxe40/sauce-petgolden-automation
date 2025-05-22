Feature: Invalid Login

  Scenario: Login fails with invalid password
    Given I open the login page
    When I enter username "standard_user" and password "wrong_password"
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"
