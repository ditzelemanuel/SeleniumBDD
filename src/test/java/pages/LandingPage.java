package pages;

public class LandingPage extends BasePage {

    public LandingPage(){
        super(driver);
    }

    public void navigateToURL(){
        navigateTo("https://todo.ly/");
    }
    public void clickLoginButton(){
        String loginButton = "//div[@class='HPHeaderLogin']/a";
        clickElement(loginButton);
    }
    public void clickSignUpButton(){
        String singUpButton = "//div[@class='HPHeaderSignup']/a";
        clickElement(singUpButton);
    }
    public String getErrorMessage(){
        String errorMessage = "//span[@id=\"ErrorMessageText\"]";
        return getText(errorMessage);
    }
}
