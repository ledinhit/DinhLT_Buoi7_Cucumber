package StepDefinition;

import base.BaseSetupCucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;


public class LoginTest extends BaseSetupCucumber {
    private WebDriver driver;
    private LoginPage login;

    @Given("Set up variable driver")
    public void setUpVariableDriver() {
        beforeClass();
        driver = getDriver();
        login = new LoginPage(driver);
    }

    @When("Enter the Username and Password")
    public void enterTheUsernameAndPassword() {
        login.enterUsername("0978871423");
        login.enterPassword("dinh@123");

    }

    @Then("Click button Login")
    public void clickButtonLogin() throws InterruptedException {
        login.clickLogin();
        afterClass();
    }
}
