package com.ui.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ItemsPage;
import utils.BrowserUtils;

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
