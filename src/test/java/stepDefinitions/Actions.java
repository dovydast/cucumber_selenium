package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Actions_PO;


public class Actions {


    private Actions_PO actions_po;

    public Actions(Actions_PO actions_po){
        this.actions_po = actions_po;
    }

    @Given("Access the webdriver action page")
    public void access_the_webdriver_action_page() {
       actions_po.navigateTo_Page();
    }

    @When("Move small box to targeted Box location")
    public void move_small_box_to_targeted_box_location() {
        actions_po.DragAndDrop();

    }
    @Then("Present with confirmation message")
    public void present_with_confirmation_message() {
        actions_po.validateConfirmationMessage();
    }

    @When("Double click on yellow box")
    public void double_click_on_yellow_box() {
        actions_po.doubleClickYellowBox();
    }
    @Then("The box has to be green color")
    public void the_box_has_to_be_green_color() {
        actions_po.colorResult();
    }
}
