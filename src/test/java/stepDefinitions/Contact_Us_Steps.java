package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {

    private WebDriver driver;

    @Before("@contact-us")
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@contact-us")
    public void exitBrowser(){
        driver.quit();
    }

    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }


    @Given("access the webdriver university contact us page")
    public void access_the_webdriver_university_contact_us_page() {
        driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("Enter a unique first name")
    public void enter_a_unique_first_name() {
        driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='first_name']")).sendKeys("AutoGEN_" + generateRandomNumber(4));
    }

    @And("Enter a unique last name")
    public void enter_a_unique_last_name() {
        driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='last_name']")).sendKeys("AutoGEN_" + generateRandomNumber(3));
    }

    @And("Enter unique email address")
    public void enter_unique_email_address() {
        driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='email']")).sendKeys("AutoEmail" + generateRandomNumber(10) + "@mail.com");
    }

    @And("Enter a unique comment")
    public void enter_a_unique_comment() {
        driver.findElement(By.xpath("//form[@id='contact_form']/textarea[@name='message']")).sendKeys("Hello " + generateRandomString(11));
    }

    @When("enter a specific first name {word}")
    public void enter_a_specific_first_name(String firstName) {
        driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='first_name']")).sendKeys(firstName);
    }
    @When("enter a specific last name {word}")
    public void enter_a_specific_last_name(String lastName) {
        driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='last_name']")).sendKeys(lastName);

    }
    @When("enter a specific email address {word}")
    public void enter_a_specific_email_address(String email) {
        driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='email']")).sendKeys(email);


    }
    @When("enter a specific comment {string}")
    public void enter_a_specific_comment(String comment) {
        driver.findElement(By.xpath("//form[@id='contact_form']/textarea[@name='message']")).sendKeys(comment);

    }


    @And("click on the submit button")
    public void click_on_the_submit_button() {
        driver.findElement(By.xpath("//div[@id='form_buttons']/input[@value='SUBMIT']")).click();
    }

    @Then("It has to be presented successful confirmation")
    public void it_has_to_show_successful_confirmation() {
        WebElement Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(Submission_Message.getText(), "Thank You for your Message!");
       System.out.println("Confirmation message: ");
    }

}
