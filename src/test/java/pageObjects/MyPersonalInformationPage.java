package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyPersonalInformationPage {

    public MyPersonalInformationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement accountInformationFirstName;

    @FindBy(xpath = "//*[@id=\"lastname\"]")
    private WebElement accountInformationLastName;

    @FindBy(xpath = "//*[@id=\"old_passwd\"]")
    private WebElement currentPassword;

    @FindBy(xpath = "//button[@name='submitIdentity']")
    private WebElement submitUpdate;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/p")
    private WebElement successfulUpdate;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/a")
    private WebElement backToAccount;

    @FindBy(xpath = "//*[contains(@title,'View my customer account')]")
    private WebElement accountNameOnHeader;


    public void enterNewFirstName(String newFirstName) {
        String oldName = accountNameOnHeader.getText();
        System.out.println("Old name : " + oldName);
        accountInformationFirstName.clear();
        accountInformationFirstName.sendKeys(newFirstName);
    }

    public void confirmCurrentPassword(String currentPsswrd){
        currentPassword.sendKeys(currentPsswrd);
    }

    public void clickSubmitUpdate(){
        submitUpdate.click();
    }

    public boolean isSuccessfulUpdateMessageDisplayed(){
        String expectedSuccessfulUpdateMessage = "Your personal information has been successfully updated.";
        String actualSuccessfulUpdateMessage = successfulUpdate.getText();
        System.out.println("Update message : " + actualSuccessfulUpdateMessage);
        return actualSuccessfulUpdateMessage.equals(expectedSuccessfulUpdateMessage);
    }

    public void clickBackToAccount(){
        backToAccount.click();
    }

    public boolean isFirstNameUpdated(){
        String expectedNewCustomerFullName = "James Jones";
        String actualNewCustomerFullName = accountNameOnHeader.getText();
        System.out.println("New name : " + actualNewCustomerFullName);
        return actualNewCustomerFullName.equals(expectedNewCustomerFullName);
    }


}
