package pages;


import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
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

    Boolean visible = false;

    Lorem lorem = LoremIpsum.getInstance();


    public AddCoursePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addDummyCourseData() throws AWTException, InterruptedException {

        addCourseName("Course 1 By Sel" + lorem.getWords(5, 10), "الكورس الأول بالسيل");
        addCourseSummary("Summary of course 1 by sel\n" + lorem.getParagraphs(1, 1), PageHelper.arabicChar(100));
        addCourseObjective(lorem.getParagraphs(1, 1), PageHelper.arabicChar(100));
        addCoursePrerequisite(lorem.getParagraphs(1, 1), PageHelper.arabicChar(100));
        uploadCoursePhoto("course1.jpg");
        selectCategory(1);
        addCourseDuration("77", "77");
        makeItVisible();

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
