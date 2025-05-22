Feature: Delete non-existing user

Scenario: Fail to delete non-existing user
  Given I set the base API URL
  When I send DELETE request to "/user/nonexistentuser"
  Then The response status code for delete user should not be 200
  And The response body should be empty
