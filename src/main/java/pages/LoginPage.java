package pages;

import org.openqa.selenium.By;
import utils.BrowserUtils;

public class LoginPage extends BrowserUtils {

    private final By userNameTextBox = By.xpath("//*[@id='user-name']");
    private final By passwordTextBox = By.xpath("//*[@id='password']");
    private final By loginButton = By.xpath("//*[@id='login-button']");

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
