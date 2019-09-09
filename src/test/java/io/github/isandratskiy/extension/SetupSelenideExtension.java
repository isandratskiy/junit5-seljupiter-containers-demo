package io.github.isandratskiy.extension;

import io.github.isandratskiy.driver.ChromeDriverProvider;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class SetupSelenideExtension implements BeforeEachCallback, AfterEachCallback {
    @Override
    public void afterEach(ExtensionContext context) {
        getWebDriver().quit();
        System.out.println("DRIVER IS CLOSED");
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        System.out.println("SETUP SELENIDE CONFIG");
        browser = ChromeDriverProvider.class.getName();
        startMaximized = true;
        fastSetValue = true;
        browserCapabilities.acceptInsecureCerts();
        timeout = SECONDS.toMillis(20);
    }
}
