package com.automation;

import com.automation.pages.DashBoardPage;
import com.automation.pages.LoginPage;
import com.automation.pages.LogoutPage;
import org.openqa.selenium.WebDriver;

public class Main {

    public static void main(String[] args) throws Exception {
        WebDriver webDriver = BaseScript.getDriver();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login();

        DashBoardPage dashBoardPage = new DashBoardPage(webDriver);
        dashBoardPage.checkMainTabs();

        LogoutPage logoutPage = new LogoutPage(webDriver);
        logoutPage.logout();
    }

}
