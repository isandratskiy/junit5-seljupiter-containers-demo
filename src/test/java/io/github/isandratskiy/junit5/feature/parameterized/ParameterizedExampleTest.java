package io.github.isandratskiy.junit5.feature.parameterized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.*;

@Testcontainers
@DisplayName("Parametrize tests with testcontainers")
class ParameterizedExampleTest {
    private static final String DEMO_URL = "https://www.saucedemo.com/";
    private RemoteWebDriver driver;

    @ParameterizedTest(name = "Should open " + DEMO_URL + " with {1} container")
    @MethodSource("browserProvider")
    void shouldRunSiteWithTestcontainer(BrowserWebDriverContainer container, String name) {
        container.start();
        driver = container.getWebDriver();
        driver.get(DEMO_URL);
        assertAll(
                () -> assertEquals(DEMO_URL, driver.getCurrentUrl()),
                () -> assertTrue(container.getDockerImageName().contains(name))
        );
        container.stop();
    }

    private static Stream<Arguments> browserProvider() {
        return Stream.of(
                of(
                        new BrowserWebDriverContainer().withCapabilities(new ChromeOptions()), "chrome"
                ),
                of(
                        new BrowserWebDriverContainer().withCapabilities(new FirefoxOptions()), "firefox"
                )
        );
    }
}