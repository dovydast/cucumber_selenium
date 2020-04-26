package stepdefs;

import common.SeleniumBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class openValorantStream {


    @Given("I am on valorant game section page")
    public void i_am_on_valorant_game_section_page()  {
        SeleniumBase.setupFireFox();
        SeleniumBase.enterUrl("https://www.twitch.tv/directory/game/VALORANT");
    }
    @When("I click on first stream")
    public void i_click_onStream() {
        SeleniumBase.openFirstValorantStream();
    }

    @Then("I see first selected stream")
    public void WatchingStream() {
        SeleniumBase.openFirstValorantStreamViewCount();
    }
}
