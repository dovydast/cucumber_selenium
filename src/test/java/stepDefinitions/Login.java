package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class Login {

    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    private WebDriver driver;


    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void exitBrowser(){
        driver.quit();
    }


    @Given("Access the webdriver login page")
    public void access_the_webdriver_login_page() {
        driver.get("http://www.webdriveruniversity.com/Login-Portal/run.html");
    }
    @When("I enter a specific login name {word}")
    public void i_enter_a_specific_login_name(String loginName) {
        driver.findElement(By.xpath("/html//input[@id='text']")).sendKeys(loginName);
    }
    @When("I enter a specific password {word}")
    public void i_enter_a_specific_password(String Password) {
        driver.findElement(By.xpath("/html//input[@id='password']")).sendKeys(Password);
    }
    @And("I click on Login button")
    public void i_click_on_login_button() {
        driver.findElement(By.xpath("/html//button[@id='login-button']")).click();
    }

    @When("I enter random login name")
    public void i_enter_random_login_name() {
        driver.findElement(By.xpath("/html//input[@id='text']")).sendKeys(generateRandomString(10));
    }
    @And("I enter random password")
    public void i_enter_random_password() {
        driver.findElement(By.xpath("/html//input[@id='password']")).sendKeys(generateRandomString(12));
    }
    @Then("Alert pop up should be presented with a unsuccessful invalid message - Validation failed")
    public void alert_pop_up_should_be_presented_with_a_unsuccessful_invalid_message_validation_failed() {
        Alert al = driver.switchTo().alert();
        Assert.assertEquals(al.getText(), "validation failed");

    }

    @Then("Alert pop up should be presented with a successful valid message - Validation succeeded")
    public void alert_pop_up_should_be_presented_with_a_successful_valid_message() {
        Alert al = driver.switchTo().alert();
        Assert.assertEquals(al.getText(), "validation succeeded");

    }
}
