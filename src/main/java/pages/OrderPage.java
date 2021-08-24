package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class OrderPage {
    private WebDriver driver;
    @FindBy(xpath = "//span[contains(text(),'Đơn hàng')]")
    private WebElement menuOrder;
    @FindBy(xpath = "//a[@href='/admin/orders/create']")
    private WebElement creatOrder;
    @FindBy(xpath = "//input[@id='search-customer']")
    private WebElement searchCustomer;
    @FindBy(xpath = "//input[@id='search-product']")
    private WebElement searchProduct;
    private By customer = By.xpath("//div[starts-with(@id,'item-suggest-customers')]");
    @FindBy(xpath = "//p[contains(text(),'Thêm mới sản phẩm')]")
    private WebElement newProd;
    @FindBy(id = "Name")
    private WebElement nameProd;
    @FindBy(id = "sku")
    private WebElement skuProd;
    private By priceProd = By.xpath("//div[@id='sapo-modal-container']//input[@context = 'numberInput']");
    @FindBy(xpath = "//a[@id='btn-create-product']")
    private WebElement btnCreateProd;
    @FindBy(xpath = "//div[@id='content']/div[1]//a[contains(text(),'Tạo đơn và duyệt (F1)')]")
    private WebElement btnCreateOrder;
    @FindBy(xpath = "//tbody[@id='line_item_rows']/tr/td[2]/div/span")
    private WebElement orderLineItemProductName;
    @FindBy(xpath = "//tbody[@id='line_item_rows']/tr[1]/td[1]")
    private WebElement orderLineItemProductSku;
    @FindBy(xpath = "//tbody[@id='line_item_rows']/tr[1]/td[4]")
    private WebElement orderLineItemProductPrice;
    public int randomNum = ThreadLocalRandom.current().nextInt(0, 1000);

    public String dataName = "Sản phảm test " + randomNum;
    public String dataSKU = "sku-" + randomNum;
    public String dataPrice = "50000";

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }


    // Click menu order
    public void clickMenuOrder() {
        menuOrder.click();
    }

    // Click create order
    public void clickCreatOrder() {
        creatOrder.click();
    }

    // Search customer
    public void clickInputSearchCustomer() {
        searchCustomer.click();
    }

    // Lấy ra danh sách khách hàng và chọn khách hàng đầu tiên
    public void selectFirstCustomer() {
        List<WebElement> listCustomer = driver.findElements(customer);
        listCustomer.get(0).click();
    }

    // Click input search product
    public void clickInputSearchProduct() {
        searchProduct.click();
    }

    // Chọn tạo sản phẩm
    public void selectCreateProduct() {
        newProd.click();
    }

    // Enter name product
    public void enterNameProduct(String name) {
        Assert.assertTrue(nameProd.isDisplayed(), "Input Tên sản phẩm không hiển thị");
        nameProd.sendKeys(name);
    }

    // Enter SKU product
    public void enterSkuProduct(String sku) {
        Assert.assertTrue(skuProd.isDisplayed(), "Input Sku không hiển thị");
        skuProd.sendKeys(sku);
    }

    // Nhập giá bán lẻ
    public void enterPriceProduct(String price) {
        List<WebElement> priceProduct = driver.findElements(priceProd);
        Assert.assertTrue(priceProduct.get(0).isDisplayed(), "Input Giá bán lẻ không hiển thị");
        priceProduct.get(0).sendKeys(price);
    }

    // Click button save product
    public void clickBtnSaveProduct() {
        btnCreateProd.click();
    }

    // Click button save Order
    public void clickBtnSaveOrder() {
        btnCreateOrder.click();
    }

    // get product name in order
    public String getTextProductNameInOrder() {
        return orderLineItemProductName.getText();
    }

    // get product sku in order
    public String getTextProductSkuInOrder() {
        return orderLineItemProductSku.getText();
    }

    //verify name product in new order
    public void verifyNameProductInOrder() {
        Assert.assertEquals(getTextProductNameInOrder(), dataName);
    }

    // verify SKU product in new order
    public void verifySkuProductInOrder() {
        Assert.assertEquals(getTextProductSkuInOrder(), dataSKU);
    }

    public void createProduct(String name, String sku, String price) {
        enterNameProduct(name);
        enterSkuProduct(sku);
        enterPriceProduct(price);
        clickBtnSaveProduct();
    }

    public void createOrder() throws InterruptedException {
        clickMenuOrder();
        clickCreatOrder();
        clickInputSearchCustomer();
        selectFirstCustomer();
        clickInputSearchProduct();
        selectCreateProduct();
        createProduct(dataName, dataSKU, dataPrice);
        clickBtnSaveOrder();
        Thread.sleep(1000);
        verifyNameProductInOrder();
        verifySkuProductInOrder();
    }

}
