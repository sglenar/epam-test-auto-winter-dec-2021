package com.epam.tc.lesson06.tests;

import org.testng.annotations.Test;

public class ProductSearchCitilinkTest extends AbstractBaseSeleniumTest {

    @Test
    public void searchTest() {
        actionStep.openIndexPage();

        actionStep.searchItem("iPhone");

        assertionStep.assertThatSearchResultsContains("iPhone");
    }
}
