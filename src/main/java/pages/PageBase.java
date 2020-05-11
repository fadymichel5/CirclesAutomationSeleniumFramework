package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;


public class PageBase {

    protected   WebDriver webDriver;

    //The constructor
    public PageBase(WebDriver webDriver ) {
        //System.out.println(webDriver);
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);
    }

    protected void hoverButton(WebElement webElement){
        //System.out.println(webDriver);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).perform();
    }

    protected void pressEnter(WebElement webElement){
        webElement.sendKeys(Keys.ENTER);
    }

    protected void zoomIn(WebElement webElement) {
        webElement.sendKeys(Keys.chord(Keys.CONTROL,Keys.ADD));
    }



    protected static void clickButton(WebElement webElement){
        webElement.click();
    }

    protected static void typeInTextBox(WebElement webElement,String string){
        webElement.sendKeys(string);
    }
}
