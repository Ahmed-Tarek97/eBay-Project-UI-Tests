package org.example.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"org.example.stepDefs"},
        plugin = { "pretty",
                "html:target/cucumber.html"
        },
        tags = "@smoke"
)

public class testRunner extends AbstractTestNGCucumberTests {
}