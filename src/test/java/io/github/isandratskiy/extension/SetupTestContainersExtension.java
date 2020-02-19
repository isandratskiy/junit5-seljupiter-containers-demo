package io.github.isandratskiy.extension;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;

import static io.github.isandratskiy.driver.WebDriverProvider.*;

public class SetupTestContainersExtension implements BeforeEachCallback, AfterEachCallback {
    private WebDriver driver;

    @Container
    private BrowserWebDriverContainer container =
            new BrowserWebDriverContainer().withCapabilities(new FirefoxOptions());

    @Override
    public void beforeEach(ExtensionContext context) {
        this.container.start();
        this.driver = container.getWebDriver();
        setDriver(driver);
    }

    @Override
    public void afterEach(ExtensionContext context) {
        this.driver.quit();
        this.container.stop();
        cleanUp();
    }
}
