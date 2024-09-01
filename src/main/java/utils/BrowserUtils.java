package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
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
        WebDriverManager.chromedriver().setup();
        open(new PropertyUtils().getProperty("src/main/resources/config/ui-config.properties","url"));
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
