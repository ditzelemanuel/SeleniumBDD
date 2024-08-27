package pages;

import org.openqa.selenium.WebDriver;

public class LoginModal extends BasePage {

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    public void loginFields(String email, String password) {
        String emailField = "//input[@id='ctl00_MainContent_LoginControl1_TextBoxEmail']";
        String pwdField = "//input[@id='ctl00_MainContent_LoginControl1_TextBoxPassword']";
        write(emailField, email);
        write(pwdField, password);
    }

    public void clickLoginButton() {
        String loginButton = "//input[@id='ctl00_MainContent_LoginControl1_ButtonLogin']";
        clickElement(loginButton);
    }
}
