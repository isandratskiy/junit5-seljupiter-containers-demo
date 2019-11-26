package io.github.isandratskiy.junit5.feature.nested;

import io.github.isandratskiy.extension.SetupSelenideExtension;
import io.github.isandratskiy.junit5.feature.meta_annotations.BaseSetupWithConcurrent;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
@ExtendWith(SetupSelenideExtension.class)
//@BaseSetupWithConcurrent
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
