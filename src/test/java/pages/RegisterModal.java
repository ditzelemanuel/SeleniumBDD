package pages;

import org.openqa.selenium.WebDriver;

public class RegisterModal extends BasePage {

    private final String checkbox = "//input[@id='ctl00_MainContent_SignupControl1_CheckBoxTerms']";
    public RegisterModal(WebDriver driver){
        super(driver);
    }

    public void enterFullName(String name){
        String nameField = "//input[@id='ctl00_MainContent_SignupControl1_TextBoxFullName']";
        write(nameField,name);
    }

    public void enterEmail(String email) {
        String emailField = "//input[@id='ctl00_MainContent_SignupControl1_TextBoxEmail']";
        if (email.equals("dynamically_generated")) {
            email = "user_" + System.currentTimeMillis() + "@example.com";
        }
        write(emailField,email);
    }

    public void enterPassword(String pwd) {
        String pwdField = "//input[@id='ctl00_MainContent_SignupControl1_TextBoxPassword']";
        write(pwdField,pwd);
    }
    public void selectTimezone(String timezone){
        String dropdown = "//select[@id='ctl00_MainContent_SignupControl1_DropDownTimezone']";
        selectOptionByPartialText(dropdown,timezone);
    }
    public void acceptTerms(){
        selectCheckbox(checkbox);
    }
    public void declineTerms(){
        deselectCheckbox(checkbox);
    }
    public void clickSignUpButton(){
        String signUpBtn = "//input[@id='ctl00_MainContent_SignupControl1_ButtonSignup']";
        clickElement(signUpBtn);
    }
}
