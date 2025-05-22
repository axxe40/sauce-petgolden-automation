Feature: Locked out user login

  Scenario: Locked out user cannot login
    Given I open the login page
    When I enter username "locked_out_user" and password "secret_sauce"
    Then I should see an error message "Epic sadface: Sorry, this user has been locked out."
