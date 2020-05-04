package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SwitchRolePage;

public class LoginTests extends TestBase {
    HomePage homePage;
    LoginPage loginPage;

    String fadyITFFOUSER_mail ="fady.michel6@gmail.com";
    String fadyITFFOUSER_pass = "P@ssw0rdd";


    private void sureThatUserLogoutAsFFO(){
        loginPage=new LoginPage(webDriver);
        loginPage.loginWithEmailAndPass(fadyITFFOUSER_mail,fadyITFFOUSER_pass);
        homePage=new HomePage(webDriver);
        homePage.goToSwitchRolePage();
        SwitchRolePage switchRolePage = new SwitchRolePage(webDriver);
        switchRolePage.switchToFFO();
        homePage.LogoutFromAccount();
    }



    @Test
    public void userCanLoginAsFFO(){
        sureThatUserLogoutAsFFO();
        loginPage=new LoginPage(webDriver);
        loginPage.loginWithEmailAndPass(fadyITFFOUSER_mail,fadyITFFOUSER_pass);
        homePage=new HomePage(webDriver);
        System.out.println("Home Icons (As FFO) is " + homePage.mainMenuIcons.size());
        Assert.assertTrue(homePage.mainMenuIcons.get(3).getText().equals("Future Jobs"));
        homePage.LogoutFromAccount();
    }


    public void sureThatUserLogoutAsUser(){

        loginPage=new LoginPage(webDriver);
        loginPage.loginWithEmailAndPass(fadyITFFOUSER_mail,fadyITFFOUSER_pass);
        homePage=new HomePage(webDriver);
        homePage.goToSwitchRolePage();
        SwitchRolePage switchRolePage = new SwitchRolePage(webDriver);
        switchRolePage.switchUser();
        homePage.LogoutFromAccount();
    }



    @Test( enabled=true )
    public void userCanLoginAsUser(){
        sureThatUserLogoutAsUser();
        loginPage=new LoginPage(webDriver);
        loginPage.loginWithEmailAndPass("fady.michel6@gmail.com","P@ssw0rdd");
        homePage=new HomePage(webDriver);
        //Assert.assertEquals(homePage.ToolBoxButton.getText(),"Toolbox");
        System.out.println("Home Icons (As User) is " + homePage.mainMenuIcons.size());
        Assert.assertFalse(homePage.mainMenuIcons.get(3).getText().equals("Future Jobs"));
        homePage.LogoutFromAccount();
    }



}
