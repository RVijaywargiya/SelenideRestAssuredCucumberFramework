package com.ui.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.LoginPage;
import utils.BrowserUtils;

public class BaseTest {

    @BeforeSuite
    public void openBrowser() {
        new BrowserUtils().
                openSite().
                maximize();
    }

    @BeforeTest
    public void loginToApp() {
        new LoginPage()
                .enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickLoginButton();
    }
}
