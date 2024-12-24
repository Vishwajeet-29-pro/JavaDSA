package org.practice.dsa.cucumber_test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.practice.dsa.cucumber.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorDefinitions {
    private int result;
    private Calculator calculator;
    private Exception exception;

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
        try {
            result = calculator.divide(num1, num2);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int expectedResult) {
        assertEquals(expectedResult, result);
    }

    @Then("an ArithmeticException should be thrown")
    public void anArithmeticExceptionShouldBeThrown() {
        assertThrows(ArithmeticException.class, () -> {
            if (exception != null) throw exception;
        });
    }
}
