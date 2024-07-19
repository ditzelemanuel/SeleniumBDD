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
    public void the_user_is_on_the_login_page() {
        landingPage.navigateToURL();
        landingPage.clickLoginButton();
    }
    @When("the user enters their email and password")
    public void the_user_enters_their_email_and_password() {
    loginModal.loginFields("succesfullLogin@gmail.com","succesfullLoginpwd");
    }
    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginModal.clickLoginButton();
    }
    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        Assert.assertTrue(mainPage.isElementVisible(mainPage.getLogoutButton()));
    }
}
