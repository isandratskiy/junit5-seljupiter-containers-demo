package io.github.isandratskiy;

import io.github.isandratskiy.extension.SetupSelenideExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SetupSelenideExtension.class)
class NestedExampleTest {

    @BeforeEach
    void arrange() {
        open("https://the-internet.herokuapp.com");
    }

    @Nested
    class FirstNested {
        @Test
        void firstNestedTest() {
            assertEquals(
                    "https://the-internet.herokuapp.com/", getWebDriver().getCurrentUrl()
            );
        }

        @Test
        void firstNestedFailedTest() {
            assertEquals(
                    "https://the-internet.com/", getWebDriver().getCurrentUrl()
            );
        }
    }

    @Nested
    class SecondNested {
        @Test
        void secondNestedTest() {
            assertEquals(
                    "https://the-internet.herokuapp.com/", getWebDriver().getCurrentUrl()
            );
        }

        @Test
        void secondNestedFailedTest() {
            assertEquals(
                    "https://the-internet.com/", getWebDriver().getCurrentUrl()
            );
        }
    }
}
