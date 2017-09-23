package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class PageUtils {

    private WebDriver webDriver;
    private Properties titleProperties = null;

    public PageUtils(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement setValueInElementById(String id, String value) {
        WebElement element = webDriver.findElement(By.id(id));
        element.sendKeys(value);
        return element;
    }

    public Properties getTitles() {
        if (titleProperties == null) {
            try (
                    InputStreamReader is = new InputStreamReader(
                            new FileInputStream("src/main/resources/titles.properties"), "UTF-8")
            ) {
                titleProperties = new Properties();
                titleProperties.load(is);
            } catch (Exception e) {
                System.out.println("Error occurred while getting title.properties file: " + e.getMessage());
            }
        }
        return titleProperties;
    }

}
