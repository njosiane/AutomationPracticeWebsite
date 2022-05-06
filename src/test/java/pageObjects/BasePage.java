package pageObjects;

import commons.DriverManager;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Random;

import static stepDefinitions.Hooks.driver;

public class BasePage extends DriverManager {

    public String BaseUrl = "http://automationpractice.com/index.php";

    public void navigateToHomepage() {
        driver.navigate().to(BaseUrl);
    }

    public void scrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
    }

}
