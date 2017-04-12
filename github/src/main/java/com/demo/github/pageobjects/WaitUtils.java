package com.demo.github.pageobjects;

import com.demo.github.core.WebDriverFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static Wait getExplicitWait() {
        return new WebDriverWait(WebDriverFactory.getCurrentDriver(), BasePage.CONDITIONAL_TIMEOUT_IN_SECOND);
    }
}
