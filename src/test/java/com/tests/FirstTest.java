package com.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FirstTest {

    @BeforeTest
    public void openApp() {
        open("https://www.saucedemo.com/v1/");
        getWebDriver().manage().window().maximize();
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
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
