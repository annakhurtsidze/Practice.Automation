package Actions;

import Elements.LoginElements;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.security.PublicKey;

public class LoginPageSteps extends LoginElements {

    public WebDriver driver;

    public LoginPageSteps(WebDriver driver1){
        this.driver=driver1;
    }

    public void setLoginUserName(String username){
        driver.findElement(loginUsername).sendKeys(username);
    }

    public void setLoginPassword(String password){
        driver.findElement(loginPassword).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public void checkWrongEmailFlashIsPresented(){
        Assert.assertTrue(driver.findElement(wrongEmailFlash).isDisplayed());
    }

    public void checkPasswordRequiredFlashIsDisplayed(){
        Assert.assertTrue(driver.findElement(passwordRequiredFlash).isDisplayed());
    }

    public void checkEmailRequiredFlashIsDisplayed(){
        Assert.assertTrue(driver.findElement(emailRequiredFlash).isDisplayed());
    }

    public  void checkThatPasswordIsMasked(){
        String enteredPasswordValue = driver.findElement(loginPassword).getAttribute("type");
        Assert.assertEquals(enteredPasswordValue, "password");
    }

    public void checkIncorrectPasswordFlashIsPresented(){
        Assert.assertTrue(driver.findElement(incorrectPasswordFlash).isDisplayed());
    }

    public void checkThatLoginDivIsPresented(){
        Assert.assertTrue(driver.findElement(loginDiv).isDisplayed());
    }
}
