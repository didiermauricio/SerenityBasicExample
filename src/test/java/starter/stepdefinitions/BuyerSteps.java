package starter.stepdefinitions;

import com.google.common.base.Optional;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matcher;
import starter.pages.HomePage;
import starter.pages.ItemDetailsPage;
import starter.pages.SearchResultsPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class BuyerSteps {


    HomePage homePage;                                          // <1>
    SearchResultsPage searchResultsPage;

    @Step                                                       // <2>
    public void opens_etsy_home_page() {
        homePage.open();
    }

    @Step
    public void searches_for_items_containing(String keywords) {
        homePage.searchFor(keywords);
    }

    @Step
    public void should_see_items_related_to(String keywords) {
        List<String> resultTitles = searchResultsPage.getResultTitles();
        resultTitles.stream().forEach(title -> assertThat(title.contains(keywords)));
    }

    @Step
    public void filters_results_by_type(String type) {
        searchResultsPage.filterByType(type);
    }

    public int get_matching_item_count() {
        return searchResultsPage.getItemCount();
    }

    @Step
    public void should_see_item_count(Matcher<Integer> itemCountMatcher) {
        itemCountMatcher.matches(searchResultsPage.getItemCount());
    }

    ItemDetailsPage detailsPage;

    @Step
    public void selects_item_number(int number) {
        searchResultsPage.selectItem(number);
    }

    @Step
    public void should_see_matching_details(String searchTerm) {
        String itemName = detailsPage.getItemName();
        assertThat(itemName.toLowerCase()).contains(searchTerm);
    }

    @Step
    public void should_see_items_of_type(String type) {
        Optional<String> selectedType = searchResultsPage.getSelectedType();
        assertThat(selectedType.isPresent()).describedAs("No item type was selected").isTrue();
        assertThat(selectedType.get()).isEqualTo(type);
    }

}

