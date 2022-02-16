package com.epam.tc.lesson05.page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuComponent extends AbstractBaseComponent {

    public MenuComponent(WebDriver driver) {
        super(driver);
    }

    public void selectCatalogCategory(final String catalogName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(catalogName)))
            .click();
    }
}
