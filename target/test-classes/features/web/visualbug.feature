Feature: Visual Bug UI

  Scenario: Login as visual user and check for UI distortion
    Given I open the login page
    When I enter username "visual_user" and password "secret_sauce"
    Then I should see the inventory page
    And I should see the 'cart' icon should be asymmetrical
    And I should see the 'menu' icon should be asymmetrical
