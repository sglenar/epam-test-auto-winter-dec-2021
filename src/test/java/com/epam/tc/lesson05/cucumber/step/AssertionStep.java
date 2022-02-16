package com.epam.tc.lesson05.cucumber.step;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.lesson05.cucumber.context.TestContext;
import io.cucumber.java.en.Then;
import java.util.List;

public class AssertionStep extends AbstractStep {

    @Then("all added products should be displayed on Compare page")
    public void assertThatCorrectProductsWasAddedToCompareList() {
        List<String> expectedProductTitles = TestContext.getInstance().getObject("productTitles", List.class);
        var actualCompareList = comparePage.getProductTitles();

        assertThat(actualCompareList)
            .containsExactlyInAnyOrderElementsOf(expectedProductTitles);
    }
}
