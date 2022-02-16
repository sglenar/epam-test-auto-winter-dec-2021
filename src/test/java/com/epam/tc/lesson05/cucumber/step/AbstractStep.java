package com.epam.tc.lesson05.cucumber.step;

import com.epam.tc.lesson05.cucumber.context.TestContext;
import com.epam.tc.lesson05.page.CitilinkCatalogItemsPage;
import com.epam.tc.lesson05.page.CitilinkComparePage;
import com.epam.tc.lesson05.page.CitilinkIndexPage;
import com.epam.tc.lesson05.page.CitilinkProductsPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected CitilinkIndexPage indexPage;
    protected CitilinkCatalogItemsPage catalogItemsPage;
    protected CitilinkProductsPage citilinkProductsPage;
    protected CitilinkComparePage comparePage;

    protected AbstractStep() {
        WebDriver driver = TestContext.getInstance().getObject("driver", WebDriver.class);
        indexPage = new CitilinkIndexPage(driver);
        catalogItemsPage = new CitilinkCatalogItemsPage(driver);
        citilinkProductsPage = new CitilinkProductsPage(driver);
        comparePage = new CitilinkComparePage(driver);
    }

}
