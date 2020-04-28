package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwitchRolePage extends PageBase {

    @FindBy(xpath = "//span[@class='filter-option pull-left']")
    public WebElement menuOfRoles;

    @FindBy(xpath = "//li[@data-original-index='0']")
    public WebElement itOption;

    @FindBy(xpath = "//li[@data-original-index='1']")
    public WebElement FFOOption;

    @FindBy(xpath = "//li[@data-original-index='2']")
    public WebElement userOption;

    @FindBy(xpath = "//button[@class='btn  brand_primary-btn custom_save-btn  btn-elevate ']")
    public WebElement saveButton;

    public SwitchRolePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void switchToIT(){
        clickButton(menuOfRoles);
        clickButton(itOption);
        clickButton(saveButton);
    }

    public void switchToFFO(){
        clickButton(menuOfRoles);
        clickButton(FFOOption);
        clickButton(saveButton);
    }

    public void switchUser(){
        clickButton(menuOfRoles);
        clickButton(userOption);
        clickButton(saveButton);
    }


}
