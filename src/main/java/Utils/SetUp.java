package Utils;

import Actions.HomePageSteps;
import Actions.LoginPageSteps;
import Actions.MyAccountSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class SetUp {

    private static final Logger log = LoggerFactory.getLogger(SetUp.class);
    public WebDriver driver;
    public LoginPageSteps loginPageSteps;
    public MyAccountSteps myAccountSteps;
    public HomePageSteps homePageSteps;

    @BeforeClass
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.get("https://practice.automationtesting.in/my-account/");
        driver.manage().window().maximize();

        loginPageSteps = new LoginPageSteps(driver);
        myAccountSteps = new MyAccountSteps(driver);
        homePageSteps = new HomePageSteps(driver);
        log.info("Browser opened and steps initialized.");
    }


    @AfterClass
    public void closeBrowser(){
        driver.close();
        log.info("Browser closed.");
    }

    public void goBack(){
        driver.navigate().back();
    }

}
