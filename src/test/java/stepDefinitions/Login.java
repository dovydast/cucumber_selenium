package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Login_PO;


public class Login extends Base_PO {
    private WebDriver driver = getDriver();

    private Login_PO login_po;

    public Login(Login_PO login_po){
        this.login_po = login_po;
    }


    @Given("Access the webdriver login page")
    public void access_the_webdriver_login_page() {
        login_po.navigateTo_Login_Page();
    }
    @When("enter a login name {}")
    public void enter_a_login_name(String loginName) {
        //driver.findElement(By.xpath("/html//input[@id='text']")).sendKeys(loginName);
        login_po.setLoginName(loginName);
    }
    @When("enter a password {}")
    public void enter_a_specific_password(String Password) {
       // driver.findElement(By.xpath("/html//input[@id='password']")).sendKeys(Password);
        login_po.setPassword(Password);
    }
    @And("click on Login button")
    public void click_on_login_button() {
       // waitClick(By.xpath("/html//button[@id='login-button']"));
        login_po.clickOn_Login_Button();
    }

    @Then("Alert pop up should be presented with the following validation message {}")
    public void alert_pop_up_should_be_presented_with_the_following_validation_message(String expectedMessage) {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, expectedMessage);
    }


}
