package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;

public class AuthenticationSteps {
    private final LandingPage landingPage;
    private final LoginModal loginModal;
    private final MainPage mainPage;
    private final RegisterModal register;

    public AuthenticationSteps(){
        WebDriver driver = BasePage.getDriver();
        this.landingPage = new LandingPage(driver);
        this.loginModal = new LoginModal(driver);
        this.register = new RegisterModal(driver);
        this.mainPage = new MainPage(driver);
    }

    @Given("the user is on the login page")
    public void navigateToLoginModal() {
        landingPage.navigateToURL();
        landingPage.clickLoginButton();
    }

    @Given("the user is on the registration page")
    public void navigateToRegisterModal() {
        landingPage.navigateToURL();
        landingPage.clickSignUpButton();
    }

    @When("the user enters their email and password")
    public void enterValidCredentials() {
        loginModal.loginFields("succesfullLogin@gmail.com", "succesfullLoginpwd");
    }

    @When("the user clicks the login button")
    public void theUserClicksLoginButton() {
        loginModal.clickLoginButton();
    }

    @Then("the user should be redirected to the home page")
    public void assertUserIsOnHomePage() {
        Assert.assertTrue(mainPage.isElementVisible(mainPage.getLogoutButton()));
    }

    @When("the user enter their {} and {}")
    public void enterInvalidCredentials(String email, String pwd) {
        loginModal.loginFields(email, pwd);
    }

    @Then("the user should see an {}")
    public void verifyErrorMessageDisplayed(String errorMessage) {
        Assert.assertEquals(landingPage.getErrorMessage(), errorMessage);
    }

    @When("the user registers with {}, {}, {} and {}")
    public void registerUserWithDetails(String fullName, String email, String password, String timezone) {
        register.enterFullName(fullName);
        register.enterEmail(email);
        register.enterPassword(password);
        register.selectTimezone(timezone);
    }

    @And("the user accepts the terms of service")
    public void acceptTermsOfService() {
        register.acceptTerms();
    }

    @And(("the user does not accept the terms of service"))
    public void declineTermsOfService() {
        register.declineTerms();
    }

    @And("the user clicks the register button")
    public void clickRegisterButton() {
        register.clickSignUpButton();
    }
}
