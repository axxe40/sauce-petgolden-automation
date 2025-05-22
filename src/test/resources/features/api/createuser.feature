Feature: Create User API Test

  Scenario: Create user successfully with valid data
    Given I set the base API URL
    When I send POST request to "/user" with username "abdel", email "abdel@mail.com", and password "12345"
    Then The response status code for create user should be 200
    And The response body for create user should contain user ID  