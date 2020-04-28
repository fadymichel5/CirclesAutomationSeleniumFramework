package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SwitchRolePage;

public class TraningTests extends TestBase {

    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void userCanLoginAsUser(){
        sureThatUserLogoutAsUser();
        loginPage=new LoginPage(webDriver);
        loginPage.loginWithEmailAndPass("fady.michel6@gmail.com","P@ssw0rdd");
        homePage=new HomePage(webDriver);
        System.out.println("Home Icons (As User) is " + homePage.mainMenuIcons.size());
        Assert.assertEquals(homePage.mainMenuIcons.size(),12);
        homePage.clickTopIconMenu();
        homePage.clickLogout();
    }


    public void sureThatUserLogoutAsUser(){

        loginPage=new LoginPage(webDriver);
        loginPage.loginWithEmailAndPass("fady.michel6@gmail.com","P@ssw0rdd");
        homePage=new HomePage(webDriver);
        homePage.clickTopIconMenu();
        homePage.clickSwitchRole();
        SwitchRolePage switchRolePage = new SwitchRolePage(webDriver);
        switchRolePage.switchUser();
        homePage.clickTopIconMenu();
        homePage.clickLogout();
    }





}
