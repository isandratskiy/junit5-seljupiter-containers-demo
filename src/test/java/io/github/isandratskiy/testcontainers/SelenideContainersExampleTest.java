package io.github.isandratskiy.testcontainers;

import io.github.isandratskiy.extension.SetupSelenideTestContainersExtension;
import io.github.isandratskiy.junit5.feature.meta_annotation.SetupSelenideContainers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SetupSelenideContainers
class SelenideContainersExampleTest {
    private static final String HEROKUAPP_COM = "https://the-internet.herokuapp.com/";
    private static final String HEROKUAPP_COM_BROKEN_IMAGES = "https://the-internet.herokuapp.com/broken_images";
    private static final String HEROKUAPP_COM_ENTRY_AD = "https://the-internet.herokuapp.com/entry_ad";
    private static final String HEROKUAPP_COM_LOGIN = "https://the-internet.herokuapp.com/login";

    @RegisterExtension
    SetupSelenideTestContainersExtension setup =
            new SetupSelenideTestContainersExtension();

    @Test
    void shouldLoadSiteUnderSelenideFromContainer() {
        open(HEROKUAPP_COM);
        assertEquals(HEROKUAPP_COM, url());
    }

    @Test
    void shouldLoadSiteUnderSelenideFromContainer1() {
        open(HEROKUAPP_COM_BROKEN_IMAGES);
        assertEquals(HEROKUAPP_COM_BROKEN_IMAGES, url());
    }

    @Test
    void shouldLoadSiteUnderSelenideFromContainer2() {
        open(HEROKUAPP_COM_ENTRY_AD);
        assertEquals(HEROKUAPP_COM_ENTRY_AD, url());
    }

    @Test
    void shouldLoadSiteUnderSelenideFromContainer3() {
        open(HEROKUAPP_COM_LOGIN);
        assertEquals(HEROKUAPP_COM_LOGIN, url());
    }
}
