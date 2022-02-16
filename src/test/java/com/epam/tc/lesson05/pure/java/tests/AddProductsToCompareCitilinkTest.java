package com.epam.tc.lesson05.pure.java.tests;

import org.testng.annotations.Test;

public class AddProductsToCompareCitilinkTest extends AbstractBaseSeleniumTest {

    @Test
    public void addProductToCompareTest() {
        actionStep.openIndexPage();

        actionStep.openCatalogCategory("Смартфоны и гаджеты", "Смартфоны");

        var expectedProductTitles = actionStep.addProductsToCompareList(1, 2, 3);

        assertionStep.assertThatCorrectProductsWasAddedToCompareList(expectedProductTitles);
    }
}
