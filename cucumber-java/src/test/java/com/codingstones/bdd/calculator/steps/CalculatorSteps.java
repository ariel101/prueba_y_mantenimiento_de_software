package com.codingstones.bdd.calculator.steps;

import com.codingstones.bdd.calculator.Calculator;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalculatorSteps {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Given("^I have a calculator$")
    public void i_have_a_calculator() throws Throwable {
        assertNotNull(calculator);
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void i_add_and(int arg1, int arg2) throws Throwable {
        calculator.sum(arg1, arg2);
    }

    @Then("^the result should be (\\d+)$")
    public void the_result_should_be(int arg1) throws Throwable {
        assertEquals(arg1, calculator.currentValue());
    }

    @When("^I subtract (\\d+) and (\\d+)$")
    public void i_subtract_and(int arg1, int arg2) throws Throwable {
        calculator.subtract(arg1, arg2);
    }

    @When("I multiply {int} and {int}")
    public void i_multiply_and(int arg1, int arg2) {
        // Write code here that turns the phrase above into concrete actions
        calculator.multiply(arg1, arg2);
        //throw new io.cucumber.java.PendingException();
    }

    @When("I divide {int} and {int}")
    public void i_divide_and(int arg1, int arg2) {
        // Write code here that turns the phrase above into concrete actions
        calculator.divide(arg1, arg2);
        //throw new io.cucumber.java.PendingException();
    }

}
