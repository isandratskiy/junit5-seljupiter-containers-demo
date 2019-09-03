package io.github.isandratskiy.testcontainers;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
class SeleniumExampleTest {
    private WebDriver driver;

    @Container
    private BrowserWebDriverContainer container =
            new BrowserWebDriverContainer().withCapabilities(new ChromeOptions());

    @BeforeEach
    void setup() {
        container.start();
        driver = container.getWebDriver();
        driver.get("https://the-internet.herokuapp.com");
    }

    @Test
    void shouldBeStarted() {
        Assertions.assertEquals(
                "https://the-internet.herokuapp.com/", driver.getCurrentUrl()
        );
    }

    @AfterEach
    void tearDown() {
        container.stop();
    }
}
