package io.github.isandratskiy;

import com.codeborne.selenide.Selenide;
import io.github.isandratskiy.extension.SetupSelenideExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.WebDriverRunner.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SetupSelenideExtension.class)
class NestedExampleTest {

    @BeforeEach
    void setup() {
        System.out.println("OPENING SITE URL");
        Selenide.open("https://the-internet.herokuapp.com");
    }

    @Nested
    class FirstNested {
        @Test
        void firstNestedTest() {
            System.out.println("FIRST IS RUNNING");
            assertEquals(
                    "https://the-internet.herokuapp.com/", getWebDriver().getCurrentUrl()
            );
        }
    }

    @Nested
    class SecondNested {
        @Test
        void secondNestedTest() {
            System.out.println("SECOND IS RUNNING");
            assertEquals(
                    "https://the-internet.herokuapp.com/", getWebDriver().getCurrentUrl()
            );
        }
    }


}
