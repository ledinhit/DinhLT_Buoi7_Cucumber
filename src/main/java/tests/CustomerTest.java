package tests;

import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CustomerPage;
import pages.LoginPage;

public class CustomerTest extends BaseSetup {
    private WebDriver driver;
    private Actions action;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        action = getAction();
    }

    @Test
    public void createCustomerSuccess() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        CustomerPage customer = new CustomerPage(driver, action);
        login.Login("0978871423", "dinh@123");
        customer.createCustomer(
                "Khách hàng số " + customer.randomNum,
                "KH-" + customer.randomNum,
                "097887142" + customer.randomNumForPhone,
                "dinhlt" + customer.randomNum + "@sapo.vn",
                "Địa chỉ test " + customer.randomNum,
                "Cầu Giấy",
                "Quan Hoa"
        );
    }
}
