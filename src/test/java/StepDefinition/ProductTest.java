package StepDefinition;

import base.BaseSetupCucumber;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.ProductPage;


public class ProductTest extends BaseSetupCucumber {
    private WebDriver driver;
    private WebDriverWait wait;
    public LoginPage login;
    public ProductPage product;

    @Given("Open the Chrome and launch the application \\(Product)")
    public void openTheChromeAndLaunchTheApplicationProduct() {
        beforeClass();
    }

    @And("Set the variables for the Create Product function")
    public void setTheVariablesForTheCreateProductFunction() {
        driver = getDriver();
        wait = getWait();
        login = new LoginPage(driver);
        product = new ProductPage(driver, wait);
    }

    @And("Login to site \\(product)")
    public void loginToSiteProduct() {
        login.Login("0978871423", "dinh@123");
    }

    @When("Select Product in left menu")
    public void selectProductInLeftMenu() {
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

    @And("Enter product information \\(name, sku, barcode, weight, retailPrice, wholesalePrice, cost, inventory, unit)")
    public void enterProductInformationNameSkuBarcodeWeightRetailPriceWholesalePriceCostInventoryUnit() throws InterruptedException {
        product.enterProductName("Sản phẩm test " + product.randomNum);
        product.enterProductSku("SKU-" + product.randomNum);
        product.enterProductBarcode("Barcode- " + product.randomNum);
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

    @Then("Create product successfully")
    public void createProductSuccessfully() throws InterruptedException {
        product.verifyNotiMessage();
        afterClass();
    }
}
