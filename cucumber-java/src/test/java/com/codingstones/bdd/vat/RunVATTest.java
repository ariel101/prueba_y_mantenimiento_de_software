package com.codingstones.bdd.vat;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty", "html:target/vat/features" },
        features = "classpath:features/vat"
)
public class RunVATTest {
}