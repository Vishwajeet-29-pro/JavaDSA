Feature: Library Management System

  Scenario: Check availability of a book
    Given the library has following books
      | Title                    | Author                  | Quantity      |
      | Clean Code               | Robert Martin           | 5             |
      | Effective Java           | Joshua Bloch            | 3             |
      | The Pragmatic Programmer | Andy Hunt               | 0             |
    When I search for "Clean Code"
    Then the result should be "Available"

  Scenario: Barrow a book
    Given the library has following books
      | Title                    | Author                  | Quantity      |
      | Clean Code               | Robert Martin           | 5             |
    When I barrow the "Clean Code"
    Then the quantity of "Clean Code" should be 4