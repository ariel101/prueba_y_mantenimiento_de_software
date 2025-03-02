package com.codingstones.bdd.calculator;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/calculator/features" },
        features = "classpath:features/calculator/calculator.feature"
)
public class RunCalculatorTest {
}