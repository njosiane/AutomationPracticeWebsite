package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.AuthenticationPage;
import pageObjects.BasePage;

public class LoginSteps extends BasePage {

    AuthenticationPage authenticationPage = new AuthenticationPage(driver);

    @And("I enter my registered {string} under already registered section")
    public void iEnterMyRegisteredUnderAlreadyRegisteredSection(String loginEmail) {
        authenticationPage.enterRegisteredEmail(loginEmail);
    }

    @And("I enter my password {string} under already registered section")
    public void iEnterMyPasswordUnderAlreadyRegisteredSection(String loginPsswrd) {
        authenticationPage.enterRegisteredPassword(loginPsswrd);
    }

    @And("I click on the Sign in button")
    public void iClickOnTheSignInButton() {
        authenticationPage.clickSubmitLogin();
    }

    @And("I enter an invalid password {string} under already registered section")
    public void iEnterAnInvalidPasswordUnderAlreadyRegisteredSection(String loginPsswrd) {
        authenticationPage.enterRegisteredPassword(loginPsswrd);
    }

    @Then("a login error is displayed")
    public void aLoginErrorIsDisplayed() {
        Assert.assertTrue(authenticationPage.isLoginErrorDisplayed());
    }
}
