package utils;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BrowserUtils {

    public static void openSite() {
        Configuration.browser = "edge";
        Configuration.headless = false;
        open("https://www.saucedemo.com/v1/");
    }

    public static void maximize() {
        getWebDriver().manage().window().maximize();
    }

    public static void setTextInField(By by, String text) {
        $(by).setValue(text);
    }

    public static String getTextFromField(By by) {
        return $(by).getValue();
    }

    public static void clickElement(By by) {
        $(by).click();
    }

}
