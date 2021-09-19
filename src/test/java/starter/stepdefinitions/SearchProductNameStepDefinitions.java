package starter.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.thucydides.core.annotations.Steps;


public class SearchProductNameStepDefinitions {
    @Steps
    BuyerSteps buyer;

    @Given("^I want to buy (.*)$")
    public void buyerWantsToBuy(String article) {
        buyer.opens_etsy_home_page();
    }

    @When("^I search for items containing (.*)$")
    public void searchByProductBame(String keyword) {
        buyer.searches_for_items_containing(keyword);
    }

    @Then("^I should only see items related to (.*)$")
    public void resultsForACategoryAndKeywordInARegion(String keyword) {
        buyer.should_see_items_related_to(keyword);
    }


    String searchTerm;

    @Given("^I have searched for items containing (.*)$")
    public void buyerHasSearchedFor(String keyword) {
        searchTerm = keyword;
        buyer.opens_etsy_home_page();
        buyer.searches_for_items_containing(keyword);
    }

    @When("^I filter results by type (.*)$")
    public void filterResultsBy(String type) {
        buyer.filters_results_by_type(type);
    }

    @Then("^I should only see items containing (.*) of type (.*)$")
    public void shouldSeeMatchingFilteredResults(String keyword, String type) {
        buyer.should_see_items_related_to(keyword);
        buyer.should_see_items_of_type(type);
    }

    @When("I select an item")
    public void selectsAnItem() {
        buyer.selects_item_number(1);
    }

    @Then("I should see the corresponding item details")
    public void shouldSeeCorrespondingDetails() {
        buyer.should_see_matching_details(searchTerm);
    }

}

