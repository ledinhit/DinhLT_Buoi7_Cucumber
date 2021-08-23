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

    //Data test tạo sản phẩm
    String dataName = "Sản phảm test " + randomNum;
    String dataSKU = "sku-" + randomNum;
    String dataPrice = "50000";

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

//    public void createOrderSuccess() {
//
//        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//span[contains(text(),'Đơn hàng')]")).click();
//        WebElement creatOrder = driver.findElement(By.xpath("//a[@href='/admin/orders/create']"));
//        creatOrder.click();
//
//        WebElement customer = driver.findElement(By.xpath("//input[@id='search-customer']"));
//        customer.click();
//
//        // Lấy ra danh sách khách hàng và chọn khách hàng đầu tiên
//        List<WebElement> listCustomer = driver.findElements(By.xpath("//div[starts-with(@id,'item-suggest-customers')]"));
//        listCustomer.get(0).click();
//        WebElement product = driver.findElement(By.xpath("//input[@id='search-product']"));
//        product.click();
//        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//        WebElement newProd = driver.findElement(By.xpath("//p[contains(text(),'Thêm mới sản phẩm')]"));
//        newProd.click();
//
//        int randomNum = ThreadLocalRandom.current().nextInt(999, 2000);
//        System.out.println(randomNum);
//        //Data test tạo sản phẩm
//        String dataName = "Sản phảm test " + randomNum;
//        String dataSKU = "sku-" + randomNum;
//        String dataPrice = "50000";
//
//        //Tạo sản phẩm mới
//        WebElement nameProd = driver.findElement(By.xpath("//input[@id='Name']"));
//        nameProd.sendKeys(dataName);
//        WebElement skuProd = driver.findElement(By.xpath("//input[@id='sku']"));
//        skuProd.sendKeys(dataSKU);
//        List<WebElement> priceProd = driver.findElements(By.xpath("//div[@id='sapo-modal-container']//input[@context = 'numberInput']"));
//        priceProd.get(0).sendKeys(dataPrice);
//        WebElement btnCreateProd = driver.findElement(By.xpath("//a[@id='btn-create-product']"));
//        btnCreateProd.click();
//
//        //Bấm tạo đơn
//        WebElement btnCreateOrder = driver.findElement(By.xpath("//div[@id='content']/div[1]//a[contains(text(),'Tạo đơn và duyệt (F1)')]"));
//        btnCreateOrder.click();
//
//        List<WebElement> orderLineItem = driver.findElements(By.xpath("//tbody[@id='line_item_rows']/tr/td"));
//        String sku = orderLineItem.get(0).getText();
////        assertEquals(sku, dataSKU);
//        String name = driver.findElement(By.xpath("//tbody[@id='line_item_rows']/tr/td[2]/div/span")).getText();
////        assertEquals(name, dataName);
//    }
//
//
//    public void createOrderFail() throws InterruptedException {
//
//        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//
//        //Tắt popup quảng cáo khi mới đăng nhập thành công ( bỏ comment nếu chạy có popup)
//        //driver.getWindowHandle();
//        //driver.findElement(By.xpath("//span[@class='button-close-dialog']")).click();
//
//        driver.findElement(By.xpath("//span[contains(text(),'Đơn hàng')]")).click();
//        WebElement creatOrder = driver.findElement(By.xpath("//a[@href='/admin/orders/create']"));
//        creatOrder.click();
//
//        WebElement customer = driver.findElement(By.xpath("//input[@id='search-customer']"));
//        customer.click();
//
//        // Lấy ra danh sách khách hàng và chọn khách hàng đầu tiên
//        List<WebElement> listCustomer = driver.findElements(By.xpath("//div[starts-with(@id,'item-suggest-customers')]"));
//        listCustomer.get(0).click();
//
//        //Bấm tạo đơn
//        WebElement btnCreateOrder = driver.findElement(By.xpath("//div[@id='content']/div[1]//a[contains(text(),'Tạo đơn và duyệt (F1)')]"));
//        btnCreateOrder.click();
//        Thread.sleep(1000);
//        String noti = driver.findElement(By.xpath("//span[@class='ajax-notification-message']")).getText();
//        System.out.println(noti);
//        assertEquals(noti, "Vui lòng chọn sản phẩm vào đơn hàng!");
//
//    }
}
