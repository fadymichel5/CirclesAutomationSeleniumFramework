package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

    private WebDriver webDriver;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailTextBox;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//button[@class='btn btn-pill kt-login__btn-primary-brand']")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void loginWithEmailAndPass(String Email,String pass){
        typeInTextBox(emailTextBox,"");
        typeInTextBox(passwordTextBox,"");
        typeInTextBox(emailTextBox,Email);
        typeInTextBox(passwordTextBox,pass);
        clickButton(loginButton);
    }

}
