package pages;

import org.openqa.selenium.By;
import utils.BrowserUtils;

import static utils.FakeData.*;

public class YourInfoPage extends BrowserUtils {

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
        clickElement(By.xpath("//input[contains(@class,'cart_button')]"));
    }

    private YourInfoPage enterZipCode() {
        setTextInField(By.xpath("//input[@data-test='postalCode']"), getPostalCode());
        return new YourInfoPage();
    }

    private YourInfoPage enterLastName() {
        setTextInField(By.xpath("//input[@data-test='lastName']"), getLastName());
        return new YourInfoPage();
    }

    private YourInfoPage enterFirstName() {
        setTextInField(By.xpath("//input[@data-test='firstName']"), getFirstName());
        return new YourInfoPage();
    }
}
