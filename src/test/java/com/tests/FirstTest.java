package com.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FirstTest {

    @Test
    public void openApp() {
        open("https://www.saucedemo.com/v1/");
        getWebDriver().manage().window().maximize();
        $("#user-name").sendKeys("standard_user");
        $("#password").sendKeys("secret_sauce");
        $("#login-button").click();
    }
}
