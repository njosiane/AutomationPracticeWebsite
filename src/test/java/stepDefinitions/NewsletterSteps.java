package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.BasePage;
import pageObjects.HomePage;


public class NewsletterSteps extends BasePage {

    HomePage homePage = new HomePage(driver);



    @When("I enter {string} in the newsletter email input field")
    public void iEnterInTheNewsletterEmailInputField(String newsLetterEmail) {
        homePage.enterNewsletterEmail();
    }

    @And("I click on the submit symbol on the newsletter email input field")
    public void iClickOnTheSubmitSymbolOnTheNewsletterEmailInputField() {
        homePage.clickNewsletterSubmit();
    }

    @Then("a successful message is generated")
    public void aSuccessfulMessageIsGenerated() {
        Assert.assertTrue(homePage.isNewsletterSignupSuccessful());
    }


}
