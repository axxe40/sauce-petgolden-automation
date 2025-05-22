Feature: Update User API Test

  Scenario: Update user successfully with valid data
    Given I set the base API URL
    When I send PUT request to "/user/abdel" with updated email "updated@example.com" and password "UpdatedPass123!"
    Then The response status code for update user should be 200
    And The response body should contain success message
