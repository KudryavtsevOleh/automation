package com.automation.pages;

import com.automation.utils.PageUtils;
import com.automation.utils.Selector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.IntStream;

public class DashBoardPage {

    private WebDriver webDriver;

    public DashBoardPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void checkMainTabs() {
        int tabsSize = webDriver.findElements(By.className(Selector.MAIN_TAB_CLASS.toString())).size();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        for (int i = 0; i < tabsSize; i++) {
            List<WebElement> additionalTabs = webDriver.findElements(By.className(Selector.MAIN_TAB_CLASS.toString()));
            if (additionalTabs.size() == 0) {
                additionalTabs = webDriver.findElements(By.className(Selector.LINK_LEVEL_ONE_CLASS.toString()));
            }
            additionalTabs.get(i).click();
            String initTitle = webDriver.getTitle();
            System.out.println("Title of current page is: " + initTitle);
            webDriver.navigate().refresh();
            webDriverWait.until(ExpectedConditions.titleIs(initTitle));
            String titleAfterReload = webDriver.getTitle();
            assert titleAfterReload.equals(initTitle);
        }
    }

}
