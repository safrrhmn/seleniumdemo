package com.demo.github.core;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowserCapabilities {
    DesiredCapabilities capabilities;

    public Capabilities createFirefoxCapabilities() {

        return capabilities.firefox();
    }

    public Capabilities createChromeCapabilities() {

        return capabilities.chrome();
    }

    public Capabilities createIE32Capabilities() {

        return capabilities.internetExplorer();

    }
}
