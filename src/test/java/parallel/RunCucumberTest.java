package parallel;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin  = "json:target/jsonReports/cucumber-report.json")
public class RunCucumberTest {
}