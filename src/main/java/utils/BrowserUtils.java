package utils;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BrowserUtils {

    public BrowserUtils openSite() {
        Configuration.browser = "edge";
        Configuration.headless = false;
        open("https://www.saucedemo.com/v1/");
        return this;
    }

    public BrowserUtils maximize() {
        getWebDriver().manage().window().maximize();
        return this;
    }

    public BrowserUtils setTextInField(By by, String text) {
        $(by).setValue(text);
        return this;
    }

    public static String getTextFromField(By by) {
        return $(by).getValue();
    }

    public BrowserUtils clickElement(By by) {
        $(by).click();
        return this;
    }

}
