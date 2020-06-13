package tests;

import DataModel.CourseLesson;
import DataModel.CourseModule;
import Helper.PageHelper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.awt.*;
import java.util.Random;

public class TraningTests extends TestBase {

    private HomePage homePage;
    private LoginPage loginPage;
    private SwitchRolePage switchRolePage;
    private TraningPage traningPage;
    private AddCoursePage addCoursePage;
    String COURSE_NAME = "Shata String";
    private CourseInfoPage courseInfoPage;
    private ModuleInfoPage moduleInfoPage;

    @BeforeClass
    public void userLoggedInAsFFO() {
        loginPage = new LoginPage(webDriver); //Open login page
        loginPage.loginWithEmailAndPass(fadyITFFOUSER_mail, fadyITFFOUSER_pass);//Enter the email and Pass and click login
        homePage = new HomePage(webDriver);// Open Home Page
        if (!homePage.verfiyIsFFO())// if account in user Role switch it to FFO
        {
            homePage.goToSwitchRolePage();// Go to switch role page
            switchRolePage = new SwitchRolePage(webDriver); // Open switch role page
            switchRolePage.switchToFFO();// switch to FFO
        }

        homePage.goToTrainingPage();// click training logo
        traningPage = new TraningPage(webDriver);// go to training page

    }

    @Test(priority = 0)
    public void userGoToTraining() {
        Assert.assertTrue(traningPage.HeadTitle.getText().contains("Train"));
    }

    @Test(dependsOnMethods = "userGoToTraining")
    public void userGobBackToHomeFromTraining() {
        traningPage.gotoHomePage();
        homePage = new HomePage(webDriver);
        homePage.goToTrainingPage();
        webDriver.navigate().back();
        Assert.assertTrue(homePage.MostRecentInitiatives.isDisplayed());
    }

    @Test(dependsOnMethods = "userGoToTraining")
    void FFOChangeViewFromCatViewToCoursesView() {
        traningPage.changeBrowseByView();//Change to courses view
        Assert.assertTrue(traningPage.addCourseButton.isDisplayed());
    }

    @Test(enabled = false)
    void FFFCanGoToAddCoursePage() {
        traningPage.goToAddCoursePage();
        addCoursePage = new AddCoursePage(webDriver);
        Assert.assertTrue(addCoursePage.getTitle().contains("Add Course"));
    }

    @Test(enabled = false)
    void FFOAddDummyCourseData() throws AWTException, InterruptedException {
        traningPage.goToAddCoursePage();
        addCoursePage = new AddCoursePage(webDriver);
        addCoursePage.addDummyCourseData("Test Automated 1", "تجريب مميكن 1");
        traningPage = new TraningPage(webDriver);
        Assert.assertTrue(traningPage.coursesContains("Test Automated"));

    }

    @Test
    void FFOCanAddModuleToAnyCourse() throws InterruptedException {
        traningPage.changeBrowseByView();
        traningPage.goToCourse("Happy");
        courseInfoPage = new CourseInfoPage(webDriver);
        Assert.assertTrue(courseInfoPage.headCourseName().contains("Happy"));
        CourseModule courseModule = new CourseModule();
        int i = 800;
        courseModule.setEnglishName("Module " + i + " " + PageHelper.englishWords(6));
        courseModule.setArabicName("الفصل " + i + " " + PageHelper.arabicChar(40));
        courseModule.setHours("7");
        courseModule.setMinutes("30");
        courseInfoPage.addModule(courseModule);
        Assert.assertTrue(courseInfoPage.toastAddMessage().contains("success"));
        webDriver.navigate().refresh();
        Assert.assertTrue(courseInfoPage.courseModuleIsPresented(courseModule.getEnglishName()));

    }

