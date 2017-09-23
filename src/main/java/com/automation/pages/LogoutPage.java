package com.automation.pages;

import com.automation.utils.PageUtils;
import com.automation.utils.Selector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    private WebDriver webDriver;
    private PageUtils pageUtils;

    public LogoutPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.pageUtils = new PageUtils(webDriver);
    }

    public void logout() {
        WebElement avatarElement = webDriver.findElement(By.className(Selector.USER_AVATAR_CLASS.toString()));
        avatarElement.click();

        WebElement logoutElement = webDriver.findElement(By.id(Selector.LOGOUT_ID.toString()));
        logoutElement.click();
        String loginTitle = pageUtils.getTitles().getProperty("login");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.titleIs(loginTitle));

        assert loginTitle.equals(webDriver.getTitle());
    }

}
