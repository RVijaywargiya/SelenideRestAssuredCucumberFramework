package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.java.Log;
import org.openqa.selenium.By;
import utils.BrowserUtils;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BrowserUtils {

    private final SelenideElement userNameTextBox = $(byXpath("//*[@id='user-name']"));
    private final SelenideElement passwordTextBox = $(byXpath("//*[@id='password']"));
    private final SelenideElement loginButton = $(byXpath("//*[@id='login-button']"));

    public static LoginPage getInstance() {
        return new LoginPage();
    }

    public LoginPage enterUsername(String userName) {
        setTextInField(userNameTextBox, userName);
        return new LoginPage();
    }

    public LoginPage enterPassword(String password) {
        setTextInField(passwordTextBox, password);
        return new LoginPage();
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }
}
