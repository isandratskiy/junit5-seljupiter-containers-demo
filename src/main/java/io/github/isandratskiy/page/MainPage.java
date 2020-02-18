package io.github.isandratskiy.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement container;

    public MainPage() {
        this.container = $("#content.large-12");
    }

    public ElementsCollection getExamplesList() {
        return $$(".columns ul li a");
    }

    public void openAvailableExample(String title) {
        this.container.$$(".columns ul li a").findBy(text(title)).click();
    }
}