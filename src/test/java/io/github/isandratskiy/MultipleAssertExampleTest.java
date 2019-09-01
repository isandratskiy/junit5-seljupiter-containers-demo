package io.github.isandratskiy;

import com.codeborne.selenide.*;
import io.github.bonigarcia.seljup.SelenideConfiguration;
import io.github.bonigarcia.seljup.SeleniumExtension;
import io.github.isandratskiy.driver.ChromeDriverProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.*;

@ExtendWith(SeleniumExtension.class)
class MultipleAssertExampleTest {
    @SelenideConfiguration
    static SelenideConfig selenideConfig = new SelenideConfig().browser(ChromeDriverProvider.class.getName());

    @Test
    void testSelenideConfig(SelenideDriver driver) {
        driver.open("https://the-internet.herokuapp.com");
        SelenideElement element = $("");
        Assertions.assertAll();
    }
}
