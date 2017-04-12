package com.demo.github.pageobjects;

import com.demo.github.core.Navigation;
import org.openqa.selenium.WebDriver;


public class GitHubLandingPage extends BasePage {


    @Override
    protected void load() {
        getWebDriver().get(Navigation.LANDING_PAGE_URL);
    }
}
