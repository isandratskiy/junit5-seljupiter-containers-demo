package io.github.isandratskiy.testcontainers;

import io.github.isandratskiy.page.MainPage;
import io.github.isandratskiy.extension.SetupSelenideTestContainersExtension;
import io.github.isandratskiy.junit5.feature.meta_annotation.SetupSelenideContainers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SetupSelenideContainers
class SelenideContainersExampleTest {
    private MainPage mainPage;

    @RegisterExtension
    SetupSelenideTestContainersExtension setup =
            new SetupSelenideTestContainersExtension();

    @BeforeEach
    void arrange() {
        this.mainPage = open("/", MainPage.class);
    }

    @Test
    void shouldHaveSizeGreaterThanTenExamples() {
        mainPage.getExamplesList().shouldBe(
                sizeGreaterThan(10).because("Less than ten examples")
        );
    }

    @Test
    void canOpenKeyPressesPage() {
        mainPage.openAvailableExample("Key Presses");
        assertEquals(
                "https://the-internet.herokuapp.com/key_presses", url()
        );
    }
}