    @Test
    void FFODeleteAllModulesInCourse() {
        traningPage.changeBrowseByView();
        traningPage.goToCourse("he is");
        courseInfoPage = new CourseInfoPage(webDriver);
        Assert.assertTrue(courseInfoPage.headCourseName().contains("he is"));
        while (courseInfoPage.NumberOfModulesPresented() > 0) {
            System.out.println("Still modules Presented");
            courseInfoPage.deleteModule(0);
            System.out.println("Toast message after delete : " + courseInfoPage.toastDeleteMessage());
            Assert.assertTrue(courseInfoPage.toastDeleteMessage().toLowerCase().contains("success"));
            webDriver.navigate().refresh();
        }
        Assert.assertEquals(courseInfoPage.NotAvailableText.getText(), "Not Available");

    }

    @Test
    void FFODAddModulesInCourse() throws InterruptedException { // working
        traningPage.changeBrowseByView();
        traningPage.goToCourse("Course added By Selenium sadipscing mus potenti aeque persequeris nibh fringilla vehicula moderatius");
        courseInfoPage = new CourseInfoPage(webDriver);
        Assert.assertTrue(courseInfoPage.headCourseName().contains("Course added By Selenium sadipscing mus potenti aeque persequeris nibh fringilla vehicula moderatius"));

        for (int i = 1; i <= 5; i++) {
            CourseModule courseModule = new CourseModule();
            courseModule.setEnglishName("Module " + i + " " + PageHelper.englishWords(6));
            courseModule.setArabicName("الفصل " + i + " " + PageHelper.arabicChar(40));
            Random random = new Random();
            int hours = random.nextInt(100);
            courseModule.setHours(Integer.toString(hours));
            int minutes = random.nextInt(59);
            courseModule.setMinutes(Integer.toString(minutes));
            courseModule.setEnglishDesc("Desc for Module " + i + '\n' + PageHelper.englishParagraph(2));
            courseModule.setArabicDesc("وصف الملخص" + i + "\n" + PageHelper.arabicChar(1000));
            courseInfoPage.addModule(courseModule);
            Assert.assertTrue(courseInfoPage.toastAddMessage().contains("success"));
            //webDriver.navigate().refresh();
        }


    }

    @Test
    void FFODAddLessonToModule() throws InterruptedException {
        traningPage.changeBrowseByView();
        traningPage.goToCourse("Happy");
        courseInfoPage = new CourseInfoPage(webDriver);
        Assert.assertTrue(courseInfoPage.headCourseName().contains("Happy"));
        courseInfoPage.goToModule("Module 1");
        moduleInfoPage = new ModuleInfoPage(webDriver);
        int i = 1;
        CourseLesson courseLesson = new CourseLesson();
        courseLesson.setEnglishName("Lesson " + i + " " + PageHelper.englishWords(6));
        courseLesson.setArabicName("الدرس " + i + " " + PageHelper.arabicChar(40));
        Random random = new Random();
        int hours = random.nextInt(100);
        courseLesson.setHours(Integer.toString(hours));
        int minutes = random.nextInt(59);
        courseLesson.setMinutes(Integer.toString(minutes));
        courseLesson.setEnglishDesc("Desc for Lesson " + i + '\n' + PageHelper.englishParagraph(2));
        courseLesson.setArabicDesc("وصف الدرس" + i + "\n" + PageHelper.arabicChar(1000));
        moduleInfoPage.addLesson(courseLesson);
        Thread.sleep(500);
        Assert.assertTrue(courseInfoPage.toastAddMessage().contains("success"));
        //webDriver.navigate().refresh();


    }

    @Test
    void FFOCanDeleteCourse() {//Working
        traningPage.changeBrowseByView();
        Assert.assertTrue(traningPage.coursesContains("Course 3 test course"));
        traningPage.goToCourse("Course 3 test course");
        courseInfoPage = new CourseInfoPage(webDriver);
        Assert.assertTrue(courseInfoPage.headCourseName().contains("Course 3 test course"));
        courseInfoPage.deleteTheCourse();
        traningPage = new TraningPage(webDriver);
        traningPage.changeBrowseByView();
        Assert.assertFalse(traningPage.coursesContains("Course 3 test course"));
    }

    @AfterMethod
    public void goToMainPAge() {
        homePage.goToTrainingPage();
    }


}
