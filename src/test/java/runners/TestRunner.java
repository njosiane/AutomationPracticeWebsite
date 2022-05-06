package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@regression",
        publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {
}

