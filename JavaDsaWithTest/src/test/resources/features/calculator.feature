Feature: Calculator

  Scenario: Adding two numbers
    Given I have a calculator
    When I add 5 and 3
    Then the result should be 8

  Scenario: Subtracting two numbers
    Given I have a calculator
    When I subtract 5 and 3
    Then the result should be 2