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

    @Given("Set up variable for Order")
    public void setUpVariableForOrder() {
        beforeClass();
        driver = getDriver();
        login = new LoginPage(driver);
        order = new OrderPage(driver);
    }

    @And("Login")
    public void login() {
        login.Login("0978871423", "dinh@123");
    }

    @When("Select Order in Lest menu")
    public void selectOrderInLestMenu() {
        order.clickMenuOrder();
    }

    @And("Select create Order")
    public void selectCreateOrder() {
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

    @Then("verify product name and sku in new order")
    public void verifyProductNameAndSkuInNewOrder() {
        order.verifyNameProductInOrder();
        order.verifySkuProductInOrder();
    }

    @And("Close Browser - Order")
    public void closeBrowserOrder() throws InterruptedException {
        afterClass();
    }

}
