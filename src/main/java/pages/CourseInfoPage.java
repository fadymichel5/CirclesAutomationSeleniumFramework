package pages;

import DataModel.CourseModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CourseInfoPage extends PageBase {
    @FindBy(css = "div.toast-message")
    public WebElement toastAddMessage;
    @FindBy(css = "div.toast")
    public WebElement toastDeleteMessage;
    @FindBy(xpath = "//*[@id=\"listingTraining\"]/tbody/tr/td/h5")
    public WebElement NotAvailableText;
    @FindBy(xpath = "//div[@class='kt-subheader__main']/h3")
    WebElement courseNameHeading;
    @FindBy(xpath = "//div[@class='dropdown dropdown-inline']/a[1]")
    WebElement deleteCourseButton;
    @FindBy(xpath = "//div[@class='dropdown dropdown-inline']/a[2]")
    WebElement editCourseButton;
    @FindBy(xpath = "//*[@id=\"kt_content\"]/div[2]/div[1]/div[2]/a")
    WebElement addModuleButton;
    @FindBy(id = "Title_English")
    WebElement moduleEnglishTitle;
    @FindBy(id = "Title_Arabic")
    WebElement moduleArabicTitle;
    @FindBy(id = "Description_English")
    WebElement moduleEnglishDesc;
    @FindBy(id = "Description_Arabic")
    WebElement moduleArabicDesc;
    @FindBy(id = "Duration_Hours")
    WebElement moduleHours;
    @FindBy(id = "Duration_Minutes")
    WebElement moduleMinutes;
    @FindBy(css = "button.btn.brand_primary-bg.btn-width.text-white")
    WebElement saveModuleButton;
    @FindBy(xpath = "//table/tbody/tr/td/div/div/div/a")
    List<WebElement> modulesNames;
    @FindBy(xpath = "//table/tbody/tr/td/button[@data-original-title='Edit']")
    List<WebElement> editButtons;
    @FindBy(xpath = "//table/tbody/tr/td/button[@data-original-title='Delete']")
    List<WebElement> deleteButtons;
    @FindBy(linkText = "Load more")
    WebElement loadMoreButton;
    @FindBy(css = "button.confirm.btn.btn-danger")
    WebElement yesConfirmDeleteButton;

    public CourseInfoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String headCourseName() {
        return courseNameHeading.getText();
    }

    public void addModule(CourseModule courseModule) throws InterruptedException {
        Thread.sleep(1000);
        clickButton(addModuleButton);
        Thread.sleep(1000);
        typeInTextBox(moduleEnglishTitle, courseModule.englishName);

        typeInTextBox(moduleArabicTitle, courseModule.arabicName);

        typeInTextBox(moduleEnglishDesc, courseModule.englishDesc);

        typeInTextBox(moduleArabicDesc, courseModule.arabicDesc);

        typeInTextBox(moduleHours, courseModule.hours);

        typeInTextBox(moduleMinutes, courseModule.minutes);

        clickButton(saveModuleButton);

    }

    public void goToModule(String moduleName) {
        for (WebElement module : modulesNames) {
            if (module.getText().contains(moduleName)) {
                System.out.println("Got the module " + moduleName + " and we will go to it");
                clickButton(module);
                return;
            }
        }
    }

    public int NumberOfModulesPresented() {
        return modulesNames.size();
    }

    public void deleteModule(int index) {
        clickButton(deleteButtons.get(index));
        clickButton(yesConfirmDeleteButton);
    }

    public boolean courseModuleIsPresented(String moduleName) {

        System.out.println("Searching in modules for " + moduleName);
        for (WebElement module : modulesNames) {
            //System.out.println(module.getText());
            if (module.getText().contains(moduleName)) {
                System.out.println("I Found " + module.getText());
                return true;
            }
        }
        System.out.println("I didn't find " + moduleName);
        return false;
    }

    public String toastAddMessage() {
        return toastAddMessage.getText();
    }

    public String toastDeleteMessage() {
        return toastDeleteMessage.getText();
    }

    public void deleteTheCourse() {
        clickButton(deleteCourseButton);
        clickButton(yesConfirmDeleteButton);
    }


}
