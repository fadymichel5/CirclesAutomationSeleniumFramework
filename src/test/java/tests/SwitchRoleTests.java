package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SwitchRolePage;

import java.util.concurrent.TimeUnit;

public class SwitchRoleTests extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    SwitchRolePage switchRolePage;

    @Test
    public void userCanSwitchFFO(){

        loginPage=new LoginPage(webDriver);
        loginPage.loginWithEmailAndPass("fady.michel6@gmail.com","P@ssw0rdd");
        homePage=new HomePage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS); // Wait for 120 seconds
        homePage.clickTopIconMenu();
        homePage.clickSwitchRole();
        switchRolePage = new SwitchRolePage(webDriver);
        switchRolePage.switchUser();
        //Assert.assertEquals(homePage.ToolBoxButton.getText(),"Toolbox");
    }
}
