package tests;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SwitchRolePage;
import pages.TraningPage;

import java.awt.*;

public class TraningTests extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    TraningPage traningPage;

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
    public void usergobacktohomefromtraning(){

        webDriver.navigate().back();
        Assert.assertTrue(homePage.MostRecentInitiatives.isDisplayed());


    }

    @Test void changefromCatViewToCoursesView(){
        traningPage.changeBrowseByView();
        Assert.assertTrue(traningPage.addCourseButton.isDisplayed());
    }

    @AfterMethod
    public void goToMainPAge(){
        homePage.goToTrainingPage();
    }





}
