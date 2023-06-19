package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import utils.BrowserUtils;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BrowserUtils {

    public CartPage verifyItemAddedToCart(String sauceLabsBikeLight) {
        $(By.xpath("//*[contains(text(),'"+sauceLabsBikeLight+"')]")).shouldBe(Condition.appear);
        return new CartPage();
    }
    public YourInfoPage checkoutItem() {
        clickElement(By.xpath("//a[contains(@class,'checkout_button')]"));
        return new YourInfoPage();
    }
}
