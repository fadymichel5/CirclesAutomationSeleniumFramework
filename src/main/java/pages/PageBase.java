package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;


public class PageBase {

    protected static  WebDriver webDriver;

    //The constructor
    public PageBase(WebDriver webDriver ) {
        PageFactory.initElements(webDriver,this);
    }



    protected static void clickButton(WebElement webElement){
        webElement.click();
    }

    protected static void typeInTextBox(WebElement webElement,String string){
        webElement.sendKeys(string);
    }
}
