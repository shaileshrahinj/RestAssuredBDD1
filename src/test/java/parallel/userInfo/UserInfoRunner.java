package parallel.userInfo;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/java/parallel/userInfo",plugin  = "json:target/jsonReports/cucumber-report.json", glue= {"parallel"})
public class UserInfoRunner {

}
