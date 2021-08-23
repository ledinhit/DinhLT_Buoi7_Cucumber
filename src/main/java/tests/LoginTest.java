package tests;

import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseSetup {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Test
    public void loginSuccess() {
        LoginPage login = new LoginPage(driver);
        login.Login("0978871423", "dinh@123");
    }
}
