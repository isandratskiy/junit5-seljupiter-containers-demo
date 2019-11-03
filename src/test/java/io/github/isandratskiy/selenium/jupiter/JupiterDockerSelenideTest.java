package io.github.isandratskiy.selenium.jupiter;

import com.codeborne.selenide.SelenideDriver;
import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumExtension;
import io.github.isandratskiy.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.CollectionCondition.*;
import static io.github.bonigarcia.seljup.BrowserType.CHROME;

@ExtendWith(SeleniumExtension.class)
class JupiterDockerSelenideTest {
    private MainPage mainPage;

    @BeforeEach
    void arrange(@DockerBrowser(type = CHROME) SelenideDriver selenide) {
        mainPage = new MainPage(selenide);
    }

    @Test
    void canSelenideWithDockerInPageObject() {
        mainPage.openLink("https://the-internet.herokuapp.com")
                .getRows()
                .shouldHave(sizeGreaterThan(10));
    }
}
