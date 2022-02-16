package com.epam.tc.lesson05.cucumber.step;

import com.epam.tc.lesson05.cucumber.context.TestContext;
import com.epam.tc.lesson05.page.CitilinkCatalogItemsPage;
import com.epam.tc.lesson05.page.CitilinkIndexPage;
import com.epam.tc.lesson05.page.CitilinkProductsPage;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    @When("I open Citilink Index page")
    public void openIndexPage() {
        indexPage.open();
    }

    @When("I open catalog category {string} in {string} catalog")
    public void openCatalogCategory(final String subCategory, final String mainCategory) {
        indexPage.clickCatalogButton();
        indexPage.selectCatalogCategory(mainCategory);

        catalogItemsPage.selectSubcategory(subCategory);
    }

    @ParameterType(value = "(.*)")
    public List<Integer> productIndexes(String s) {
        return Arrays.stream(s.split(","))
                     .map(index -> Integer.parseInt(index.trim()))
                     .collect(Collectors.toList());
    }

    @When("I add products with indexes '{productIndexes}' to compare list on Catalog page")
    public void addProductsToCompareList(List<Integer> productIndexes) {
        var products = citilinkProductsPage.getProducts();
        var expectedProductTitle = new ArrayList<String>();

        for (int index : productIndexes) {
            var productTitle = products.get(index - 1).getTitle();
            expectedProductTitle.add(productTitle);
            products.get(index - 1).addProductToCompareList();
        }
        citilinkProductsPage.clickCompareButton();
        TestContext.getInstance().setObject("productTitles", expectedProductTitle);
    }
}
