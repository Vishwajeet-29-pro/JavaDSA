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

  Scenario: Add a new book
    Given the library has following books
      | Title      | Author        | Quantity |
      | Clean Code | Robert Martin | 5        |
    When I add a new book "Effective Java" with author "Joshua Bloch" and quantity 5
    Then the library should be updated with book details
      | Title          | Author        | Quantity |
      | Clean Code     | Robert Martin | 5        |
      | Effective Java | Joshua Bloch  | 5        |

  Scenario: Delete a book
    Given the library has following books
      | Title          | Author        | Quantity |
      | Clean Code     | Robert Martin | 5        |
      | Effective Java | Joshua Bloch  | 5        |
    When I delete the book "Effective Java"
    Then the book with name "Effective Java" is removed
    And the library should be updated with book details
      | Title      | Author        | Quantity |
      | Clean Code | Robert Martin | 5        |