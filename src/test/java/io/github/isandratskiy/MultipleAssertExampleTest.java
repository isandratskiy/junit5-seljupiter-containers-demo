package io.github.isandratskiy;

import com.codeborne.selenide.*;
import io.github.bonigarcia.seljup.SelenideConfiguration;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Browsers.*;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith(SeleniumExtension.class)
class MultipleAssertExampleTest {

    @SelenideConfiguration
    static SelenideConfig selenideConfig = new SelenideConfig();

    @BeforeAll
    static void setup() {
        selenideConfig.browser(CHROME);
        selenideConfig.startMaximized(true);
        selenideConfig.headless(true);

    }

    @Test
    void testSelenideConfig(SelenideDriver driver) {
        driver.open("https://the-internet.herokuapp.com");
        SelenideElement element = $("");
    }

}
