import Utils.SetUp;
import Utils.TestDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class LoginTests extends SetUp {


    private static final Logger log = LoggerFactory.getLogger(LoginTests.class);

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void testUserCanLoginWithValidUserCredentials(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.clickLoginButton();
        myAccountSteps.checkThatMyAccountContentIsPresented();
        myAccountSteps.checkThatMyAccountNavigatorIsPresented();
        myAccountSteps.clickLogout();
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = TestDataProvider.class)
    public void testUserCantLoginWithInvalidUsername(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.clickLoginButton();
        loginPageSteps.checkWrongEmailFlashIsPresented();
    }

    @Test(dataProvider = "emptyPasswordData", dataProviderClass = TestDataProvider.class)
    public void testUserCantLoginWithoutPassword(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.clickLoginButton();
        loginPageSteps.checkPasswordRequiredFlashIsDisplayed();
    }

    @Test(dataProvider = "emptyEmailData", dataProviderClass = TestDataProvider.class)
    public void testUserCantLoginWithEmptyEmail(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.clickLoginButton();
        loginPageSteps.checkEmailRequiredFlashIsDisplayed();
    }

    @Test(dataProvider = "emptyEmailAndPasswordData", dataProviderClass = TestDataProvider.class)
    public void testUserCantLoginWithEmptyEmailAndPassword(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.clickLoginButton();
        loginPageSteps.checkEmailRequiredFlashIsDisplayed();
    }


    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void testThatPasswordIsMasked(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.checkThatPasswordIsMasked();
    }

}
