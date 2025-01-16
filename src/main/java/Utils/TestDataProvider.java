package Utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] provideLoginData() {
        return new Object[][]{
                {"test12@12.12", "test12@12.12"},
                {"test2@23.23", "test2@23.23"}
        };
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] provideInvalidLoginData() {
        return new Object[][]{
                // Only the invalid test case
                {"test2@23.fg", "test2@23.23"}
        };
    }
}
