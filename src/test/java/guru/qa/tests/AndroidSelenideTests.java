package guru.qa.tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AndroidSelenideTests extends TestBase{

    @Test
    void androidSelenideSampleTest() {
        step("Skip 'Choose language' step", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"))
                        .click()

        );

        sleep(5000);

        step("Click 'Search'", () ->
                $(AppiumBy.accessibilityId("Search Wikipedia"))
                        .click()
        );

        step("Input search text", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                        .sendKeys("BrowserStack")
        );

        sleep(5000);

        step("Check search results", () ->
                $$(AppiumBy.className("android.widget.TextView"))
                        .shouldHave(CollectionCondition.sizeGreaterThan(0))
        );

    }

    @Test
    void onboardingTest() {

        step("Check Onboarding. Step 1", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia"));
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("in over 300 languages"));
        });

        step("Onboarding. Continue", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .shouldHave(exactText("Continue"))
                    .click();
        });

        step("Check Onboarding. Step 2", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(exactText("New ways to explore"));
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Dive down the Wikipedia rabbit hole with a constantly updating Explore feed"));
        });

        step("Onboarding. Continue", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .shouldHave(exactText("Continue"))
                    .click();
        });

        step("Check Onboarding. Step 3", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(exactText("Reading lists with sync"));
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("You can make reading lists from articles you want to read later, even when you’re offline"));
        });

        step("Onboarding. Continue", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"))
                    .shouldHave(exactText("Continue"))
                    .click();
        });

        step("Check Onboarding. Step 4", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(exactText("Data & Privacy"));
            $(AppiumBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("We believe that you should not have to provide personal information to participate in the free knowledge movement"));
        });

        step("Onboarding. Finish", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button"))
                    .shouldHave(exactText("Get started"))
                    .click();
        });

        step("Main page appeared", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/main_toolbar_wordmark"))
                    .should(exist);
        });

    }
}
