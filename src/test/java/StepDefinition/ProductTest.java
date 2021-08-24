package StepDefinition;

import base.BaseSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CustomerPage;
import pages.LoginPage;
import pages.ProductPage;

public class ProductTest extends BaseSetup {
    private WebDriver driver;
    private WebDriverWait wait;
    public LoginPage login;
    public ProductPage product;

    @Given("Set up variable for product")
    public void setUpVariableForProduct() {
        beforeClass();
        driver = getDriver();
        wait = getWait();
        login = new LoginPage(driver);
        product = new ProductPage(driver, wait);
    }

    @And("Login to site \\(product)")
    public void loginToSiteProduct() {
        login.Login("0978871423", "dinh@123");
    }

    @When("Select Product in Lest menu")
    public void selectProductInLestMenu() {
        product.selectProduct();

    }

    @And("Select List Product")
    public void selectListProduct() {
        product.selectListProduct();
    }

    @And("Click button create product")
    public void clickButtonCreateProduct() throws InterruptedException {
        product.clickBtnCreateProduct();
        Thread.sleep(1000);
    }

    @And("Enter product information")
    public void enterProductInformation() throws InterruptedException {
        product.enterProductName("Sản phẩm test "+product.randomNum);
        product.enterProductSku("SKU-"+product.randomNum);
        product.enterProductBarcode("Barcode- "+product.randomNum);
        product.enterProductWeight("1000");
        product.enterProductRetailPrice("100000");
        product.enterProductWholesalePrice("90000");
        product.enterProductCost("70000");
        product.enterProductUnit("Thùng");
        Thread.sleep(1000);
        product.enterProductInventory("100");
    }

    @And("Click button Save Product")
    public void clickButtonSaveProduct() throws InterruptedException {
        product.clickBtnSaveProduct();
    }

    @Then("verify success message create product")
    public void verifySuccessMessageCreateProduct() {
        product.verifyNotiMessage();
    }

    @And("Close Browser \\(product)")
    public void closeBrowserProduct() throws InterruptedException {
        afterClass();
    }

}
