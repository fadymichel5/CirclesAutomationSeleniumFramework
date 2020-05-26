package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.awt.*;

public class TraningTests extends TestBase {

    private HomePage homePage;
    private LoginPage loginPage;
    private SwitchRolePage switchRolePage;
    private TraningPage traningPage;
    private AddCoursePage addCoursePage;


    @BeforeClass
    public void userLoggedIn() throws InterruptedException {
        loginPage= new LoginPage(webDriver);
        loginPage.loginWithEmailAndPass(fadyITFFOUSER_mail,fadyITFFOUSER_pass);
        homePage=new HomePage(webDriver);
        Thread.sleep(5000);
        homePage.goToSwitchRolePage();
        switchRolePage = new SwitchRolePage(webDriver);
        switchRolePage.switchToFFO();
        homePage.goToTrainingPage();
        traningPage=new TraningPage(webDriver);

    }

    @Test(enabled = false)
    public void userGoToTraining(){
        Assert.assertTrue(traningPage.HeadTitle.getText().contains("Train"));
    }
    @Test(enabled = false)
    public void userGobBackToHomeFromTraining() {
        traningPage.gotoHomePage();
        homePage = new HomePage(webDriver);
        homePage.goToTrainingPage();
        webDriver.navigate().back();
        Assert.assertTrue(homePage.MostRecentInitiatives.isDisplayed());
    }

    @Test(enabled = false)
    void FFOChangeViewFromCatViewToCoursesView() {

        traningPage.changeBrowseByView();
        Assert.assertTrue(traningPage.addCourseButton.isDisplayed());
    }

    @Test(enabled = false)
    void FFFCanGoToAddCoursePage() {
        traningPage.goToAddCoursePage();
        addCoursePage = new AddCoursePage(webDriver);
        Assert.assertTrue(addCoursePage.getTitle().contains("Add Course"));
    }

    @Test
    void FFOAddDummyCourseData() throws AWTException, InterruptedException {
        traningPage.goToAddCoursePage();
        addCoursePage = new AddCoursePage(webDriver);
        addCoursePage.addDummyCourseData("Test Automated 1", "تجريب مميكن 1");
        traningPage = new TraningPage(webDriver);
        Assert.assertTrue(traningPage.coursesContains("Test Automated"));

    }

    @AfterMethod
    public void goToMainPAge(){
        homePage.goToTrainingPage();
    }





}
