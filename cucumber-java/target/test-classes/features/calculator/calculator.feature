Feature: Calculator
  As a user
  I want to use a calculator
  So that I don't need to calculate myself

  Scenario: Add two numbers
    Given I have a calculator
    When I add 2 and 3
    Then the result should be 5

  Scenario: Subtract two numbers
    Given I have a calculator
    When I subtract 5 and 3
    Then the result should be 2

  Scenario: Multiply two numbers
    Given I have a calculator
    When I multiply 5 and 3
    Then the result should be 15

  Scenario: Divide two numbers
    Given I have a calculator
    When I divide 15 and 3
    Then the result should be 5