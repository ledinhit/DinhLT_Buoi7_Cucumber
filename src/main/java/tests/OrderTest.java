package tests;

import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.OrderPage;

public class OrderTest extends BaseSetup {
    private WebDriver driver;
    public LoginPage login;
    public OrderPage order;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Test
    public void createOrderSuccess() throws InterruptedException {
        login = new LoginPage(driver);
        order = new OrderPage(driver);
        login.Login("0978871423", "dinh@123");
        order.createOrder();
    }

}
