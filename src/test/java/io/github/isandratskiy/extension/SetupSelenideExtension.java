package io.github.isandratskiy.extension;

import io.github.isandratskiy.driver.ChromeDriverProvider;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.parallel.Execution;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

//@Execution(CONCURRENT)
public class SetupSelenideExtension implements BeforeEachCallback, AfterEachCallback {
    @Override
    public void afterEach(ExtensionContext context) {
        getWebDriver().quit();
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        browser = ChromeDriverProvider.class.getName();
        startMaximized = true;
        fastSetValue = true;
        browserCapabilities.acceptInsecureCerts();
        timeout = SECONDS.toMillis(20);
    }
}
