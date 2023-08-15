package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.BrowserUtils;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ItemsPage extends BrowserUtils {

    public static final SelenideElement shoppingCartLink = $(byXpath("//a[contains(@class,'shopping_cart_link')]"));

    public static ItemsPage getInstance() {
        return new ItemsPage();
    }

    public ItemsPage addSpecificItemToCart(String sauceLabsBikeLight) {
        $(byXpath("//*[contains(text(),'"+ sauceLabsBikeLight +"')]/../../following-sibling::div//button")).click();
        return this;
    }

    public CartPage navigateToMyCartPage() {
        shoppingCartLink.click();
        return new CartPage();
    }
}
