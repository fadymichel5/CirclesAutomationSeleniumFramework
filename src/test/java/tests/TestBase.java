package tests;

import helpers.TestHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class TestBase {
    public static WebDriver webDriver;
    String fadyITFFOUSER_mail ="fady.michel6@gmail.com";
    String fadyITFFOUSER_pass = "P@ssw0rdd";

    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browser){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("start-maximized");
            options.addArguments("--disable-extensions");
            //options.addArguments("--auto-open-devtools-for-tabs");
            webDriver= new ChromeDriver(options);
        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            webDriver= new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.disableNativeEvents();
            webDriver= new InternetExplorerDriver(options);
        }

        //webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Wait for 30 seconds
        webDriver.get("https://circlesqc.bnsights.com/");
        //loginPage = new LoginPage(webDriver);
    }



    @AfterSuite
    public void stopDriver(){
        webDriver.quit();
    }


    @AfterMethod
    public void analyzeLog(){
        System.out.println("Analyze the log after the test case");
        TestHelper.analyzeLog(webDriver);
    }

}
