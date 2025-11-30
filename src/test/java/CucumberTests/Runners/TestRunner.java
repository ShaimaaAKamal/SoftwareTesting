package CucumberTests.Runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/CucumberTests/features",
        glue = {"CucumberTests.stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}



