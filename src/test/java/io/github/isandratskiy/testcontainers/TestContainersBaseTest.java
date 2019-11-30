package io.github.isandratskiy.testcontainers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.DefaultRecordingFileFactory;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.*;

@Testcontainers
class TestContainersBaseTest {
    protected WebDriver driver;

    @Container
    private BrowserWebDriverContainer container = new BrowserWebDriverContainer()
                    .withCapabilities(new ChromeOptions())
                    .withRecordingMode(RECORD_ALL, new File("./build/"))
                    .withRecordingFileFactory(new DefaultRecordingFileFactory());

    @BeforeEach
    void start() {
        this.container.start();
        this.driver = container.getWebDriver();
    }

    @AfterEach
    void stop() {
        this.driver.quit();
        this.container.stop();
    }
}
