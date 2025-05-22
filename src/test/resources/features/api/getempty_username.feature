Feature: Get user with empty username

Scenario: Fail to get user with empty username
  Given I set the base API URL
  When I send GET request to "/user/"
  Then The response status code for get user should be 405
  And The response body should contain error message
