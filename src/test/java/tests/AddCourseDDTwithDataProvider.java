package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

import java.awt.*;

public class AddCourseDDTwithDataProvider extends TestBase {
    private HomePage homePage;
    private LoginPage loginPage;
    private SwitchRolePage switchRolePage;
    private TraningPage traningPage;
    private AddCoursePage addCoursePage;

    @BeforeClass
    public void userLoggedIn() throws InterruptedException {
        loginPage = new LoginPage(webDriver);
        loginPage.loginWithEmailAndPass(fadyITFFOUSER_mail, fadyITFFOUSER_pass);
        homePage = new HomePage(webDriver);
        Thread.sleep(5000);
        homePage.goToSwitchRolePage();
        switchRolePage = new SwitchRolePage(webDriver);
        switchRolePage.switchToFFO();
        homePage.goToTrainingPage();
        traningPage = new TraningPage(webDriver);

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
    public void goToMainPAge() {
        homePage.goToTrainingPage();
    }
}
