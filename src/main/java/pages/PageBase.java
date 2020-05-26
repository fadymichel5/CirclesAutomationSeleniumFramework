package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {

    protected   WebDriver webDriver;

    //The constructor
    public PageBase(WebDriver webDriver ) {
        //System.out.println(webDriver);
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);
    }

    protected void hoverButton(WebElement webElement){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).perform();
    }

    protected void pressEnter(WebElement webElement){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(Keys.ENTER);
    }


    protected void clickButton(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    protected void typeInTextBox(WebElement webElement, String string) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 5);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(string);
    }
}
