package com.demo.github.core;


import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class WebDriverFactory {

    private static WebDriver currentDriver = null;

    static {
        System.setProperty("webdriver.chrome.driver", "..\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "..\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.ie.driver", "..\\drivers\\\\IEDriverServer.exe");
    }

    public static WebDriver createWebDriver(TestType type, WebDriverType driverType) {
        switch (type) {
            case LOCAL:
                return createLocalWebDriver(driverType);
            case REMOTE:
                return createRemoteWebDriver(driverType);
        }
        throw new IllegalArgumentException("WebDriver type is unknown/undefined");
    }

    private static WebDriver createRemoteWebDriver(WebDriverType driverType) {
        Capabilities capabilities;
        BrowserCapabilities cap = new BrowserCapabilities();
        switch (driverType) {
            case FIREFOX:
                capabilities = cap.createFirefoxCapabilities();
                break;
            case CHROME:
                capabilities = cap.createChromeCapabilities();
                break;
            case IE32:
                capabilities = cap.createIE32Capabilities();
                break;
            default:
                throw new IllegalArgumentException(String.format("%s cannot be understood", driverType));
        }
        try {
            currentDriver = new RemoteWebDriver(new URL("http://10.100.11.13:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Could not start RemoteWebDriver " + e);
        }
        return currentDriver;
    }


    private static WebDriver createLocalWebDriver(WebDriverType type) {
        switch (type) {
            case CHROME:
                currentDriver = new ChromeDriver();
                break;
            case IE32:
                currentDriver = new InternetExplorerDriver();
                break;
            case FIREFOX:
                currentDriver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Defined WebDriver type was not understood");

        }
        currentDriver.manage().window().maximize();
        return currentDriver;
    }

    public static WebDriver getCurrentDriver() {
        return currentDriver;
    }
}
