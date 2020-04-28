package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class TestBase {
    public static WebDriver webDriver;
    //protected LoginPage loginPage;
    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browser){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            webDriver= new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            webDriver= new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.disableNativeEvents();
            webDriver= new InternetExplorerDriver(options);
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS); // Wait for 120 seconds
        webDriver.get("https://circlesqc.bnsights.com/");
        //loginPage = new LoginPage(webDriver);
    }



    @AfterSuite
    public void stopDriver(){
        webDriver.quit();
    }



}
