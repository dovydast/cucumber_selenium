package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompareFiles {
    @When("System locates Comparable.txt file in Previous Folder{}")
    public void locatePreviousFolder() {

    }

    @And("System locates Comparable.txt file in Current Folder {}")
    public void locateCurrentFolder() {
    }
    @And("System compare both files text of all rows")
    public void compareFiles() {
    }

    @Then("System should produce test report result file")
    public void produceResults(){

    }
}
