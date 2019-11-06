package io.github.isandratskiy;

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

@Testcontainers
class ParameterizedExampleTest {
    private RemoteWebDriver driver;

    @ParameterizedTest(name = "{1}")
    @MethodSource("getBrowser")
    void test(BrowserWebDriverContainer container, String name) {
        container.start();
        driver = container.getWebDriver();
        driver.get("https://the-internet.herokuapp.com/");
        assertAll(
                () -> assertEquals("https://the-internet.herokuapp.com/", driver.getCurrentUrl()),
                () -> assertTrue(container.getDockerImageName().contains(name))
        );
        container.stop();
    }

    private static Stream<Arguments> getBrowser() {
        return Stream.of(
                Arguments.of(new BrowserWebDriverContainer().withCapabilities(new ChromeOptions()), "chrome"),
                Arguments.of(new BrowserWebDriverContainer().withCapabilities(new FirefoxOptions()), "firefox")
        );
    }
}