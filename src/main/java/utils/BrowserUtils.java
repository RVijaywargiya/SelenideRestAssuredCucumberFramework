package utils;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Properties;

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

    public BrowserUtils openSite() throws IOException {
        open(new PropertyUtils().getProperty("url"));
        return this;
    }

    public void maximize() {
        getWebDriver().manage().window().maximize();
    }

    public void setTextInField(SelenideElement element, String text) {
        element.setValue(text);
    }

    public static String getTextFromField(By by) {
        return $(by).getValue();
    }

    public void clickElement(SelenideElement element) {
        element.click();
    }

}
