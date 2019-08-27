package io.github.isandratskiy.extension;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class SetupSelenideExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext context) {
        getWebDriver().quit();
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        startMaximized = true;
        fastSetValue = true;
        browserCapabilities.acceptInsecureCerts();
        timeout = SECONDS.toMillis(20);
        open("https://the-internet.herokuapp.com");
    }
}
