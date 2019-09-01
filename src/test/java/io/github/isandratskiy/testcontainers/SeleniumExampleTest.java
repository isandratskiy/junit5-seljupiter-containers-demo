package io.github.isandratskiy.testcontainers;

import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
class SeleniumExampleTest {

    @Container
    private BrowserWebDriverContainer container = new BrowserWebDriverContainer();

    @BeforeEach
    void setup() {
        container.withCapabilities(new ChromeOptions());
        container.start();
        container.getWebDriver().get("https://the-internet.herokuapp.com");
    }

    @Test
    void shouldBeStarted() {
        Assertions.assertTrue(container.isRunning());
        Assertions.assertEquals(
                "https://the-internet.herokuapp.com/", container.getWebDriver().getCurrentUrl()
        );
    }

    @AfterEach
    void teardown() {
        container.stop();
    }
}
