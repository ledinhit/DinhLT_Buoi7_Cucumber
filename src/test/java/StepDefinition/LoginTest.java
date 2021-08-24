package StepDefinition;

import base.BaseSetupCucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;


public class LoginTest extends BaseSetupCucumber {
    private WebDriver driver;
    private LoginPage login;

    @Given("Open the Chrome and launch the application")
    public void openTheChromeAndLaunchTheApplication() {
        beforeClass();
    }

    @And("Set the variables for the Login function")
    public void setTheVariablesForTheLoginFunction() {
        driver = getDriver();
        login = new LoginPage(driver);
    }

    @When("Enter the Username and Password")
    public void enterTheUsernameAndPassword() {
        login.enterUsername("0978871423");
        login.enterPassword("dinh@123");

    }

    @Then("Login successfully")
    public void loginSuccessfully() throws InterruptedException {
        login.clickLogin();
        afterClass();
    }

}
