package pages;

public class MainPage extends BasePage{

    private final String logoutButton = "//a[@id='ctl00_HeaderTopControl1_LinkButtonLogout']";

    public MainPage(){
        super(driver);
    }

    public String getLogoutButton() {
        return logoutButton;
    }
}
