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


    @Before("@login")
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@login")
    public void exitBrowser(){
        driver.quit();
    }


    @Given("Access the webdriver login page")
    public void access_the_webdriver_login_page() {
        driver.get("http://www.webdriveruniversity.com/Login-Portal/run.html");
    }
    @When("enter a login name {word}")
    public void enter_a_login_name(String loginName) {
        driver.findElement(By.xpath("/html//input[@id='text']")).sendKeys(loginName);
    }
    @When("enter a password {word}")
    public void enter_a_specific_password(String Password) {
        driver.findElement(By.xpath("/html//input[@id='password']")).sendKeys(Password);
    }
    @And("click on Login button")
    public void click_on_login_button() {
        driver.findElement(By.xpath("/html//button[@id='login-button']")).click();
    }

    @Then("Alert pop up should be presented with the following validation message {}")
    public void alert_pop_up_should_be_presented_with_the_following_validation_message(String expectedMessage) {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, expectedMessage);
    }


}
