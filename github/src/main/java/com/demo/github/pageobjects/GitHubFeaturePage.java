package com.demo.github.pageobjects;


import com.demo.github.core.Navigation;

public class GitHubFeaturePage extends BasePage {


    public GitHubFeaturePage() {
        super();
    }


    @Override
    protected void load() {
        getWebDriver().get(Navigation.FEATURE_PAGE_URL);
    }
}
