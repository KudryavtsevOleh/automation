package com.automation.tests;

import com.automation.BaseScript;
import com.automation.pages.DashBoardPage;
import com.automation.pages.LoginPage;
import com.automation.pages.LogoutPage;
import org.openqa.selenium.WebDriver;

public class CheckMainMenuTest extends BaseScript {

    public static void main(String[] args) throws Exception {
        WebDriver webDriver = getDriver();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login();

        DashBoardPage dashBoardPage = new DashBoardPage(webDriver);
        dashBoardPage.checkMainTabs();
    }
}
