Feature: Calculator

  Scenario: Adding two numbers
    Given I have a calculator
    When I add 5 and 3
    Then the result should be 8

  Scenario: Subtracting two numbers
    Given I have a calculator
    When I subtract 5 and 3
    Then the result should be 2

  Scenario: Multiply two numbers
    Given I have a calculator
    When I multiply 5 and 3
    Then the result should be 15

  Scenario:
    Given I have a calculator
    When I divide 6 by 3
    Then  the result should be 2

  Scenario:
    Given I have a calculator
    When I divide 6 by 0
    Then an ArithmeticException should be thrown