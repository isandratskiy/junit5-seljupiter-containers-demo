package io.github.isandratskiy.testcontainers;

import io.github.isandratskiy.junit5.feature.meta_annotation.SetupSelenideContainers;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SetupSelenideContainers
class SelenideContainersExampleTest {
    private static final String URL = "https://the-internet.herokuapp.com/";

    @Test
    void test() {
        open(URL);
        assertEquals(URL, url());
    }
}
