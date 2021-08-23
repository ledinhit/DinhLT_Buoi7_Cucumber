package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;
    @FindBy(id = "username")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(xpath = "//button[contains(text(),'Đăng nhập')]")
    private WebElement btnLogin;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Method to enter username
    public void enterUsername(String user) {
        Assert.assertTrue(username.isDisplayed(), "Input username không hiển thị");
        username.sendKeys(user);
    }

    //Method to enter password
    public void enterPassword(String pass) {
        Assert.assertTrue(password.isDisplayed(), "Input password không hiển thị");
        password.sendKeys(pass);
    }

    //Method to click on Login button
    public void clickLogin() {
        btnLogin.click();
    }

    public void Login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
}
