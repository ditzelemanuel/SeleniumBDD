package pages;

public class MainPage extends BasePage{

    private String logoutButton = "//a[@id='ctl00_HeaderTopControl1_LinkButtonLogout']";

    public MainPage(){
        super(driver);
    }

    public String getLogoutButton() {
        return logoutButton;
    }
}
