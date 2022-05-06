package commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;


public class BrowserManager extends DriverManager {

    private WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    //to run without opening Chrome browser
    private WebDriver initChromeHeadless() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-gpu", "--headless");
        return new ChromeDriver(options);
    }

    //to run without opening Firefox browser
    private WebDriver initFirefoxHeadless() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("disable-gpu", "--headless");
        return new FirefoxDriver(options);
    }

    //to choose which browser to run the test with
    public void launchBrowser(String browser) {
        switch (browser) {

            case "Firefox":
                driver = initFirefoxDriver();
                break;

            case "ChromeHeadless":
                driver = initChromeHeadless();
                break;

            case "FirefoxHeadless":
                driver = initFirefoxHeadless();
                break;

            default: // default browser if none specified
                driver = initChromeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //wait for 10s
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15)); //when page takes time to load
    }

    public void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
