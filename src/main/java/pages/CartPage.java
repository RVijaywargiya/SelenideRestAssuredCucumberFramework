package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.BrowserUtils;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BrowserUtils {

    public static final SelenideElement checkoutButton = $(byXpath("//a[contains(@class,'checkout_button')]"));

    public CartPage verifyItemAddedToCart(String sauceLabsBikeLight) {
        $(By.xpath("//*[contains(text(),'"+sauceLabsBikeLight+"')]")).shouldBe(Condition.appear);
        return new CartPage();
    }
    public YourInfoPage checkoutItem() {
        clickElement(checkoutButton);
        return new YourInfoPage();
    }
}
