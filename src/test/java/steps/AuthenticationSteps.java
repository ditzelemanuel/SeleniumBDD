package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LandingPage;
import pages.LoginModal;
import pages.MainPage;
import pages.RegisterModal;

public class LoginSteps {
    LandingPage landingPage = new LandingPage();
    LoginModal loginModal = new LoginModal();
    MainPage mainPage = new MainPage();
    RegisterModal register = new RegisterModal();

    @Given("the user is on the login page")
    public void navigateToLoginModal() {
        landingPage.navigateToURL();
        landingPage.clickLoginButton();
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

    @Then("the user should see an error message")
    public void verifyErrorMessageDisplayed() {
        //Assert.assertEquals(landingPage.getErrorMessage(), "Wrong email or password. Please try again. Forgot your password? You can retrieve it using the form below.");
        Assert.assertEquals(landingPage.getErrorMessage(), "Please correct the missing fields.");
    }
    @Given("the user is on the registration page")
    public void navigateToRegisterModal(){
        landingPage.navigateToURL();
        landingPage.clickSignUpButton();
    }
    @When("the user registers with {}, {}, {} and {}")
    public void registerUserWithDetails(String fullName, String email, String password, String timezone){
        register.enterFullName(fullName);
        register.enterEmail(email);
        register.enterPassword(password);
        register.selectTimezone(timezone);
    }
    @And("the user accepts the terms of service")
    public void acceptTermsOfService(){
        register.acceptTerms();
    }
    @And(("the user does not accept the terms of service"))
    public void declineTermsOfService(){
        register.declineTerms();
    }
    @And("the user clicks the register button")
    public void clickRegisterButton(){
        register.clickSignUpButton();
    }
    @Then("the user should see the main page")
    public void verifyUserSeesMainPage(){
        Assert.assertTrue(mainPage.isElementVisible(mainPage.getLogoutButton()));
    }
}
