package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Base_PO;
import pageObjects.Contact_Us_PO;


public class Contact_Us_Steps extends Base_PO {

    private Contact_Us_PO contact_po;

    public Contact_Us_Steps(Contact_Us_PO contact_po) {
        this.contact_po = contact_po;
    }


    @Given("access the webdriver university contact us page")
    public void access_the_webdriver_university_contact_us_page() {
        contact_po.navigateTo_ContactUs_Page();
    }

    @When("Enter a unique first name")
    public void enter_a_unique_first_name() {
        //driver.findElement(By.xpath("//form[@id='contact_form']/input[@name='first_name']")).sendKeys("AutoGEN_" + generateRandomNumber(4));
        //sendKeys(By.xpath("//form[@id='contact_form']/input[@name='first_name']"), "AutoGEN_" + generateRandomNumber(4));
        contact_po.setUnique_name();
    }

    @And("Enter a unique last name")
    public void enter_a_unique_last_name() {
        contact_po.setLast_name();
    }

    @And("Enter unique email address")
    public void enter_unique_email_address() {
        contact_po.setEmail();
    }

    @And("Enter a unique comment")
    public void enter_a_unique_comment() {
        contact_po.setComment();
    }

    @When("enter a specific first name {word}")
    public void enter_a_specific_first_name(String firstName) {
        contact_po.setSpecific_FirstName(firstName);
    }

    @When("enter a specific last name {word}")
    public void enter_a_specific_last_name(String lastName) {
        contact_po.setSpecific_LastName(lastName);
    }

    @When("enter a specific email address {word}")
    public void enter_a_specific_email_address(String email) {
        contact_po.setSpecific_Email(email);

    }

    @When("enter a specific comment {string}")
    public void enter_a_specific_comment(String comment) {
        contact_po.setSpecific_Comment(comment);
    }

    @And("click on the submit button")
    public void click_on_the_submit_button() {
        contact_po.click_submit_button();
    }

    @Then("It has to be presented successful confirmation")
    public void it_has_to_show_successful_confirmation() {
        contact_po.validateSuccessMessage();
    }

}
