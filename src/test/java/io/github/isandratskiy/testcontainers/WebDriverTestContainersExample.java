package io.github.isandratskiy.testcontainers;

import io.github.isandratskiy.extension.SetupTestContainersExtension;
import io.github.isandratskiy.junit5.feature.meta_annotation.BaseSetupWithTestContainers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.github.isandratskiy.driver.WebDriverContainer.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.*;

@BaseSetupWithTestContainers
//@ExtendWith(SetupTestContainersExtension.class)
class WebDriverTestContainersExample {
    private static final String HEROKUAPP_COM = "https://the-internet.herokuapp.com/";
    private static final String HEROKUAPP_COM_BROKEN_IMAGES = "https://the-internet.herokuapp.com/broken_images";
    private static final String HEROKUAPP_COM_ENTRY_AD = "https://the-internet.herokuapp.com/entry_ad";
    private static final String HEROKUAPP_COM_LOGIN = "https://the-internet.herokuapp.com/login";

    @RegisterExtension
    SetupTestContainersExtension setup =
            new SetupTestContainersExtension();

    @Test
    void shouldLoadSiteUnderProviderFromContainer() {
        getDriver().get(HEROKUAPP_COM);
        assertEquals(
                HEROKUAPP_COM, getDriver().getCurrentUrl()
        );
    }

    //Parametrize with parallel execution
    @ParameterizedTest(name = "should load - {0} site under provider from container")
    @MethodSource("urlProvider")
    void shouldLoadParametrizeSiteUnderProviderFromContainer(String url) {
        getDriver().get(url);
        assertEquals(
                url, getDriver().getCurrentUrl()
        );
    }

    private static Stream<Arguments> urlProvider() {
        return Stream.of(
                of(HEROKUAPP_COM),
                of(HEROKUAPP_COM_BROKEN_IMAGES),
                of(HEROKUAPP_COM_ENTRY_AD),
                of(HEROKUAPP_COM_LOGIN)
        );
    }
}
