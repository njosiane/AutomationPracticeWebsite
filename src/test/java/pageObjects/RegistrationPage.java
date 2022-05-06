package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;





@SuppressWarnings("ALL")
public class RegistrationPage {

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"id_gender1\"]")
    private WebElement mrTitle;

    @FindBy(xpath = "//*[@id=\"id_gender2\"]")
    private WebElement mrsTitle;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;

    @FindBy(xpath = "//*[@id=\"customer_lastname\"]")
    private WebElement customerLastName;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement customerPassword;

    @FindBy(xpath = "//*[@id=\"days\"]")
    private WebElement dayOfBirth;

    @FindBy(xpath = "//*[@id=\"months\"]")
    private WebElement monthOfBirth;

    @FindBy(xpath = "//*[@id=\"years\"]")
    private WebElement yearOfBirth;

    @FindBy(id = "uniform-newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(xpath = "//*[@id=\"optin\"]")
    private WebElement specialOffersCheckbox;

    @FindBy(xpath = "//*[@id=\"company\"]")
    private WebElement companyName;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement addressLine1;

    @FindBy(xpath = "//*[@id=\"address2\"]")
    private WebElement addressLine2;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement city;

    @FindBy(xpath = "//*[@id=\"id_state\"]")
    private WebElement state;

    @FindBy(xpath = "//*[@id=\"postcode\"]")
    private WebElement postalCode;

    @FindBy(xpath = "//*[@id=\"other\"]")
    private WebElement additionalInfo;

    @FindBy(xpath = "//*[@id=\"phone\"]")
    private WebElement homePhone;

    @FindBy(xpath = "//*[@id=\"phone_mobile\"]")
    private WebElement mobilePhone;

    @FindBy(xpath = "//*[@id=\"alias\"]")
    private WebElement addressAlias;

    @FindBy(xpath = "//*[@id=\"submitAccount\"]")
    private WebElement submitRegistration;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div")
    private WebElement registrationErrorMessage;




    public void selectMrTitle() {
        mrTitle.click();
    }

    public void selectMrsTitle() {
        mrsTitle.click();
    }

    public void selectTitle(String customerTitle) {
        if (customerTitle.equals("Mr")) {
            selectMrTitle();
        } else if (customerTitle.equals("Mrs")) {
            selectMrsTitle();
        }
    }

    public void enterFirstName(String firstname) {
        customerFirstName.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        customerLastName.sendKeys(lastname);
    }

    public void enterPassword(String password) {
        customerPassword.sendKeys(password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        new Select(dayOfBirth).selectByValue(day);
        new Select(monthOfBirth).selectByValue(month);
        new Select(yearOfBirth).selectByValue(year);
    }

    public void clickNewsLetterCheckbox() {
        newsletterCheckbox.click();
    }

    public void clickSpecialOffersCheckbox() {
        specialOffersCheckbox.click();
    }

    public void enterCompanyName(String company) {
        companyName.sendKeys(company);
    }

    public void enterAddress1(String address1) {
        addressLine1.sendKeys(address1);
    }

    public void enterAddress2(String address2) {
        addressLine2.sendKeys(address2);
    }

    public void enterCity(String cityName) {
        city.sendKeys(cityName);
    }

    public void selectState(String addressState) {
        new Select(state).selectByVisibleText(addressState);
    }

    public void enterPostalCode(String zip) {
        postalCode.sendKeys(zip);
    }

    public void enterAdditionalInfo(String info) {
        additionalInfo.sendKeys(info);
    }

    public void enterHomePhone(String homeNumber) {
        homePhone.sendKeys(homeNumber);
    }

    public void enterMobilePhone(String mobileNumber) {
        mobilePhone.sendKeys(mobileNumber);
    }

    public void enterAddressAlias(String alias) {
        addressAlias.clear();
        addressAlias.sendKeys(alias);
    }

    public void clickSubmitRegistration() {
        submitRegistration.click();
    }

    public boolean isRegistrationFailed() {
        String expectedErrorMessage = "There is 1 error";
        String actualErrorMessage = registrationErrorMessage.getText();
        System.out.println("Error message : " + actualErrorMessage);
        return actualErrorMessage.contains(expectedErrorMessage);
    }

}
