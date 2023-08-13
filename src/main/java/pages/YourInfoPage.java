package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.BrowserUtils;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static utils.FakeData.*;

public class YourInfoPage extends BrowserUtils {

    public static final SelenideElement continueButton = $(byXpath("//input[contains(@class,'cart_button')]"));
    public static final SelenideElement zipCodeField = $(byXpath("//input[@data-test='postalCode']"));
    public static final SelenideElement lastNameField = $(byXpath("//input[@data-test='lastName']"));
    public static final SelenideElement firstNameField = $(byXpath("//input[@data-test='firstName']"));

    public static YourInfoPage getInstance() {
        return new YourInfoPage();
    }

    public void enterYourInformation() {
        enterFirstName()
                .enterLastName()
                .enterZipCode()
                .clickContinue();
    }

    private void clickContinue() {
        clickElement(continueButton);
    }

    private YourInfoPage enterZipCode() {
        setTextInField(zipCodeField, getPostalCode());
        return new YourInfoPage();
    }

    private YourInfoPage enterLastName() {
        setTextInField(lastNameField, getLastName());
        return new YourInfoPage();
    }

    private YourInfoPage enterFirstName() {
        setTextInField(firstNameField, getFirstName());
        return new YourInfoPage();
    }
}
