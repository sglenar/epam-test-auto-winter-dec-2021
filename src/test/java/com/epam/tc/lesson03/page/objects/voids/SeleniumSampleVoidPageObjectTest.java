package com.epam.tc.lesson03.page.objects.voids;

import com.epam.tc.lesson03.SeleniumBaseTest;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class SeleniumSampleVoidPageObjectTest extends SeleniumBaseTest {

    @Test
    public void searchTest() {
        SoftAssertions softAssertions = new SoftAssertions();
        CitilinkSearchResultPage citilinkSearchResultPage = new CitilinkSearchResultPage(driver);
        CitilinkIndexPage citilinkIndexPage = new CitilinkIndexPage(driver);

        citilinkIndexPage.sendKeysToSearchInput("iPhone");
        citilinkIndexPage.clickToSearchButton();

        List<String> productTitles = citilinkSearchResultPage.getProductTitles();

        productTitles.forEach(title -> softAssertions.assertThat(title)
                                                     .as("Does not contain iPhone")
                                                     .contains("iPhone"));
        softAssertions.assertAll();
    }

    @Test
    public void searchV2Test() {
        CitilinkSearchResultPage citilinkSearchResultPage = new CitilinkSearchResultPage(driver);
        CitilinkIndexPage citilinkIndexPage = new CitilinkIndexPage(driver);

        citilinkIndexPage.sendKeysToSearchInput("iPhone");
        citilinkIndexPage.clickToSearchButton();

        List<String> productTitles = citilinkSearchResultPage.getProductTitlesV2();

        SoftAssertions softAssertions = new SoftAssertions();
        productTitles.forEach(title -> softAssertions.assertThat(title)
                                                     .as("Does not contain iPhone")
                                                     .contains("iPhone"));
        softAssertions.assertAll();
    }
}
