package StepDefinition;

import base.BaseSetupCucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.CustomerPage;
import pages.LoginPage;

public class CustomerTest extends BaseSetupCucumber {
    private WebDriver driver;
    private Actions action;
    private CustomerPage customer;
    private LoginPage login;

    @Given("Set up")
    public void setUp() {
        beforeClass();
        driver = getDriver();
        action = getAction();
        customer = new CustomerPage(driver, action);
        login = new LoginPage(driver);
    }

    @And("Login to site")
    public void loginToSite() {
        login.Login("0978871423", "dinh@123");
    }

    @When("Select Customer in Lest menu")
    public void selectCustomerInLestMenu() {
        customer.clickMenuCustomer();
    }

    @And("Select List customers")
    public void selectListCustomers() {
        customer.clickListCustomer();
    }

    @And("Click button create customer")
    public void clickButtonCreateCustomer() {
        customer.clickButtonCreateCustomer();
    }

    @And("Enter customer information")
    public void enterCustomerInformation() throws InterruptedException {
        customer.enterNameCustomer("Khách hàng số " + customer.randomNum);
        customer.enterCodeCustomer("KH-" + customer.randomNum);
        customer.enterPhoneCustomer("097887131" + customer.randomNumForPhone);
        customer.enterEmailCustomer("dinhlt" + customer.randomNum + "@sapo.vn");
        customer.enterAddressCustomer("Địa chỉ test " + customer.randomNum);
        customer.clickDropdownDistrict();
        customer.searchDistrict("Cầu Giấy");
        Thread.sleep(1000);
        customer.selectDistrict();
        customer.clickDropdownWard();
        customer.searchWard("Quan Hoa");
        Thread.sleep(1000);
        customer.selectWard();
        customer.checkAndSelectRadio();
        customer.clickDropdownPayment();
        Thread.sleep(1000);
        customer.selectPayment();
    }

    @And("Click button Save Customer")
    public void clickButtonSaveCustomer() throws InterruptedException {
        customer.clickBtnSave();
        Thread.sleep(1000);
    }

    @Then("verify success message")
    public void verifySuccessMessage() {
        customer.verifyMessCreateCustomerSuccess();
    }

    @And("Close Browser")
    public void closeBrowser() throws InterruptedException {
        afterClass();
    }


}
