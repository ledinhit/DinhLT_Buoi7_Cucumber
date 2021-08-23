package tests;

import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class ProductTest extends BaseSetup {
    private WebDriver driver;
    private WebDriverWait wait;
    public LoginPage login;
    public ProductPage product;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
        wait = getWait();
    }


    @Test
    public void createProductSuccess() throws InterruptedException {
        login = new LoginPage(driver);
        product = new ProductPage(driver, wait);
        login.Login("0978871423", "dinh@123");
        product.createProduct("Sản phẩm test "+product.randomNum,
                "SKU-"+product.randomNum,
                "Barcode- "+product.randomNum,
                "4000",
                "100000",
                "90000",
                "70000",
                "100",
                "Thùng");
    }
}
