Feature: Delete User API Test

  Scenario: Delete user successfully with valid username
    Given I set the base API URL
    When I send DELETE request to "/user/abdel"
    Then The response status code for delete user should be 200
    And The response body should contain success message