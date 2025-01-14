package pages;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    protected static WebDriver driver;
    protected WebDriverWait wait;

    public static void startDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public BasePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized.");
        }
        BasePage.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static void navigateTo(String url) {
        if (driver != null) {
            driver.get(url);
        } else {
            throw new IllegalStateException("Driver is not initialized.");
        }
    }

    public static void closeBrowser() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (WebDriverException e) {
                System.out.println("Exception occurred while quitting the driver: " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private WebElement find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public String getText(String locator) {
        return find(locator).getText();
    }

    public boolean isElementVisible(String locator) {
        return find(locator).isDisplayed();
    }

    public void clickElement(String locator) {
        find(locator).click();
    }

    public void write(String locator, String keysToSend) {
        find(locator).clear();
        find(locator).sendKeys(keysToSend);
    }

    public void selectDropdownByValue(String locator, String value) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(value);
    }

    public void selectDropdownByIndex(String locator, int index) {
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(index);
    }

    public int dropdownSize(String locator) {
        Select dropdown = new Select(find(locator));
        List<WebElement> elements = dropdown.getOptions();
        return elements.size();
    }

    public List<String> getDropdownValues(String locator) {
        Select dropdown = new Select(find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();

        for (WebElement option : dropdownOptions) {
            values.add(option.getText());
        }
        return values;
    }

    public void selectOptionByPartialText(String locator, String text) {
        Select dropdown = new Select(find(locator));
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option : options) {
            if (option.getText().contains(text)){
                option.click();
            }
        }
    }
    public void selectCheckbox(String locator) {
        WebElement checkbox = find(locator);
        if (!checkbox.isSelected()){
            checkbox.click();
        }
    }
    public void deselectCheckbox(String locator) {
        WebElement checkbox = find(locator);
        if (checkbox.isSelected()){
            checkbox.click();
        }
    }
    public boolean isCheckboxSelected(String locator) {
        WebElement checkbox = find(locator);
        return checkbox.isSelected();
    }
}
//