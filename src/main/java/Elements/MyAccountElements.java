package Elements;

import org.openqa.selenium.By;

public class MyAccountElements {

    public By
    myAccountContent = By.className("woocommerce-MyAccount-content"),
    myAccountNavigator = By.className("woocommerce-MyAccount-navigation"),
    logoutLink = By.xpath("//a[contains(text(), 'Logout')]");
}
