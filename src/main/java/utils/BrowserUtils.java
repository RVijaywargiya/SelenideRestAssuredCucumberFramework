package utils;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BrowserUtils {

    public BrowserUtils setBrowser() {
        Configuration.browser = System.getProperty("browser");
        return this;
    }

    public BrowserUtils setMode() {
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless"));
        return this;
    }

    public BrowserUtils openSite() {
        open("https://www.saucedemo.com/v1/");
        return this;
    }

    public void maximize() {
        getWebDriver().manage().window().maximize();
    }

    public void setTextInField(By by, String text) {
        $(by).setValue(text);
    }

    public static String getTextFromField(By by) {
        return $(by).getValue();
    }

    public void clickElement(By by) {
        $(by).click();
    }

}
