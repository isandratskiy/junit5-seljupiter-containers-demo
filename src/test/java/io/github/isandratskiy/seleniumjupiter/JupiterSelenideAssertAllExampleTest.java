package io.github.isandratskiy.seleniumjupiter;

import com.codeborne.selenide.*;
import io.github.bonigarcia.seljup.SelenideConfiguration;
import io.github.bonigarcia.seljup.SeleniumExtension;
import io.github.isandratskiy.page.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.WebDriverRunner.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SeleniumExtension.class)
@DisplayName("Jupiter Selenide with assertAll example")
class JupiterSelenideAssertAllExampleTest {
    private MainPage mainPage;

    @SelenideConfiguration
    static SelenideConfig selenideConfig = new SelenideConfig()
            .browser(CHROME)
            .baseUrl("https://the-internet.herokuapp.com")
            .startMaximized(true)
            .headless(true);

    @BeforeEach
    void arrange(SelenideDriver driver) {
        this.mainPage = driver.open("/", MainPage.class);
        setWebDriver(driver.getWebDriver());
    }

    @Test
    void canAssertAllWithSelenideConfig() {
        ElementsCollection elements = mainPage.getExamplesList();
        assertAll(
                () -> assertEquals(44, elements.size()),
                () -> assertEquals("Basic Auth", elements.findBy(text("Auth")).text())
        );
    }
}
