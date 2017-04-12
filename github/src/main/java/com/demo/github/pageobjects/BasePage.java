package com.demo.github.pageobjects;


import com.demo.github.core.Navigation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public abstract class BasePage extends Navigation {

    public static int PAGE_LOAD_TIMEOUT_IN_SECOND = 10;
    public static int CONDITIONAL_TIMEOUT_IN_SECOND = 10;


    @Override
    protected void isLoaded() throws Error {
        WaitUtils.getExplicitWait().until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("document.readyState").equals("complete");
            }
        });
    }
}
