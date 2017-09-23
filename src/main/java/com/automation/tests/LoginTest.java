package com.automation.tests;

import com.automation.BaseScript;
import com.automation.pages.LoginPage;
import com.automation.pages.LogoutPage;
import org.openqa.selenium.WebDriver;

public class LoginTest extends BaseScript {

    public static void main(String[] args) throws Exception {
        WebDriver driver = getDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();
    }
}
