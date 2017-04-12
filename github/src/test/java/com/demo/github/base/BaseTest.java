package com.demo.github.base;


import com.demo.github.core.WebDriverFactory;
import org.openqa.selenium.WebDriver;


public class BaseTest {

    public static WebDriver getWebDriver() {
        return WebDriverFactory.getCurrentDriver();
    }
}
