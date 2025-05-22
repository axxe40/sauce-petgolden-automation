Feature: Update non-existing user

Scenario: Fail to update non-existing user
  Given I set the base API URL
  When I send PUT request to "/user/ghost" with updated email "ghost@mail.com" and password "12345"
  Then The response status code for update user should be 200
  And The response body should contain error message
