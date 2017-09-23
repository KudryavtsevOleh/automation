package com.automation.pages;

import com.automation.utils.Credentials;
import com.automation.utils.Properties;
import com.automation.utils.Selector;
import com.automation.utils.PageUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class LoginPage {

    private Credentials credentials;
    private PageUtils pageUtils;
    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) throws IOException {
        this.webDriver = webDriver;
        this.credentials = loadCredentials();
        this.pageUtils = new PageUtils(webDriver);
    }

    public void login() throws IOException {
        webDriver.get(Properties.getBaseAdminUrl());
        pageUtils.setValueInElementById(Selector.EMAIL_ID.toString(), credentials.getLogin());
        WebElement element = pageUtils.setValueInElementById(Selector.PASSWORD_ID.toString(), credentials.getPassword());
        element.submit();
        String dashboardTitle = pageUtils.getTitles().getProperty("dashboard");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.titleIs(dashboardTitle));
        assert dashboardTitle.equals(webDriver.getTitle());
    }

    private Credentials loadCredentials() throws IOException {
        Credentials credentials = new Credentials();
        credentials.init();
        return credentials;
    }

}
