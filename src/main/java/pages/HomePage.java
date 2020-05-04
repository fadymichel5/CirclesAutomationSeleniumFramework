package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends PageBase {

    private WebDriver webDriver;



    @FindBy(xpath = "//div[@class='kt-header__topbar-user']")
    public WebElement profileTopIconAdminView;

    @FindBy(xpath = "//div[@class='kt-header__topbar-item kt-header__topbar-item--user']/div/div/img")
    public WebElement profileTopIcon;

    @FindBy(xpath = "//a[@href='/Home/PermissionSet']")
    public WebElement switchRoleButton;

    @FindBy(id = "btn-logOut")
    public  WebElement logoutButton;

    @FindBy(xpath = "//ul[@class='kt-menu__nav main-nav brand-svg-menu-icon-fill']/*[not(self::li[@id])]/a/span")
    public List<WebElement> mainMenuIcons ;


    public void clickLogout() {clickButton(logoutButton);}

    private void clickSwitchRole(){
        clickButton(switchRoleButton);
    }

    private void clickTopIconMenu(){
        clickButton(profileTopIcon);
    }

    public void LogoutFromAccount() {
        clickTopIconMenu();
        clickLogout();
    }

    public void goToSwitchRolePage() {
        clickTopIconMenu();
        clickSwitchRole();
    }

    public void goToTrainingPage(){
        //clickButton(mainMenuIcons.get());
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }





}
