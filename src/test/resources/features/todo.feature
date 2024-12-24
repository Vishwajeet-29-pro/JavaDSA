Feature: Todo Management

  Scenario: Adding a new todo
    Given I have an empty todo list
    When I add a new todo with the title "Buy milk"
    Then the todo list should contain 1 todo
    And the title of the first todo should be "Buy milk"