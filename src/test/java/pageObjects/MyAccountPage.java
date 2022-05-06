package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    public MyAccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    private WebElement myAccountWelcomeMessage;

    @FindBy(xpath = "//a[@title='Information']")
    private WebElement myPersonalInformationButton;





    public boolean isMyAccountPageDisplayed() {
        String expectedMyAccountMessage = "Welcome to your account";
        String actualMyAccountMessage = myAccountWelcomeMessage.getText();
        System.out.println("Welcome message : " + actualMyAccountMessage);
        return actualMyAccountMessage.contains(expectedMyAccountMessage);
    }

    public void clickMyPersonalInformation(){
        myPersonalInformationButton.click();
    }
}
