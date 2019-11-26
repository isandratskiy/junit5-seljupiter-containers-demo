package io.github.isandratskiy.testcontainers;

import io.github.isandratskiy.driver.WebDriverProvider;
import io.github.isandratskiy.junit5.feature.meta_annotations.BaseSetupWithTestContainers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
class TestContainersSeleniumTest extends TestContainersBaseTest {
    private static final String URL = "https://the-internet.herokuapp.com/";

    @BeforeEach
    void arrange() {
        driver.get(URL);
    }

    @Test
    void shouldStartSeleniumFromContainer() {
        assertEquals(URL, driver.getCurrentUrl());
    }

    @Nested
    @BaseSetupWithTestContainers
    class WhenDriverFromCustomProviderFromContainer {
        @Test
        void shouldLoadSiteUnderProviderFromContainer() {
            assertEquals(URL, WebDriverProvider.getDriver().getCurrentUrl());
        }
    }
}
