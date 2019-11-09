package io.github.isandratskiy.selenium.jupiter;

import com.codeborne.selenide.SelenideDriver;
import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumExtension;
import io.github.isandratskiy.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import static io.github.bonigarcia.seljup.BrowserType.CHROME;

@ExtendWith(SeleniumExtension.class)
class JupiterDockerSelenideTest {
    private static final String URL = "https://the-internet.herokuapp.com/";

    @BeforeEach
    void arrange(@DockerBrowser(type = CHROME, version = "77.0") SelenideDriver selenide) {
        setWebDriver(selenide.getWebDriver());
    }

    @Test
    void canFindAllAvailableExamples() {
        open(URL, MainPage.class)
                .getRows()
                .shouldHave(sizeGreaterThan(10));
    }

    @Test
    void canOpenAvailableExample() {
        open(URL, MainPage.class)
                .openAvailableExample("Form Authentication");
    }
}
