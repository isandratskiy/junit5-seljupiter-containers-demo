package io.github.isandratskiy.testcontainers;

import org.junit.jupiter.api.BeforeEach;
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
        assertEquals(
                "https://the-internet.herokuapp.com111", driver.getCurrentUrl()
        );
    }
}
