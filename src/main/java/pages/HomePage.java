package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends PageBase {


    @FindBy(tagName = "html")
    WebElement body;

    @FindBy(xpath = "//div[@class='kt-header__topbar-user']")
    public WebElement profileTopIconAdminView;

    @FindBy(xpath = "//div[@class='kt-header__topbar-item kt-header__topbar-item--user']/div/div/img")
    public WebElement profileTopIcon;

    @FindBy(xpath = "//a[@href='/Home/PermissionSet']")
    public WebElement switchRoleButton;

    @FindBy(id = "btn-logOut")
    public WebElement logoutButton;

    @FindBy(xpath = "//a[@href=\'/FFO/Training/Index\']")
    public WebElement TraningLink;

    @FindBy(xpath = "//ul[@class='kt-menu__nav main-nav brand-svg-menu-icon-fill']/*[not(self::li[@id])]/a/span")
    public List<WebElement> mainMenuIcons;

    @FindBy(id = "autoNavMore")
    WebElement autoMoreButton;

    @FindBy(xpath = "//*[@id=\"kt_content\"]/div/div[6]/div/div[1]/div/h3")
    public WebElement MostRecentInitiatives;


    private void clickLogout() {
        clickButton(logoutButton);
    }

    private void clickSwitchRole() {
        clickButton(switchRoleButton);
    }

    private void clickTopIconMenu() {
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

    public void goToTrainingPage() {

        for (WebElement icon : mainMenuIcons) {
            if (icon.getText().contains("Training")) {
                clickButton(icon);
                return;
            }
        }
        webDriver.get("https://circlesqc.bnsights.com/FFO/Training");
    }


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }


}
