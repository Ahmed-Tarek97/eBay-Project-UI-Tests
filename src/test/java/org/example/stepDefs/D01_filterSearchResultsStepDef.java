package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_homePage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class D01_filterSearchResultsStepDef {
    P01_homePage homePage = new P01_homePage();

    public D01_filterSearchResultsStepDef() throws IOException, ParseException {
    }

    @Given("the User is on the eBay homepage")
    public void theUSerIsOnTheEbayHomepage()
    {
        homePage.homePageAssertUrl();
    }

    @When("the User searches for product")
    public void theUserSearchesFor() {
        homePage.homePageSearch();
    }

    @Then("the User should see search results")
    public void theUserShouldSeeSearchResults() {
        homePage.homePageValidateSearchResults();
    }

    @And("log the number of obtained search results")
    public void logTheNumberOfObtainedSearchResults() {
        System.out.println("The Results Before Filtering:");
        homePage.homePageLogSearchResults();
    }

    @When("the User filters the search results by manual transmission")
    public void theUserFiltersTheSearchResultsByManualTransmission() {
        homePage.homePageClickManualTransmissionButton();
    }

    @Then("the User should see the filtered search results by manual transmission")
    public void theUserShouldSeeTheFilteredSearchResultsByManualTransmission() {
        System.out.println("The Results After Filtering:");
        homePage.homePageLogSearchResults();
    }
}
