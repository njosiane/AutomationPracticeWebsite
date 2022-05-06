package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.BasePage;
import pageObjects.MyAccountPage;
import pageObjects.MyPersonalInformationPage;

public class MyPersonalInformationSteps extends BasePage {

    MyPersonalInformationPage myPersonalInformationPage = new MyPersonalInformationPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);

    @And("I click on my personal information")
    public void iClickOnMyPersonalInformation() {
        myAccountPage.clickMyPersonalInformation();
    }

    @And("I amend first name to a {string}")
    public void iAmendFirstNameToA(String newFirstName) {
        scrollDown();
        myPersonalInformationPage.enterNewFirstName(newFirstName);
    }

    @And("I enter my valid {string} in the current password input field")
    public void iEnterMyValidInTheCurrentPasswordInputField(String currentPsswrd) {
        myPersonalInformationPage.confirmCurrentPassword(currentPsswrd);
    }

    @And("I click on save button")
    public void iClickOnSaveButton() {
        myPersonalInformationPage.clickSubmitUpdate();
    }

    @And("a confirmation of update message is displayed")
    public void aConfirmationOfUpdateMessageIsDisplayed() {
        Assert.assertTrue(myPersonalInformationPage.isSuccessfulUpdateMessageDisplayed());
    }

    @And("I click on back to your account button")
    public void iClickOnBackToYourAccountButton() {
        myPersonalInformationPage.clickBackToAccount();
    }

    @Then("my first name has been updated with the new value")
    public void myFirstNameHasBeenUpdatedWithTheNewValue() {
        scrollDown();
        Assert.assertTrue(myPersonalInformationPage.isFirstNameUpdated());
    }


}
