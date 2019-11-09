package io.github.isandratskiy.selenium.jupiter;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import io.github.bonigarcia.seljup.SelenideConfiguration;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SeleniumExtension.class)
@DisplayName("Jupiter Selenide with assertAll example")
class JupiterSelenideAssertAllExampleTest {
    private SelenideDriver driver;

    @SelenideConfiguration
    static SelenideConfig selenideConfig =
            new SelenideConfig()
                    .browser(CHROME)
                    .startMaximized(true)
                    .headless(true);

    @BeforeEach
    void arrange(SelenideDriver driver) {
        this.driver = driver;
        this.driver.open("https://the-internet.herokuapp.com");
    }

    @Test
    void canAssertAllWithSelenideConfig() {
        String title = "Basic Auth (user and pass: admin)";
        ElementsCollection elements = driver.$$("#content > ul > li");
        assertAll(
                () -> assertEquals(43, elements.size()),
                () -> assertEquals(title, elements.findBy(text("Basic")).text())
        );
    }
}
