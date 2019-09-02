package io.github.isandratskiy;

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
    static SelenideConfig selenideConfig = new SelenideConfig().browser(FIREFOX)
            .startMaximized(true)
            .headless(true);

    @Test
    void testSelenideConfig(SelenideDriver driver) {
        driver.open("https://the-internet.herokuapp.com");
        assertAll(
                () -> assertEquals(43, driver.$$("#content > ul > li").size()),
                () -> assertEquals(
                        "Basic Auth (user and pass: admin)",
                        driver.$$("#content > ul > li").findBy(text("Basic")).text()
                ));
    }
}
