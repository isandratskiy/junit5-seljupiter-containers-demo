package io.github.isandratskiy.testcontainers;

import io.github.isandratskiy.junit5.feature.meta_annotation.BaseSetupWithTestContainers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import static io.github.isandratskiy.driver.WebDriverContainer.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

//@Execution(CONCURRENT)
@BaseSetupWithTestContainers
class WebDriverTestContainersExample {
    private static final String URL = "https://the-internet.herokuapp.com/";

    @Test
    void shouldLoadSiteUnderProviderFromContainer() {
        assertEquals(
                URL, getDriver().getCurrentUrl()
        );
    }

    @Test
    void shouldLoadSiteUnderProviderFromContainer1() {
        assertEquals(
                URL, getDriver().getCurrentUrl()
        );
    }

    @Test
    void shouldLoadSiteUnderProviderFromContainer2() {
        assertEquals(
                URL, getDriver().getCurrentUrl()
        );
    }

    @Test
    void shouldLoadSiteUnderProviderFromContainer3() {
        assertEquals(
                URL, getDriver().getCurrentUrl()
        );
    }
}
