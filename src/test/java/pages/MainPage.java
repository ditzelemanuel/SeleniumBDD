package pages;

import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class MainPage extends BasePage {

    private final String logoutButton = "//a[@id='ctl00_HeaderTopControl1_LinkButtonLogout']";
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getLogoutButton() {
        return logoutButton;
    }

    public boolean isUserLoggedIn() {
        try {
            return isElementVisible(logoutButton);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickLogoutButton(){
        clickElement(logoutButton);
    }
}
