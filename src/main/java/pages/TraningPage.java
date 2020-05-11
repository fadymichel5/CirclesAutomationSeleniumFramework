package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TraningPage extends PageBase {
    @FindBy(xpath = "//*[@id=\"kt_subheader\"]/div/div[1]/h3")
    public WebElement HeadTitle;

    @FindBy(xpath = "//div[@class='kt-portlet__body']/div/div/span")
    List<WebElement> catCardsList;

    @FindBy(css = "button.dropdown-toggle")
    WebElement dropDownBrowseBy;

    @FindBy(css = "button.dropdown-item.filters-show")
    WebElement getDropDownBrowseByItem;

    @FindBy(css = "a.btn.brand-add-primary--btn.CategoriesManage")
    public WebElement manageCatButton;

    @FindBy(css = "a.btn.brand-add-primary--btn.d-inline-flex")
    public WebElement addCourseButton;

    public TraningPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void changeBrowseByView(){
        clickButton(dropDownBrowseBy);
        clickButton(getDropDownBrowseByItem);
    }



}
