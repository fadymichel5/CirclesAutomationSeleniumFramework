package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
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

    @FindBy(xpath = "//ul[@class='kt-menu__nav main-nav brand-svg-menu-icon-fill']/li")
    public List<WebElement> mainMenuIcons ;


    public void clickLogout() {clickButton(logoutButton);}

    public void clickSwitchRole(){
        clickButton(switchRoleButton);
    }

    public void clickTopIconMenu(){
        clickButton(profileTopIcon);
    }

    public void LogoutFromAccount() {
        clickTopIconMenu();
        clickLogout();
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }





}
