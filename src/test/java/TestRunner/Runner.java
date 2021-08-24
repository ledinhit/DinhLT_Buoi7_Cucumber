package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

// Em có làm theo 2 cách:
//Cách 1: sử dụng TestNG (dùng file testNG.xml để chạy)
//Cách 2: Sử dụng Cucumber(dùng file Runner.java để chạy - test/java/TestRunner)

@Test
@CucumberOptions(features = "src/test/resources/Features", glue = "StepDefinition")
public class Runner extends AbstractTestNGCucumberTests {

}