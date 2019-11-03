package io.github.isandratskiy;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private SelenideElement rootElement;
    private SelenideDriver selenide;

    public MainPage(SelenideDriver selenide) {
        this.selenide = selenide;
        this.rootElement = element("#content.large-12");
    }

    public MainPage openLink(String url) {
        selenide.getWebDriver().get(url);
        return this;
    }

    private ElementsCollection getExampleRows() {
        return rootElement.$$(".columns ul li a");
    }

    public void getAviableExampleTitle(String title) {
        getExampleRows().filterBy(text(title)).find(visible).click();
    }

    public ElementsCollection getRows() {
        return selenide.$$(".columns ul li a");
    }
}