package runners;

import io.cucumber.java.it.Data;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"classpath:features"},glue = {"stepDefinitions"},
        tags = "",
        monochrome = false,
        plugin = {"pretty", "html:target/report","json:target/cucumber.json"},
        dryRun = false

)
public class MainRunner extends AbstractTestNGCucumberTests {

    //PARALLEL SCENARIOS - new window tab for each scenario
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}
