package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.ThreadLocalRandom;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public int randomNum = ThreadLocalRandom.current().nextInt(1001, 1500);

    @FindBy(xpath = "//span[contains(text(),'Sản phẩm')]")
    private WebElement menuProduct;
    @FindBy(xpath = "//a[@href='/admin/products']")
    private WebElement listProduct;
    @FindBy(xpath = "//div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]/span[1]")
    private WebElement btnCreateProduct;
    @FindBy(xpath = "//input[@name = 'name']")
    private WebElement nameProd;
    @FindBy(xpath = "//input[@name ='sku']")
    private WebElement skuProd;
    @FindBy(xpath = "//input[@name ='barcode']")
    private WebElement barcodeProd;
    @FindBy(xpath = "//input[@name ='unit']")
    private WebElement unitProd;
    @FindBy(xpath = "//input[@name ='weight_value']")
    private WebElement weightProd;
    @FindBy(xpath = "//input[@name ='variant_price_sale.0.value']")
    private WebElement retailPrice;
    @FindBy(xpath = "//input[@name ='variant_price_sale.1.value']")
    private WebElement wholesalePrice;
    @FindBy(xpath = "//input[@name ='variant_price_import.0.value']")
    private WebElement cost;
    @FindBy(xpath = "//div/input[@name ='inventories.0.init_stock']")
    private WebElement inventoryProd;
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[2]/div[1]/button[3]/span[1]")
    private WebElement btnSaveProduct;
    @FindBy(xpath = "//div[@class='MuiAlert-message']/p[contains(text(),'Thêm sản phẩm thành công')]")
    private WebElement notify;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    // Click menu select product
    public void selectProduct() {
        menuProduct.click();
    }

    // Click menu select list product
    public void selectListProduct() {
        listProduct.click();
    }

    // Click menu select list product
    public void clickBtnCreateProduct() {
        btnCreateProduct.click();
    }

    //Method to enter product name
    public void enterProductName(String name) {
        Assert.assertTrue(nameProd.isDisplayed(), "Input Tên sản phẩm không hiển thị");
        nameProd.sendKeys(name);
    }

    //Method to enter product sku
    public void enterProductSku(String sku) {
        Assert.assertTrue(skuProd.isDisplayed(), "Input SKU không hiển thị");
        skuProd.sendKeys(sku);
    }

    //Method to enter product barcode
    public void enterProductBarcode(String barcode) {
        Assert.assertTrue(barcodeProd.isDisplayed(), "Input Barcode không hiển thị");
        barcodeProd.sendKeys(barcode);
    }

    //Method to enter product weight
    public void enterProductWeight(String weight) {
        Assert.assertTrue(weightProd.isDisplayed(), "Input Khối lượng không hiển thị");
        weightProd.sendKeys(weight);
    }

    //Method to enter product Retail price (giá bán lẻ)
    public void enterProductRetailPrice(String Price) {
        Assert.assertTrue(retailPrice.isDisplayed(), "Input Giá bán lẻ không hiển thị");
        retailPrice.sendKeys(Price);
    }

    //Method to enter product Wholesale price (giá bán buôn)
    public void enterProductWholesalePrice(String price) {
        Assert.assertTrue(wholesalePrice.isDisplayed(), "Input giá bán buôn không hiển thị");
        wholesalePrice.sendKeys(price);
    }

    //Method to enter product cost (giá nhập)
    public void enterProductCost(String price) {
        Assert.assertTrue(cost.isDisplayed(), "Input giá nhập không hiển thị");
        cost.sendKeys(price);
    }

    //Method to enter product inventory
    public void enterProductInventory(String inventory) {
        Assert.assertTrue(inventoryProd.isDisplayed(), "Input tồn kho ban đầu không hiển thị");
        inventoryProd.sendKeys(inventory);
    }

    //Method to enter product unit
    public void enterProductUnit(String unit) {
        Assert.assertTrue(unitProd.isDisplayed(), "Input đơn vị tính không hiển thị");
        unitProd.sendKeys(unit);
    }

    // Click button save product
    public void clickBtnSaveProduct() {
        btnSaveProduct.click();
    }

//    verify noti message
    public void verifyNotiMessage() {
        ExpectedCondition<WebElement> checkNoti = new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                try {
                    return notify;
                } catch (Exception e) {
                    return null;
                }
            }
        };
        wait.until(checkNoti);
    }

    //verify noti message use Assert testNG
    public void verifyNotiMessageUseAssertTestNG() {
        Assert.assertEquals(notify.getText(), "Thêm sản phẩm thành công");
    }

    // Method create product
    public void createProduct(String name, String sku, String barcode, String weight, String retailPrice, String wholesalePrice, String cost, String inventory, String unit) throws InterruptedException {
        selectProduct();
        selectListProduct();
        clickBtnCreateProduct();
        Thread.sleep(1000);
        enterProductName(name);
        enterProductSku(sku);
        enterProductBarcode(barcode);
        enterProductWeight(weight);
        enterProductRetailPrice(retailPrice);
        enterProductWholesalePrice(wholesalePrice);
        enterProductCost(cost);
        enterProductUnit(unit);
        Thread.sleep(1000);
        enterProductInventory(inventory);
        clickBtnSaveProduct();
        Thread.sleep(2000);
        verifyNotiMessage();
    }
}
