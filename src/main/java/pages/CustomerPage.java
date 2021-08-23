package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.testng.Assert.assertEquals;

public class CustomerPage {
    private WebDriver driver;
    private Actions action = null;

    @FindBy(xpath = "//span[contains(text(),'Khách hàng')]")
    private WebElement menuCustomer;
    @FindBy(xpath = "//a[@href='/admin/customers']")
    private WebElement listCustomer;
    @FindBy(xpath = "//div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/button[1]/span[1]")
    private WebElement btnCreateCustomer;
    @FindBy(xpath = "//input[@placeholder='Nhập tên khách hàng']")
    private WebElement nameCustomer;
    @FindBy(xpath = "//input[@placeholder='Nhập mã khách hàng']")
    private WebElement codeCustomer;
    @FindBy(xpath = "//input[@placeholder='Nhập số điện thoại']")
    private WebElement phoneCustomer;
    @FindBy(xpath = "//input[@placeholder='Nhập địa chỉ email']")
    private WebElement emailCustomer;
    @FindBy(xpath = "//input[@placeholder='Nhập địa chỉ']")
    private WebElement addressCustomer;
    @FindBy(xpath = "//p[contains(text(),'Chọn Tỉnh/Thành phố - Quận/Huyện')]")
    private WebElement dropdownDistrict;
    @FindBy(xpath = "//p[contains(text(),'Chọn Phường/Xã')]")
    private WebElement dropdownWard;
    @FindBy(xpath = "//input[@placeholder='Tìm kiếm khu vực']")
    private WebElement searchDistrictTxtBox;
    @FindBy(xpath = "//input[@placeholder='Tìm kiếm phường xã']")
    private WebElement searchWardTxtBox;
    private By listDistrictAndWard = By.cssSelector("div[class$='menuItem']");
    @FindBy(xpath = "//span[contains(text(),'Theo khách hàng')]")
    private WebElement radioSelectCustomer;
    @FindBy(xpath = "//span[contains(text(),'Lưu')]")
    private WebElement btnSever;
    @FindBy(xpath = "//div[@class='MuiAlert-message']/p[@class='MuiTypography-root MuiTypography-body1']")
    private WebElement msgSuccess;
    @FindBy(xpath = "//div[contains(text(),'Chọn hình thức thanh toán')]")
    WebElement dropdownPayment;
    @FindBy(xpath = "//body/div[@id='menu-']/div[3]/ul/li[5]")
    WebElement cod;
    private By listPayment = By.xpath("//body/div[@id='menu-']/div[3]/ul/li");
    public int randomNum = ThreadLocalRandom.current().nextInt(0, 1000);
    public int randomNumForPhone = ThreadLocalRandom.current().nextInt(0, 9);

    public CustomerPage(WebDriver driver, Actions action) {
        this.driver = driver;
        this.action = action;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    // Click khách hàng ở menu
    public void clickMenuCustomer() {
        menuCustomer.click();
    }

    // Click Danh sách khách hàng ở menu
    public void clickListCustomer() {
        listCustomer.click();
    }

    // Click button Tạo Khách hàng
    public void clickButtonCreateCustomer() {
        btnCreateCustomer.click();
    }

    //Method to enter name
    public void enterNameCustomer(String name) {
        Assert.assertTrue(nameCustomer.isDisplayed(), "Input Tên khách hàng không hiển thị");
        action.sendKeys(nameCustomer, name).build().perform();
    }

    //Method to enter code
    public void enterCodeCustomer(String code) {
        Assert.assertTrue(codeCustomer.isDisplayed(), "Input mã khách hàng không hiển thị");
        action.sendKeys(codeCustomer, code).build().perform();
    }

    //Method to enter phone
    public void enterPhoneCustomer(String phone) {
        Assert.assertTrue(phoneCustomer.isDisplayed(), "Input Số điện thoại không hiển thị");
        action.sendKeys(phoneCustomer, phone).build().perform();
    }

    //Method to enter Email
    public void enterEmailCustomer(String email) {
        Assert.assertTrue(emailCustomer.isDisplayed(), "Input email không hiển thị");
        action.sendKeys(emailCustomer, email).build().perform();
    }

    //Method to enter address
    public void enterAddressCustomer(String address) {
        Assert.assertTrue(addressCustomer.isDisplayed(), "Input email không hiển thị");
        action.sendKeys(addressCustomer, address).build().perform();
    }

    //Cick dropdown District
    public void clickDropdownDistrict() {
        dropdownDistrict.click();
    }

    //Search District
    public void searchDistrict(String key) {
        Assert.assertTrue(searchDistrictTxtBox.isDisplayed(), "Input Tìm kiếm khu vực không hiển thị");
        action.sendKeys(searchDistrictTxtBox, key).build().perform();
    }

    //Select District
    public void selectDistrict() {
        List<WebElement> listDistrict = driver.findElements(listDistrictAndWard);
        listDistrict.get(0).click();
    }

    //Cick dropdown Ward
    public void clickDropdownWard() {
        dropdownWard.click();
    }

    //Search Ward
    public void searchWard(String key) {
        Assert.assertTrue(searchWardTxtBox.isDisplayed(), "Input Tìm kiếm phường xã không hiển thị");
        action.sendKeys(searchWardTxtBox, key).build().perform();
    }

    //Select Ward
    public void selectWard() {
        List<WebElement> listWard = driver.findElements(listDistrictAndWard);
        listWard.get(0).click();
    }

    //Kiểm tra xem radio áp dụng ưu đãi
    public void checkAndSelectRadio() {

        if (radioSelectCustomer.isSelected() == false) {
            System.out.println("Chưa chọn radio áp dụng ưu đãi: Theo khách hàng");
            radioSelectCustomer.click();
        } else {
            System.out.println("Đã chọn radio áp dụng ưu đãi: Theo khách hàng");
        }
    }

    //Click button Save
    public void clickBtnSave() {
        btnSever.click();
    }

    // Verify messenger create customer success
    public void verifyMessCreateCustomerSuccess() {
        assertEquals(msgSuccess.getText(), "Thêm mới khách hàng thành công");
    }

    //Click dropdown payment
    public void clickDropdownPayment() {
        dropdownPayment.click();
    }

    //Select payment
    public void selectPayment() {
        cod.click();
    }

    public void createCustomer(String name, String code, String phone, String email, String address, String keyDistrict, String keyWard) throws InterruptedException {
        clickMenuCustomer();
        clickListCustomer();
        clickButtonCreateCustomer();
        enterNameCustomer(name);
        enterCodeCustomer(code);
        enterPhoneCustomer(phone);
        enterEmailCustomer(email);
        enterAddressCustomer(address);
        clickDropdownDistrict();
        searchDistrict(keyDistrict);
        Thread.sleep(1000);
        selectDistrict();
        clickDropdownWard();
        searchWard(keyWard);
        Thread.sleep(1000);
        selectWard();
        checkAndSelectRadio();
        clickDropdownPayment();
        Thread.sleep(1000);
        selectPayment();
        clickBtnSave();
        Thread.sleep(2000);
        verifyMessCreateCustomerSuccess();

    }

}
