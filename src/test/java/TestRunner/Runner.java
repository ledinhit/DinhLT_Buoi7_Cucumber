package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;


@Test
@CucumberOptions(features = "src/test/resources/Features", glue = "StepDefinition")
public class Runner extends AbstractTestNGCucumberTests {

}