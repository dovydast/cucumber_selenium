package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"classpath:features"},glue = {"stepDefinitions"},
        tags = "@Hover",
        monochrome = true,
        plugin = {"pretty", "html:test-output","json:target/cucumber-reports/CucumberTestReport.json"},
        dryRun = false

)
public class MainRunner extends AbstractTestNGCucumberTests {

    //PARALLEL SCENARIOS - new window tab for each scenario
    @Override
    @DataProvider(parallel = false) // TRUE = enable to run all scenarios at the same time. FALSE = vice versa
    public Object[][] scenarios(){
        return super.scenarios();
    }

}
