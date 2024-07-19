package pages;

public class LoginModal extends BasePage {

    private String emailField = "//input[@id='ctl00_MainContent_LoginControl1_TextBoxEmail']";
    private String pwdField = "//input[@id='ctl00_MainContent_LoginControl1_TextBoxPassword']";
    private String loginButton = "//input[@id='ctl00_MainContent_LoginControl1_ButtonLogin']";

    public LoginModal() {
        super(driver);
    }
    public void loginFields(String email, String password){
        write(emailField,email);
        write(pwdField, password);
    }
    public void clickLoginButton(){
        clickElement(loginButton);
    }
}
