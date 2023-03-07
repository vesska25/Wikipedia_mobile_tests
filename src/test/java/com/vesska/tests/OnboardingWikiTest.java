package com.vesska.tests;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.id;


public class OnboardingWikiTest extends TestBase {


    @Test
    @Tag("android")
    void onBoardingScreenTest() {
        step("Go to main page", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia\n" +
                    "…in over 300 languages"));
        });
        step("Go to New ways to explore page", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            assertEquals("New ways to explore", $(id("org.wikipedia.alpha:id/primaryTextView")).text());

        });
        step("Go to  Reading lists with sync page", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            assertEquals("Reading lists with sync", $(id("org.wikipedia.alpha:id/primaryTextView")).text());
        });
        step("Go to Send anonymous data page", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            assertEquals("Send anonymous data", $(id("org.wikipedia.alpha:id/primaryTextView")).text());
        });
        step("Ending onBoarding", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
            $(id("org.wikipedia.alpha:id/main_toolbar_wordmark")).shouldBe(visible);
        });
    }
}
