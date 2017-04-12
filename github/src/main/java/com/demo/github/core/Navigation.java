package com.demo.github.core;

import com.demo.github.pageobjects.BasePage;
import com.demo.github.pageobjects.GitHubFeaturePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;

public abstract class Navigation extends SlowLoadableComponent<Navigation> {

	public static String		LANDING_PAGE_URL	= "https://github.com/";
	public static String		FEATURE_PAGE_URL	= LANDING_PAGE_URL + "/features";
	private static WebDriver	driver;

	public Navigation() {
		super(new SystemClock(), BasePage.PAGE_LOAD_TIMEOUT_IN_SECOND);
		driver = WebDriverFactory.getCurrentDriver();
	}

	public GitHubFeaturePage goToFeaturePage() {

		driver.get(FEATURE_PAGE_URL);
		return new GitHubFeaturePage();
	}

	public static WebDriver getWebDriver() {

		return driver;
	}

	public String getCurrentURL() {

		return getWebDriver().getCurrentUrl().trim();
	}

}
