package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddCoursePage;
import pages.HomePage;
import pages.LoginPage;
import pages.TraningPage;

import java.awt.*;

public class TraningTests extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    TraningPage traningPage;
    AddCoursePage addCoursePage;

    @BeforeClass
    public void userLoggedin() throws InterruptedException, AWTException {
        loginPage= new LoginPage(webDriver);
        loginPage.loginWithEmailAndPass(fadyITFFOUSER_mail,fadyITFFOUSER_pass);
        //System.out.println(webDriver);
        homePage=new HomePage(webDriver);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,5);
        webDriverWait.until(ExpectedConditions.visibilityOf(homePage.profileTopIcon));
        homePage.goToTrainingPage();
        traningPage=new TraningPage(webDriver);

    }

    @Test(enabled = false)
    public void userGoToTraining(){
        Assert.assertTrue(traningPage.HeadTitle.getText().contains("Train"));
    }
    @Test(enabled = false)
    public void userGobBcktT0HomeFromTraining() {

        webDriver.navigate().back();
        Assert.assertTrue(homePage.MostRecentInitiatives.isDisplayed());
    }

    @Test(enabled = false)
    void FFOchangeViewFromCatViewToCoursesView() {

        traningPage.changeBrowseByView();
        Assert.assertTrue(traningPage.addCourseButton.isDisplayed());
    }

    @Test
    void FFFCanGoToAddCoursePage() {
        traningPage.goToAddCoursePage();
        addCoursePage = new AddCoursePage(webDriver);
        Assert.assertTrue(addCoursePage.getTitle().contains("Add Course"));
    }

    @Test
    void FFOAddDummyCourseData() {
        traningPage.goToAddCoursePage();
        addCoursePage = new AddCoursePage(webDriver);
        addCoursePage.addDummyCourseData();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void goToMainPAge(){
        homePage.goToTrainingPage();
    }





}
