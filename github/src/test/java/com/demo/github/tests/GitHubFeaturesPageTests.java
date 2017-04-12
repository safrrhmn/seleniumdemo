package com.demo.github.tests;

import com.demo.github.base.BaseTest;
import com.demo.github.core.TestType;
import com.demo.github.core.WebDriverFactory;
import com.demo.github.core.WebDriverType;
import com.demo.github.pageobjects.GitHubFeaturePage;
import com.demo.github.pageobjects.GitHubLandingPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class GitHubFeaturesPageTests extends BaseTest {

	private static WebDriver		driver;
	private static WebDriverType[]	values;
	private GitHubFeaturePage		gitHubFeaturePage;

	public GitHubFeaturesPageTests(WebDriverType type) {
		System.out.println(type);
		driver = WebDriverFactory.createWebDriver(TestType.REMOTE, type);
	}

	@Parameterized.Parameters
	public static WebDriverType[] repeatableBrowserType() {

		values = WebDriverType.values();
		return values;
	}

	@After
	public void testDown() {

		driver.quit();
	}

	@Before
	public void setPageState() {

		gitHubFeaturePage = new GitHubLandingPage().goToFeaturePage();
	}

	@Test
	public void gitHubFeaturesNavigationTest() {

		Assert.assertTrue(gitHubFeaturePage.getCurrentURL().contains("features"));
	}

	@Test
	public void pageTextTest() {

		String headerText = gitHubFeaturePage.getHeaderText();
		Assert.assertTrue(headerText.equals("How developers work"));
	}
}
