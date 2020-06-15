package pages;


import Helper.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;


public class AddCoursePage extends PageBase {

    @FindBy(tagName = "html")
    WebElement body;

    @FindBy(css = "h1.kt-portlet__head-title")
    WebElement headTitle;

    @FindBy(id = "Title_English")
    WebElement courseTitleEnglish;

    @FindBy(id = "Title_Arabic")
    WebElement courseTitleArabic;

    @FindBy(id = "Summary_English")
    WebElement courseSummaryEnglish;

    @FindBy(id = "Summary_Arabic")
    WebElement courseSummaryArabic;

    @FindBy(id = "Objective_English")
    WebElement courseObjectiveEnglish;

    @FindBy(id = "Objective_Arabic")
    WebElement courseObjectiveArabic;

    @FindBy(id = "Prerequisite_English")
    WebElement coursePrerequisiteEnglish;

    @FindBy(id = "Prerequisite_Arabic")
    WebElement coursePrerequisiteArabic;

    @FindBy(css = "img.valid-image.img-responsive.previewImage")
    WebElement imageUploadIcon;

    @FindBy(xpath = "//button[@data-control-name]")
    WebElement savePhotoButton;

    @FindBy(css = "span.filter-option.pull-left")
    WebElement categoryDropDown;

    @FindBy(xpath = "//ul[@class='dropdown-menu inner']/li")
    List<WebElement> dropDownList;

    @FindBy(css = "button.btn.float-right.waves-effect.waves-classic.btn-default.btn-modalcancel")
    WebElement cancelPhotoButton;

    @FindBy(id = "Duration_Hours")
    WebElement durationHoursText;

    @FindBy(id = "Duration_Minutes")
    WebElement durationMinutesText;

    @FindBy(css = "span.switchery.switchery-small")
    WebElement toggleButton;

    @FindBy(xpath = "//*[@id=\"kt_content\"]/div/form/div[5]/div/button[2]")
    WebElement addCourseButton;

    Boolean visible = false;

    //Lorem lorem = LoremIpsum.getInstance();


    public AddCoursePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addDummyCourseData(String courseNameInEnglish, String courseNameInArabic) throws AWTException, InterruptedException {

        addCourseName(courseNameInEnglish + " " + PageHelper.englishWords(9), courseNameInArabic + " " + PageHelper.arabicChar(30));
        addCoursePrerequisite("Prerequisite of " + courseNameInEnglish + " \n" + PageHelper.englishParagraph(4), " متطلبات " + courseNameInArabic + PageHelper.arabicChar(2000));
        addCourseSummary("Summary of " + courseNameInEnglish + " \n" + PageHelper.englishParagraph(4), " ملخص " + courseNameInArabic + PageHelper.arabicChar(2000));
        addCourseObjective("Objective of " + courseNameInEnglish + " \n" + PageHelper.englishParagraph(4), " الهدف " + courseNameInArabic + PageHelper.arabicChar(2000));
        uploadCoursePhoto("course1.jpg");
        selectCategory("4");
        addCourseDuration("5", "00");
        makeItVisible();
        clickButton(addCourseButton);

    }

    private void makeItVisible() {
        if (!visible) {
            visible = true;
            clickButton(toggleButton);
        }
    }

    private void makeItNotVisible() {
        if (visible) {
            visible = false;
            clickButton(toggleButton);
        }
    }

    private void selectCategory(int categoryIndex) {
        clickButton(categoryDropDown);
        clickButton(dropDownList.get(categoryIndex));
    }

    private void selectCategory(String category) {
        clickButton(categoryDropDown);
        for (WebElement cat : dropDownList) {
            if (cat.getText().contains(category)) {
                clickButton(cat);
                return;
            }
        }

    }

    private void addCourseName(String englishName, String arabicName) {
        typeInTextBox(courseTitleEnglish, englishName);
        typeInTextBox(courseTitleArabic, arabicName);
    }

    private void addCourseSummary(String englishSummary, String arabicSummary) {
        typeInTextBox(courseSummaryEnglish, englishSummary);
        typeInTextBox(courseSummaryArabic, arabicSummary);
    }

    private void addCourseObjective(String englishObjective, String arabicObjective) {
        typeInTextBox(courseObjectiveEnglish, englishObjective);
        typeInTextBox(courseObjectiveArabic, arabicObjective);
    }

    private void addCoursePrerequisite(String englishPrerequisite, String arabicPrerequisite) {
        typeInTextBox(coursePrerequisiteEnglish, englishPrerequisite);
        typeInTextBox(coursePrerequisiteArabic, arabicPrerequisite);
    }

    private void uploadCoursePhoto(String imageName) throws AWTException, InterruptedException {
        clickButton(imageUploadIcon);
        Robot robot = new Robot();
        String imagePath = System.getProperty("user.dir") + "\\Uploads\\" + imageName;
        System.out.println(imagePath);
        StringSelection selection = new StringSelection(imagePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

        if (savePhotoButton.isDisplayed()) {
            System.out.println("Save Photo displayed after first try of upload");
            clickButton(savePhotoButton);
            return;
        }
        System.out.println("Save Photo didn't display after first try of upload");
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);

        clickButton(savePhotoButton);
        Thread.sleep(5000);
    }

    private void addCourseDuration(String hours, String minutes) {
        typeInTextBox(durationHoursText, hours);
        typeInTextBox(durationMinutesText, minutes);
    }

    public String getTitle() {
        return headTitle.getText();
    }


}
