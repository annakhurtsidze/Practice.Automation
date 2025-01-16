package Elements;

import org.openqa.selenium.By;

public class LoginElements {

    public By

    loginUsername = By.id("username"),

    loginPassword = By.id("password"),
    loginButton = By.xpath("//input[@name='login']"),

    wrongEmailFlash = By.xpath("//*[contains(text(), 'A user could not be found with this email address.')]");

}