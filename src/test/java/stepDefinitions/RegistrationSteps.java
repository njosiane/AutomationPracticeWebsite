package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.*;

import static commons.DriverManager.driver;

public class RegistrationSteps extends BasePage {

    HomePage homePage = new HomePage(driver);
    AuthenticationPage authenticationPage = new AuthenticationPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);

    @Given("I navigate to AutomationPractice homepage")
    public void iNavigateToAutomationPracticeHomepage() {
        navigateToHomepage();
    }

    @When("I click on Sign in link")
    public void iClickOnSignInLink() {
        homePage.clickSignIn();
    }

    @And("I enter a new {string} under create an account section")
    public void iEnterANewUnderCreateAnAccountSection(String signInEmail) {
        authenticationPage.enterNewRegistrationEmail();
    }

    @And("I click on Create an account button")
    public void iClickOnCreateAnAccountButton() {
        authenticationPage.clickCreateAccount();
    }

    @And("I click {string} radio button")
    public void iClickRadioButton(String customerTitle) {
        registrationPage.selectTitle(customerTitle);
    }

    @And("I enter {string} in the first name input field")
    public void iEnterInTheFirstNameInputField(String firstname) {
        registrationPage.enterFirstName(firstname);
    }

    @And("I enter {string} in the last name input field")
    public void iEnterInTheLastNameInputField(String lastname) {
        registrationPage.enterLastName(lastname);
    }

    @And("I enter {string} in the password input field")
    public void iEnterInThePasswordInputField(String password) {
        registrationPage.enterPassword(password);
    }

    @And("I select Date of Birth {string}, {string}, {string} from the date of birth dropdown")
    public void iSelectDateOfBirthFromTheDateOfBirthDropdown(String day, String month, String year) {
        registrationPage.selectDateOfBirth(day, month, year);
    }

    @And("I click the News Letter Sign Up check box")
    public void iClickTheNewsLetterSignUpCheckBox() {
        registrationPage.clickNewsLetterCheckbox();
    }

    @And("I click the Special Offers check box")
    public void iClickTheSpecialOffersCheckBox() {
        registrationPage.clickSpecialOffersCheckbox();
    }

    @And("I enter {string} in the company input field")
    public void iEnterInTheCompanyInputField(String company) {
        registrationPage.enterCompanyName(company);
    }

    @And("I enter {string} in the address first input field")
    public void iEnterInTheAddressFirstInputField(String address1) {
        registrationPage.enterAddress1(address1);
    }

    @And("I enter {string} in the address second input field")
    public void iEnterInTheAddressSecondInputField(String address2) {
        registrationPage.enterAddress2(address2);
    }

    @And("I enter {string} in the city input field")
    public void iEnterInTheCityInputField(String cityName) {
        registrationPage.enterCity(cityName);
    }

    @And("I select {string} from the state dropdown")
    public void iSelectFromTheStateDropdown(String addressState) {
        registrationPage.selectState(addressState);
    }

    @And("I enter {string} in the postal code input field")
    public void iEnterInThePostalCodeInputField(String zip) {
        registrationPage.enterPostalCode(zip);
    }

    @And("I enter {string} in the additional information input field")
    public void iEnterInTheAdditionalInformationInputField(String info) {
        registrationPage.enterAdditionalInfo(info);
    }

    @And("I enter {string} in the home phone input field")
    public void iEnterInTheHomePhoneInputField(String homeNumber) {
        registrationPage.enterHomePhone(homeNumber);
    }

    @And("I enter {string} in the mobile phone input field")
    public void iEnterInTheMobilePhoneInputField(String mobileNumber) {
        registrationPage.enterMobilePhone(mobileNumber);
    }

    @And("I enter {string} in the address alias input field")
    public void iEnterInTheAddressAliasInputField(String alias) {
        registrationPage.enterAddressAlias(alias);
    }

    @And("I click on Register button")
    public void iClickOnRegisterButton() {
        registrationPage.clickSubmitRegistration();
    }

    @Then("My Account page is displayed")
    public void myAccountPageIsDisplayed() {
        Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed());
    }


    @And("I do not enter {string} in the mobile phone input field")
    public void iDoNotEnterInTheMobilePhoneInputField(String mobileNumber) {
        registrationPage.enterMobilePhone(mobileNumber);
    }

    @Then("an error message is displayed")
    public void anErrorMessageIsDisplayed() {
        Assert.assertTrue(registrationPage.isRegistrationFailed());
    }


    @And("I enter an existing {string} under create an account section")
    public void iEnterAnExistingUnderCreateAnAccountSection(String existingEmail) {
        authenticationPage.enterExistingRegistrationEmail(existingEmail);
    }
    
    @Then("a create account error message is displayed")
    public void aCreateAccountErrorMessageIsDisplayed() {
      //  scrollDown();
        Assert.assertTrue(authenticationPage.isEmailAlreadyRegistered());
    }


}
