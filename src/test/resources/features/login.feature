Feature: User registration and login

  Scenario: Successful registration
    Given I am on the registration page
    When I have registered with username "user1" and password "password123"
    Then I should see a success message

    Scenario: Successful login
      Given I have registered with username "user1" and password "password123"
      When I login with username "user1" and password "password123"
      Then I should be redirected to the dashboard

    Scenario: Registration fail
      Given I am on the registration page
      And I have registered with username "user1" and password "password123"
      When I have registered with username "user1" and password "password1234"
      Then I should see a Username already exists

    Scenario: Invalid username or password
      Given I have registered with username "user1" and password "password123"
      When I login with username "user2" and password "password123"
      Then I should see a Invalid username or password