package com.vesska.tests;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.className;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

public class SearchTest extends TestBase {

    @Test
    @Tag("android")
    void searchTest() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));

    }
    @Test
    @Tag("android")
    void openGermanyPageTest() {
        back();
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Germany");
        });
        step("Click on the article", () -> {
            $(id("org.wikipedia.alpha:id/page_list_item_title")).click();
        });
        step("Verify article", () -> {
            $(className("android.view.View")).shouldHave(text("Germany"));
        });
    }

}
