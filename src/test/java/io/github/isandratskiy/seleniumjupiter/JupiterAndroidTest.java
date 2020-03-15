package io.github.isandratskiy.seleniumjupiter;

import io.github.bonigarcia.seljup.DockerBrowser;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.remote.RemoteWebDriver;

import static io.github.bonigarcia.seljup.BrowserType.ANDROID;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

class JupiterAndroidTest {
    @RegisterExtension
    static SeleniumExtension seleniumExtension = new SeleniumExtension();

    @BeforeAll
    static void setup() {
        seleniumExtension.getConfig().setAndroidLogging(true);
    }

    @Test
    void testAndroid(
            @DockerBrowser(
                    type = ANDROID,
                    version = "5.0.1",
                    deviceName = "Nexus 5") RemoteWebDriver driver) {
        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(
                driver.getTitle(), containsString("JUnit 5 extension for Selenium")
        );
    }
}
