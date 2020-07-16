package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")
    private WebElement searchTextBox;


    public SearchPage(WebDriver webDriver) {
        super(webDriver);

    }

    public void searchFor(String subject) {

        typeInTextBox(searchTextBox, subject);
        pressEnter(searchTextBox);

    }


}
