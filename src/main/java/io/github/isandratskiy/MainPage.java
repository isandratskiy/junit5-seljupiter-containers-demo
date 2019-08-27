package io.github.isandratskiy;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement rootElement;

    public MainPage() {
        this.rootElement = element("#content.large-12");
    }

    private ElementsCollection getExampleRows() {
        return rootElement.$$(".columns ul li a");
    }

    public void getAviableExampleTitle(String title) {
        getExampleRows().filterBy(text(title)).find(visible).click();
    }
}