package stepdefs;

import common.SeleniumBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class openValorantSectionOnTwitch {


    @Given("I have configured browser setup")
    public void i_have_configured_browser_setup()  {
        SeleniumBase.setupFireFox();
    }
    @When("I navigate to valorant game section")
    public void i_navigate_to_valorant_game_section() {
        SeleniumBase.enterUrl("https://www.twitch.tv/directory/game/VALORANT");
    }

    @Then("I see valorant streaming section")
    public void i_see_valorant_streaming_section() {
       SeleniumBase.getTwitchValorantInfo();
    }
}
