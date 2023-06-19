package com.tests;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ItemsPage;
import pages.YourInfoPage;
import utils.BrowserUtils;

import static com.codeborne.selenide.Selenide.*;
import static utils.FakeData.*;

public class CheckoutItemTest {

    @BeforeTest
    public void loginToApp() {
        new BrowserUtils().
                openSite().
                maximize().
                setTextInField(By.xpath("//*[@id='user-name']"), "standard_user").
                setTextInField(By.xpath("//*[@id='password']"), "secret_sauce").
                clickElement(By.xpath("//*[@id='login-button']"));
    }

    @Test
    public void verifySuccessfulItemCheckout() {
        new ItemsPage().addSpecificItemToCart("Sauce Labs Bike Light")
                .navigateToMyCartPage()
                .verifyItemAddedToCart("Sauce Labs Bike Light")
                .checkoutItem()
                .enterYourInformation();
    }

}
