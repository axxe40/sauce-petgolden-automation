Feature: Create user with missing required field

Scenario: Fail to create user without username
  Given I set the base API URL
  When I send POST request to "/user" with username "", email "ell@example.com", and password "12345"
  Then The response status code for create user should be 200
  And The response body should contain error message
