package com.epam.tc.lesson06.step;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.lesson03.page.objects.fluent.CitilinkSearchResultPage;
import com.epam.tc.lesson06.page.CitilinkComparePage;
import io.qameta.allure.Step;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class AssertionStep extends AbstractStep {

    private CitilinkComparePage comparePage;
    private CitilinkSearchResultPage citilinkSearchResultPage;

    public AssertionStep(WebDriver driver) {
        super(driver);
        comparePage = new CitilinkComparePage(driver);
        citilinkSearchResultPage = new CitilinkSearchResultPage(driver);
    }

    @Step
    public void assertThatCorrectProductsWasAddedToCompareList(final List<String> expectedProductTitles) {
        var actualCompareList = comparePage.getProductTitles();

        assertThat(actualCompareList)
            .containsExactlyInAnyOrderElementsOf(expectedProductTitles);
    }

    @Step
    public void assertThatSearchResultsContains(final String text) {
        SoftAssertions softAssertions = new SoftAssertions();
        List<String> productTitles = citilinkSearchResultPage.getProductTitles();

        productTitles.forEach(title -> softAssertions.assertThat(title)
                                                     .as("Does not contain iPhone")
                                                     .contains("iPhone"));
        softAssertions.assertAll();
    }
}
