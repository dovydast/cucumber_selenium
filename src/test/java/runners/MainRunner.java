package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"},glue = {"stepDefinitions"},
        tags = "",
        plugin = {"pretty", "html:target/report","json:target/cucumber.json"},
        dryRun = false

)
public class MainRunner extends AbstractTestNGCucumberTests {

}
