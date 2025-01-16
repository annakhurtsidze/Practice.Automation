import Utils.SetUp;
import Utils.TestDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


public class LoginTests extends SetUp {


    private static final Logger log = LoggerFactory.getLogger(LoginTests.class);

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class, priority = 1)
    public void testUserCanLoginWithValidUserCredentials(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.clickLoginButton();
        myAccountSteps.checkThatMyAccountContentIsPresented();
        myAccountSteps.checkThatMyAccountNavigatorIsPresented();
        myAccountSteps.clickLogout();
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = TestDataProvider.class, priority = 2)
    public void testUserCantLoginWithInvalidUsername(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.clickLoginButton();
        loginPageSteps.checkWrongEmailFlashIsPresented();
    }

    @Test(dataProvider = "emptyPasswordData", dataProviderClass = TestDataProvider.class, priority = 3)
    public void testUserCantLoginWithoutPassword(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.clickLoginButton();
        loginPageSteps.checkPasswordRequiredFlashIsDisplayed();
    }

    @Test(dataProvider = "emptyEmailData", dataProviderClass = TestDataProvider.class, priority = 4)
    public void testUserCantLoginWithEmptyEmail(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.clickLoginButton();
        loginPageSteps.checkEmailRequiredFlashIsDisplayed();
    }

    @Test(dataProvider = "emptyEmailAndPasswordData", dataProviderClass = TestDataProvider.class, priority = 5)
    public void testUserCantLoginWithEmptyEmailAndPassword(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.clickLoginButton();
        loginPageSteps.checkEmailRequiredFlashIsDisplayed();
    }


    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class, priority = 6)
    public void testThatPasswordIsMasked(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.checkThatPasswordIsMasked();
    }

    @Test(dataProvider = "caseSensitiveData", dataProviderClass = TestDataProvider.class, priority = 7)
    public void testLoginFailsWithCorrectCaseSensitiveCredentials(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.clickLoginButton();
        loginPageSteps.checkIncorrectPasswordFlashIsPresented();
    }

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class, priority = 8)
    public void testLoginAuthentication(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.clickLoginButton();
        myAccountSteps.clickLogout();
        goBack();
        loginPageSteps.checkThatLoginDivIsPresented();
    }

}
