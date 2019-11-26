package io.github.isandratskiy.extension;

import io.github.isandratskiy.driver.WebDriverProvider;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;

public class SetupTestContainersExtension implements BeforeEachCallback, AfterEachCallback {
    private WebDriver driver;

    @Container
    private BrowserWebDriverContainer container =
            new BrowserWebDriverContainer().withCapabilities(new ChromeOptions());

    @Override
    public void afterEach(ExtensionContext context) {
        this.container.start();
        this.driver = container.getWebDriver();
        WebDriverProvider.cleanUp();
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        this.container.start();
        this.driver = container.getWebDriver();
        this.driver.get("https://the-internet.herokuapp.com/");
        WebDriverProvider.setupDriver(driver);
    }
}
