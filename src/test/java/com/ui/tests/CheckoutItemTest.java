package com.ui.tests;

import org.testng.annotations.Test;
import pages.ItemsPage;

public class CheckoutItemTest extends BaseTest{

    @Test
    public void verifySuccessfulItemCheckout() {
        ItemsPage.getInstance()
                .addSpecificItemToCart("Sauce Labs Bike Light")
                .navigateToMyCartPage()
                .verifyItemAddedToCart("Sauce Labs Bike Light")
                .checkoutItem()
                .enterYourInformation();
    }

}
