package io.github.isandratskiy;

import io.github.isandratskiy.extension.SetupSelenideExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SetupSelenideExtension.class)
@DisplayName("Nested tests example")
class NestedClassExampleTest {
    private static final String URL = "https://the-internet.herokuapp.com/";
    private static final String FAKE_URL = "https://the-fake.com/";

    @BeforeEach
    void arrange() {
        open(URL);
    }

    @Nested
    class FirstNested {
        @Test
        void firstNestedEqualTest() {
            assertEquals(URL, getWebDriver().getCurrentUrl());
        }

        @Test
        void firstNestedNotEqualTest() {
            assertNotEquals(FAKE_URL, getWebDriver().getCurrentUrl());
        }
    }

    @Nested
    class SecondNested {
        @Test
        void secondNestedEqualTest() {
            assertEquals(URL, getWebDriver().getCurrentUrl());
        }

        @Test
        void secondNestedNotEqualTest() {
            assertNotEquals(FAKE_URL, getWebDriver().getCurrentUrl());
        }
    }
}
