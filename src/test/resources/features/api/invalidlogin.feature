Feature: Login with incorrect password

Scenario: Fail to login with incorrect password
  Given I set the base API URL
  When I send GET request to "/user/login" with username "abdel" and password "12345"
  Then The response status code for login user should be 200
  And The response body should contain error message
