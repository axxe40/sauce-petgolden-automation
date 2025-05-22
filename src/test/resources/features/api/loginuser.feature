Feature: Login User API Test

  Scenario: Login user successfully with valid username and password
    Given I set the base API URL
    When I send GET request to "/user/login" with username "abdel" and password "12345"
    Then The response status code for login user should be 200
    And The response body should contain success message
