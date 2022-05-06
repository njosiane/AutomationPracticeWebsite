package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class HomePage {

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='login']")
    private WebElement signIn;

    @FindBy(xpath = "//*[@id=\"newsletter-input\"]")
    private WebElement newsletterEmail;

    @FindBy(xpath = "//*[@id=\"newsletter_block_left\"]/div/form/div/button")
    private WebElement newsletterSubmit;

    @FindBy(xpath = "//*[@id=\"columns\"]/p")
    private WebElement successfulNewsletterSignup;


    public void clickSignIn(){
        signIn.click();
    }

    public void enterNewsletterEmail(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String newsLetterEmail = "username" + randomInt + "@mailinator.com";
        System.out.println("Generated random email : " + newsLetterEmail);
        newsletterEmail.sendKeys(newsLetterEmail);
    }

    public void clickNewsletterSubmit(){
        newsletterSubmit.click();
    }

    public boolean isNewsletterSignupSuccessful(){
        String expectedNewsletterSuccessfulSignupMessage = "Newsletter : You have successfully subscribed to this newsletter.";
        String actualNewsletterSuccessfulSignupMessage =  successfulNewsletterSignup.getText();
        System.out.println("Actual newsletter signup message : " + actualNewsletterSuccessfulSignupMessage);
        return actualNewsletterSuccessfulSignupMessage.equals(expectedNewsletterSuccessfulSignupMessage);
    }


}
