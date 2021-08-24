package StepDefinition;

import base.BaseSetupCucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.OrderPage;


public class OrderTest extends BaseSetupCucumber {
    private WebDriver driver;
    public LoginPage login;
    public OrderPage order;

    @Given("Open the Chrome and launch the application \\(Order)")
    public void openTheChromeAndLaunchTheApplicationOrder() {
        beforeClass();
    }

    @And("Set the variables for the Create Order function")
    public void setTheVariablesForTheCreateOrderFunction() {
        driver = getDriver();
        login = new LoginPage(driver);
        order = new OrderPage(driver);
    }

    @And("Login")
    public void login() {
        login.Login("0978871423", "dinh@123");
    }

    @When("Select Order in the left menu")
    public void selectOrderInTheLeftMenu() {
        order.clickMenuOrder();
    }

    @And("Select create Order and delivery")
    public void selectCreateOrderAndDelivery() {
        order.clickCreatOrder();
    }

    @And("Select customer")
    public void selectCustomer() {
        order.clickInputSearchCustomer();
        order.selectFirstCustomer();
    }

    @And("Create new product")
    public void createNewProduct() {
        order.clickInputSearchProduct();
        order.selectCreateProduct();
        order.createProduct(order.dataName, order.dataSKU, order.dataPrice);
    }

    @And("Click button Save Order")
    public void clickButtonSaveOrder() throws InterruptedException {
        order.clickBtnSaveOrder();
        Thread.sleep(1000);
    }


    @Then("Create order successfully")
    public void createOrderSuccessfully() throws InterruptedException {
        order.verifyNameProductInOrder();
        order.verifySkuProductInOrder();
        afterClass();
    }
}
