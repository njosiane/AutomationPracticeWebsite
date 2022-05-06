package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class AuthenticationPage {

    public AuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"email_create\"]")
    private WebElement registrationEmail;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]")
    private WebElement createAccount;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement loginEmailAddress;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement loginPassword;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]")
    private WebElement submitLogin;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//*[@id=\"create_account_error\"]/ol/li")
    private WebElement registeredEmailError;



    public void enterNewRegistrationEmail() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String signInEmail = "username" + randomInt + "@mailinator.com";
        System.out.println("Generated random email : " + signInEmail);
        registrationEmail.sendKeys(signInEmail);
    }

    public void enterExistingRegistrationEmail(String existingEmail) {
        registrationEmail.sendKeys(existingEmail);
    }

    public void clickCreateAccount() {
        createAccount.click();
    }

    public void enterRegisteredEmail(String loginEmail) {
        loginEmailAddress.sendKeys(loginEmail);
    }

    public void enterRegisteredPassword(String loginPsswrd) {
        loginPassword.sendKeys(loginPsswrd);
    }

    public void clickSubmitLogin(){
        submitLogin.click();
    }

    public boolean isLoginErrorDisplayed(){
        String expectedLoginError = "Authentication failed";
        String actualLoginError = loginErrorMessage.getText();
        System.out.println("Error message : " + actualLoginError);
        return actualLoginError.contains(expectedLoginError);
    }

    public boolean isEmailAlreadyRegistered() {
        String expectedRegisteredEmailError = "An account using this email address has already been registered";
        String actualRegisterEmailError = registeredEmailError.getText();
        System.out.println("Error message : " + actualRegisterEmailError);
        return actualRegisterEmailError.contains(expectedRegisteredEmailError);
    }

}