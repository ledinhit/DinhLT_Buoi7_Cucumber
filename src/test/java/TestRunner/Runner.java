package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import org.testng.annotations.Test;

//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources/Features", glue = "StepDefinition")
//public class Runner {
//}

@Test
@CucumberOptions(features = "src/test/resources/Features", glue = "StepDefinition")
public class Runner extends AbstractTestNGCucumberTests {

}