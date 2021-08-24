package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseSetupCucumber {
    private WebDriver driver = null;
    private Actions action = null;
    private WebDriverWait wait = null;
    static String appURL = "https://tester-sapo-4.mysapogo.com";

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public Actions getAction() {
        return action;
    }

    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }
}
