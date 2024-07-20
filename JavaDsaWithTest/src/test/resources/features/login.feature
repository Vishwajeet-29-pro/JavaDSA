Feature: User registration and login

  Scenario: Successful registration
    Given I am on the registration page
    When I have registered with username "user1" and password "password123"
    Then I should see a success message