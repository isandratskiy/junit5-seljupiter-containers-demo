package io.github.isandratskiy.testcontainers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.By.*;

@Testcontainers
class TestContainersSeleniumTest extends TestContainersBaseTest {
    @BeforeEach
    void arrange() {
        driver.get("https://the-internet.herokuapp.com");
    }

    @Test
    void canOpenAuthenticationPage() {
        driver.findElement(linkText("Form Authentication")).click();
        assertEquals(
                "https://the-internet.herokuapp.com/login", driver.getCurrentUrl()
        );
    }
}
