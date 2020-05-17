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

    Lorem lorem = LoremIpsum.getInstance();


    public AddCoursePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addDummyCourseData() throws AWTException {
        typeInTextBox(courseTitleEnglish, "Course 1 By Sel" + lorem.getWords(5, 10));
        typeInTextBox(courseTitleArabic, "الكورس الأول بالسيل");
        typeInTextBox(courseSummaryEnglish, "Summary of course 1 by sel\n" + lorem.getParagraphs(1, 1));
        typeInTextBox(courseSummaryArabic, PageHelper.arabicChar(100));
        typeInTextBox(courseObjectiveEnglish, lorem.getParagraphs(1, 1));
        typeInTextBox(courseObjectiveArabic, PageHelper.arabicChar(100));
        typeInTextBox(coursePrerequisiteEnglish, lorem.getParagraphs(1, 1));
        typeInTextBox(coursePrerequisiteArabic, PageHelper.arabicChar(100));
        clickButton(imageUploadIcon);
        Robot robot = new Robot();
        String imageName = "course1.jpg";
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
        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);

        clickButton(savePhotoButton);

        clickButton(categoryDropDown);
        clickButton(dropDownList.get(1));








    }


    public String getTitle() {
        return headTitle.getText();
    }


}
