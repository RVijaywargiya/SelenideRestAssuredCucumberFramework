package com.ui.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ItemsPage;
import pages.LoginPage;
import utils.BrowserUtils;

public class CheckoutItemTest extends BaseTest{

    @Test
    public void verifySuccessfulItemCheckout() {
        new ItemsPage()
                .addSpecificItemToCart("Sauce Labs Bike Light")
                .navigateToMyCartPage()
                .verifyItemAddedToCart("Sauce Labs Bike Light")
                .checkoutItem()
                .enterYourInformation();
    }

}
