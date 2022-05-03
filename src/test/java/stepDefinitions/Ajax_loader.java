package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.annotations.Test;
import pageObjects.Ajax_loader_PO;

public class Ajax_loader {

    private Ajax_loader_PO ajax_po;

    public Ajax_loader(Ajax_loader_PO ajax_po){
        this.ajax_po = ajax_po;
    }

    @Given("Access the webdriver alerts page")
    public void access_the_webdriver_alerts_page() {
      this.ajax_po.NavigateToPage();
    }

    @Then("Wait for green button appearance")
        public void WaitForGreenButton(){
        this.ajax_po.waitForPresence();
        }
    @When("Click on ajax loader")
    public void click_on_ajax_loader() {
        this.ajax_po.ClickButton();
    }
    @When("Click on green button")
    public void click_on_green_button() {
        this.ajax_po.ClickGreenButton();
    }

    @Then("Click to close modal")
    public void click_to_close_alert() {
        this.ajax_po.CloseModal();
    }
}
