package com.epam.tc.lesson06.step;

import com.epam.tc.lesson06.page.CitilinkCatalogItemsPage;
import com.epam.tc.lesson06.page.CitilinkIndexPage;
import com.epam.tc.lesson06.page.CitilinkProductsPage;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    private CitilinkIndexPage indexPage;
    private CitilinkCatalogItemsPage catalogItemsPage;
    private CitilinkProductsPage citilinkProductsPage;

    public ActionStep(WebDriver driver) {
        super(driver);
        indexPage = new CitilinkIndexPage(driver);
        catalogItemsPage = new CitilinkCatalogItemsPage(driver);
        citilinkProductsPage = new CitilinkProductsPage(driver);
    }

    @Step("I open Citilink Index page")
    public void openIndexPage() {
        indexPage.open();
    }

    @Step("I open catalog category {1} in {mainCategory}")
    public void openCatalogCategory(final String mainCategory, final String subCategory) {
        indexPage.clickCatalogButton();
        indexPage.selectCatalogCategory(mainCategory);

        catalogItemsPage.selectSubcategory(subCategory);
    }

    @Step("Add products with indexes {productIndexes} to compare list")
    public List<String> addProductsToCompareList(int... productIndexes) {
        var products = citilinkProductsPage.getProducts();
        var expectedProductTitle = new ArrayList<String>();

        for (int index : productIndexes) {
            var productTitle = products.get(index - 1).getTitle();
            expectedProductTitle.add(productTitle);
            products.get(index - 1).addProductToCompareList();
        }
        citilinkProductsPage.clickCompareButton();

        return expectedProductTitle;
    }

    public void searchItem(final String item) {
        indexPage.sendKeysToSearchInput(item);
        indexPage.clickToSearchButton();
    }
}
