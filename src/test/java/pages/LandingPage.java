package pages;

public class LandingPage extends BasePage {

    private String loginButton = "//div[@class='HPHeaderLogin']/a";
    private String singUpButton = "//div[@class='HPHeaderSignup']/a";

    public LandingPage(){
        super(driver);
    }

    public void navigateToURL(){
        navigateTo("https://todo.ly/");
    }
    public void clickLoginButton(){
        clickElement(loginButton);
    }
    public void clickSignUpButton(){
        clickElement(singUpButton);
    }

}
