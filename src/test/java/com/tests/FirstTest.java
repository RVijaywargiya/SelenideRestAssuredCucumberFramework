package com.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static utils.BrowserUtils.*;

public class FirstTest {

    @BeforeTest
    public void loginToApp() {
        openSite();
        maximize();
        setTextInField(By.xpath("//*[@id='user-name']"),"standard_user");
        setTextInField(By.xpath("//*[@id='password']"), "secret_sauce");
        clickElement(By.xpath("//*[@id='login-button']"));
    }

    @Test
    public void checkoutItem() {
        addSpecificItemToCart("Sauce Labs Bike Light");
        navigateToMyCartPage();
        verifyItemAddedToCart("Sauce Labs Bike Light");
    }

    private void navigateToMyCartPage() {
        $(By.xpath("//a[contains(@class,'shopping_cart_link')]")).click();
    }

    private void verifyItemAddedToCart(String sauceLabsBikeLight) {
        $(By.xpath("//*[contains(text(),'"+sauceLabsBikeLight+"')]")).shouldBe(Condition.appear);
    }

    private void addSpecificItemToCart(String sauceLabsBikeLight) {
        $(By.xpath("//*[contains(text(),'"+ sauceLabsBikeLight +"')]/../../following-sibling::div//button")).click();
    }
}
