package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TraningPage extends PageBase {
    @FindBy(xpath = "//*[@id=\"kt_subheader\"]/div/div[1]/h3")
    public WebElement HeadTitle;

    @FindBy(xpath = "//div[@class='kt-portlet__body']/div/div/span")
    List<WebElement> catCardsList;

    @FindBy(xpath = "//div[@class='col-lg-4 courses d-flex']")
    List<WebElement> courseCardsList;

    @FindBy(xpath = "//div[@class='col-lg-4 courses d-flex']/div/div/div/div/div/a/h5")
    List<WebElement> courseTitleCardsList;

    @FindBy(css = "button.dropdown-toggle")
    WebElement dropDownBrowseBy;

    @FindBy(xpath = "//a[@href='/FFO/Home/Index']")
    WebElement HomeLink;

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

    public void gotoHomePage() {
        clickButton(HomeLink);
    }

    public boolean coursesContains(String text) {
        for (WebElement course : courseTitleCardsList) {
            if (course.getText().contains(text)) {
                System.out.println("I found " + text + " In the courses");
                return true;
            }
        }
        System.out.println("I didn't find " + text + " In the courses");
        return false;
    }

    public void goToAddCoursePage() {
        changeBrowseByView();
        clickButton(addCourseButton);
    }



}
