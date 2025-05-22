Feature: Get User by Username

  Scenario: Successfully retrieve a user by username
    Given I set the base API URL
    When I send GET request to "/user" with username "string"
    Then The response status code should be 200
    And The response body should contain username "string"
