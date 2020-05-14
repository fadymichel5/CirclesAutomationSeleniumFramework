package pages;


import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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

    @FindBy(tagName = "figcaption")
    WebElement imageUploadIcon;
    

    Lorem lorem = LoremIpsum.getInstance();


    public AddCoursePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addDummyCourseData() {
        typeInTextBox(courseTitleEnglish, "Course 1 By Sel" + lorem.getWords(5, 10));
        typeInTextBox(courseTitleArabic, "الكورس الأول بالسيل");
        typeInTextBox(courseSummaryEnglish, "Summary of course 1 by sel\n" + lorem.getParagraphs(5, 8));
        typeInTextBox(courseSummaryArabic, PageHelper.arabicChar(2000));
        typeInTextBox(courseObjectiveEnglish, lorem.getParagraphs(5, 8));
        typeInTextBox(courseObjectiveArabic, PageHelper.arabicChar(2000));
        typeInTextBox(coursePrerequisiteEnglish, lorem.getParagraphs(5, 8));
        typeInTextBox(coursePrerequisiteArabic, PageHelper.arabicChar(2000));
        String imageName = "course1.jpg";
        String imagePath = System.getProperty("user.dir") + "/Uploads/" + imageName;


    }


    public String getTitle() {
        return headTitle.getText();
    }


}
