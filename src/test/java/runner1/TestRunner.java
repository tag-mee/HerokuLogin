package runner1;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features",
glue = "StepsDefinition",
tags = "@LoginTest and @Before and @After",
plugin = { "pretty","html:target/cucumber-reports" }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
