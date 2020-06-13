package pages;

import DataModel.CourseLesson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ModuleInfoPage extends PageBase {
    @FindBy(css = "div.toast-message")
    public WebElement toastAddMessage;
    @FindBy(css = "div.toast")
    public WebElement toastDeleteMessage;
    @FindBy(xpath = "//*[@id=\"listingTraining\"]/tbody/tr/td/h5")
    public WebElement NotAvailableText;
    @FindBy(xpath = "//*[@id=\"kt_subheader\"]/div/div[1]/h3")
    WebElement courseNameHeading;
    @FindBy(xpath = "//*[@id=\"kt_subheader\"]/div/div[2]/div/div/a[1]")
    WebElement deleteCourseButton;
    @FindBy(xpath = "//*[@id=\"kt_subheader\"]/div/div[2]/div/div/a[2]")
    WebElement editCourseButton;
    @FindBy(xpath = "//*[@id=\"kt_content\"]/div[1]/div/div/div/div/div[2]/div/div/div[2]/div/center/h5")
    WebElement notAvailableText;
    @FindBy(xpath = "button.btn.btn.brand-add-primary--btn")
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


    public ModuleInfoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String headCourseName() {
        return courseNameHeading.getText();
    }

    public void addLesson(CourseLesson courseLesson) throws InterruptedException {
        clickButton(addModuleButton);
        Thread.sleep(500);
        typeInTextBox(moduleEnglishTitle, courseLesson.englishName);
        Thread.sleep(500);
        typeInTextBox(moduleArabicTitle, courseLesson.arabicName);
        Thread.sleep(500);
        typeInTextBox(moduleEnglishDesc, courseLesson.englishDesc);
        Thread.sleep(500);
        typeInTextBox(moduleArabicDesc, courseLesson.arabicDesc);
        Thread.sleep(500);
        typeInTextBox(moduleHours, courseLesson.hours);
        Thread.sleep(500);
        typeInTextBox(moduleMinutes, courseLesson.minutes);
        Thread.sleep(500);
        clickButton(saveModuleButton);
        Thread.sleep(1000);
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

    public boolean courseModuleIsPresented(String moduleName) throws InterruptedException {
        if (loadMoreButton.isDisplayed()) {
            clickButton(loadMoreButton);
            Thread.sleep(2000);
        }
        System.out.println("Searching in modules for " + moduleName);
        for (WebElement module : modulesNames) {
            System.out.println(module.getText());
            if (module.getText().contains(moduleName)) {
                System.out.println("Got the module and we will go to it");
                //clickButton(module);
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


}
