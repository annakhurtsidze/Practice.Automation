package Actions;

import Elements.HomePageElements;
import org.openqa.selenium.WebDriver;

public class HomePageSteps extends HomePageElements {

    public WebDriver driver;

    public HomePageSteps(WebDriver driver1){
        this.driver=driver1;
    }

    public void goToMyAccount(){
        driver.findElement(myAccountLink).click();
    }
}
