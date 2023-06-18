package com.tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.FakeData;

import static com.codeborne.selenide.Selenide.*;
import static utils.BrowserUtils.*;
import static utils.FakeData.*;

public class CheckoutItemTest {

    @BeforeTest
    public void loginToApp() {
        openSite();
        maximize();
        setTextInField(By.xpath("//*[@id='user-name']"),"standard_user");
        setTextInField(By.xpath("//*[@id='password']"), "secret_sauce");
        clickElement(By.xpath("//*[@id='login-button']"));
    }

    @Test
    public void verifySuccessfulItemCheckout() {
        addSpecificItemToCart("Sauce Labs Bike Light");
        navigateToMyCartPage();
        verifyItemAddedToCart("Sauce Labs Bike Light");
        checkoutItem();
        enterYourInformation();
        verifyCheckoutOverview();
        finishCheckout();
    }

    private void finishCheckout() {
        clickFinish();
        verifyThankYouPage();
    }

    private void enterYourInformation() {
        enterFirstName();
        enterLastName();
        enterZipCode();
        clickContinue();
    }

    private void clickContinue() {
        clickElement(By.xpath("//input[contains(@class,'cart_button')]"));
    }

    private void enterZipCode() {
        setTextInField(By.xpath("//input[@data-test='postalCode']"), getPostalCode());
    }

    private void enterLastName() {
        setTextInField(By.xpath("//input[@data-test='lastName']"), getLastName());
    }

    private void enterFirstName() {
        setTextInField(By.xpath("//input[@data-test='firstName']"), getFirstName());
    }

    private void verifyCheckoutOverview() {

    }

    private void checkoutItem() {
        clickElement(By.xpath("//a[contains(@class,'checkout_button')]"));
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
