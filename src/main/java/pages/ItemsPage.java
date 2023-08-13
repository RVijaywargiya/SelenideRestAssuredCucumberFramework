package pages;

import org.openqa.selenium.By;
import utils.BrowserUtils;

import static com.codeborne.selenide.Selenide.$;

public class ItemsPage extends BrowserUtils {

    public static ItemsPage getInstance() {
        return new ItemsPage();
    }

    public ItemsPage addSpecificItemToCart(String sauceLabsBikeLight) {
        $(By.xpath("//*[contains(text(),'"+ sauceLabsBikeLight +"')]/../../following-sibling::div//button")).click();
        return this;
    }

    public CartPage navigateToMyCartPage() {
        $(By.xpath("//a[contains(@class,'shopping_cart_link')]")).click();
        return new CartPage();
    }
}
