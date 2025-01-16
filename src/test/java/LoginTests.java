import Utils.SetUp;
import Utils.TestDataProvider;
import org.testng.annotations.Test;


public class LoginTests extends SetUp {


    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void testUserCanLoginWithValidUserCredentials(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.clickLoginButton();
        myAccountSteps.checkThatMyAccountContentIsPresented();
        myAccountSteps.checkThatMyAccountContentIsPresented();
        myAccountSteps.clickLogout();
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = TestDataProvider.class)
    public void TestUserCantLoginWithInvalidUsername(String email, String password){
        homePageSteps.goToMyAccount();
        loginPageSteps.setLoginUserName(email);
        loginPageSteps.setLoginPassword(password);
        loginPageSteps.clickLoginButton();
        loginPageSteps.checkWrongEmailFlashIsPresented();
    }

}
