package com.epam.tc.lesson03.page.objects.fluent;

import com.epam.tc.lesson03.SeleniumBaseTest;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class SeleniumSampleFluentPageObjectTest extends SeleniumBaseTest {

    @Test
    public void searchTest() {
        SoftAssertions softAssertions = new SoftAssertions();

        List<String> productTitles = new CitilinkIndexPage(driver)
            .sendKeysToSearchInput("iPhone")
            .clickToSearchButton()
            .getProductTitles();

        productTitles.forEach(title -> softAssertions.assertThat(title)
                                                     .as("Does not contain iPhone")
                                                     .contains("iPhone"));
        softAssertions.assertAll();
    }

    @Test
    public void searchV2Test() {
        List<String> productTitles = new CitilinkIndexPage(driver)
            .sendKeysToSearchInput("iPhone")
            .clickToSearchButton()
            .getProductTitlesV2();

        SoftAssertions softAssertions = new SoftAssertions();
        productTitles.forEach(title -> softAssertions.assertThat(title)
                                                     .as("Does not contain iPhone")
                                                     .contains("iPhone"));
        softAssertions.assertAll();
    }
}
