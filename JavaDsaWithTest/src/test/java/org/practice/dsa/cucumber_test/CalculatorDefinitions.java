package org.practice.dsa.cucumber_test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.practice.dsa.cucumber.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDefinitions {
    private int result;
    private Calculator calculator;

    @Given("I have a calculator")
    public void iHaveACalculator() {
        calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void iAddAnd(int num1, int num2) {
        result = calculator.add(num1, num2);
    }

    @When("I subtract {int} and {int}")
    public void iSubtractAnd(int num1, int num2) {
        result = calculator.subtract(num1, num2);
    }

    @When("I multiply {int} and {int}")
    public void iMultiplyAnd(int num1, int num2) {
        result = calculator.multiply(num1, num2);
    }

    @When("I divide {int} by {int}")
    public void iDivideBy(int num1, int num2) {
        result = calculator.divide(num1, num2);
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int expectedResult) {
        assertEquals(expectedResult, result);
    }
}
