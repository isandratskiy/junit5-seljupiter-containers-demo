package io.github.isandratskiy.selenium.jupiter;

import com.codeborne.selenide.*;
import io.github.bonigarcia.seljup.SelenideConfiguration;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Browsers.FIREFOX;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
class MultipleAssertExampleTest {
    @SelenideConfiguration
    static SelenideConfig selenideConfig =
            new SelenideConfig().browser(FIREFOX).startMaximized(true).headless(true);

    @Test
    void testSelenideConfig(SelenideDriver driver) {
        driver.open("https://the-internet.herokuapp.com");
        ElementsCollection elements = driver.$$("#content > ul > li");
        assertAll(
                () -> assertEquals(43, elements.size()),
                () -> assertEquals("Basic Auth (user and pass: admin)", elements.findBy(text("Basic")).text())
        );
    }
}
