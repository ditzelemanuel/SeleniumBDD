package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LandingPage;
import pages.LoginModal;
import pages.MainPage;

public class LoginSteps {
    LandingPage landingPage = new LandingPage();
    LoginModal loginModal = new LoginModal();
    MainPage mainPage = new MainPage();

    @Given("the user is on the login page")
    public void navigateToLoginPage() {
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
        Assert.assertEquals(landingPage.getErrorMessage(), "Wrong email or password. Please try again. Forgot your password? You can retrieve it using the form below.");
    }
}
