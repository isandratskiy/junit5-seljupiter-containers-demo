package io.github.isandratskiy.seleniumjupiter;

import com.codeborne.selenide.SelenideDriver;
import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumExtension;
import io.github.isandratskiy.page.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import static io.github.bonigarcia.seljup.BrowserType.CHROME;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SeleniumExtension.class)
class JupiterDockerSelenideTest {
    private static final String HEROKUAPP_COM = "https://the-internet.herokuapp.com/";

    @BeforeEach
    void arrange(@DockerBrowser(
            type = CHROME,
            version = "77.0") SelenideDriver selenide) {
        setWebDriver(selenide.getWebDriver());
    }

    @Test
    void canFindAllAvailableExamples() {
        open(HEROKUAPP_COM, MainPage.class).getExamplesList().shouldHave(
                sizeGreaterThan(10)
        );
    }

    @Test
    void canOpenAvailableExample() {
        open(HEROKUAPP_COM, MainPage.class).openAvailableExample("Form Authentication");
        assertEquals(
                "https://the-internet.herokuapp.com/login", url()
        );
    }
}
