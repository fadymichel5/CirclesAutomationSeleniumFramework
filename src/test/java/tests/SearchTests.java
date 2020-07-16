package tests;

import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTests extends TestBase {

    private SearchPage searchPage;

    @Test
    public void userCanSearch() {
        searchPage = new SearchPage(webDriver);
        searchPage.searchFor("Fady Michel");
    }


}
