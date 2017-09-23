package com.automation;

import com.automation.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     *
     * @return New instance of {@link WebDriver} object.
     */
    public static WebDriver getDriver() throws Exception {
        switch (Properties.getBrowser()) {
            case BrowserType.CHROME:
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Can't recognize browser type.");
        }
    }
}
