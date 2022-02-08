package com.epam.tc.lesson03.page.objects.composite;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.lesson03.SeleniumBaseTest;
import com.epam.tc.lesson03.page.objects.composite.component.HorizontalProductComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SeleniumSampleCompositeTest extends SeleniumBaseTest {

    @Test
    public void addToCompareTest() {
        CitilinkIndexPage citilinkIndexPage = new CitilinkIndexPage(driver);
        citilinkIndexPage.clickCatalogButton();
        citilinkIndexPage.menu().selectCatalogCategory("Смартфоны и гаджеты");

        new CitilinkCatalogItemsPage(driver).selectSubcategory("Смартфоны");

        CitilinkProductsPage citilinkProductsPage = new CitilinkProductsPage(driver);
        var products = citilinkProductsPage.getProducts();

        var expectedProductTitle = new ArrayList<String>();

        var productTitle = products.get(0).getTitle();
        expectedProductTitle.add(productTitle);
        products.get(0).addProductToCompareList();

        productTitle = products.get(1).getTitle();
        expectedProductTitle.add(productTitle);
        products.get(1).addProductToCompareList();

        citilinkProductsPage.clickCompareButton();

        List<WebElement> actualCompareList = wait.until(ExpectedConditions
            .numberOfElementsToBeMoreThan(By.xpath("//div[contains(@class, 'Compare__product-name-render')]"
                + "//div[contains(@class, 'Compare__product-cell')]/a"), 1));

        assertThat(actualCompareList
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList()))
            .containsExactlyInAnyOrderElementsOf(expectedProductTitle);
    }
}
