package Actions;

import Elements.MyAccountElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MyAccountSteps extends MyAccountElements {

    public WebDriver driver;
    public WebDriverWait wait;

    public MyAccountSteps(WebDriver driver1){
        this.driver=driver1;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void checkThatMyAccountContentIsPresented(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountContent));
        Assert.assertTrue(driver.findElement(myAccountContent).isDisplayed());
    }

    public void checkThatMyAccountNavigatorIsPresented(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountNavigator));
        Assert.assertTrue(driver.findElement(myAccountNavigator).isDisplayed());
    }

    public void clickLogout(){
        driver.findElement(logoutLink).click();
    }
}
