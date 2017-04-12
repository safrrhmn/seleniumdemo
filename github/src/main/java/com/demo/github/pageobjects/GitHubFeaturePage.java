package com.demo.github.pageobjects;


import com.demo.github.core.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GitHubFeaturePage extends BasePage {


    @FindBy(tagName = "h1")
    private
    WebElement headerElement;

    public GitHubFeaturePage() {

        super();
        PageFactory.initElements(getWebDriver(), this);
    }


    @Override
    protected void load() {
        getWebDriver().get(Navigation.FEATURE_PAGE_URL);
    }

    public String getHeaderText() {
        return headerElement.getText().trim();
    }
}
