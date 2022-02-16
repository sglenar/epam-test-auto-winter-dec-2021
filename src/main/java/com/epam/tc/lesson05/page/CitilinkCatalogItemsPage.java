package com.epam.tc.lesson05.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CitilinkCatalogItemsPage extends AbstractCitilinkBasePage {

    public CitilinkCatalogItemsPage(WebDriver driver) {
        super(driver);
    }

    public void selectSubcategory(final String subcategoryName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(subcategoryName)))
            .click();
    }
}
