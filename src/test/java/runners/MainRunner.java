package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"classpath:features"},glue = {"stepDefinitions"},
        tags = "@contact-us",
        monochrome = false,
        plugin = {"pretty", "html:target/report","json:target/cucumber.json"},
        dryRun = false

)
public class MainRunner extends AbstractTestNGCucumberTests {

    //PARALLEL SCENARIOS - new window tab for each scenario
    @Override
    @DataProvider(parallel = true) // TRUE = enable to run all scenarios at the same time. FALSE = vice versa
    public Object[][] scenarios(){
        return super.scenarios();
    }

}
