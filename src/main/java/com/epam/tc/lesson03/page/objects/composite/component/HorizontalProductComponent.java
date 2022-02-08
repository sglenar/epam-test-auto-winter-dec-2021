package com.epam.tc.lesson03.page.objects.composite.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HorizontalProductComponent extends AbstractBaseComponent {

    private WebElement root;

    public HorizontalProductComponent(WebDriver driver, WebElement root) {
        super(driver);
        this.root = root;
    }

    public void addProductToCompareList() {
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(root,
            By.xpath(".//span[contains(@class, 'ProductCardButton__icon')]")))
            .click();
    }

    public String getTitle() {
        return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(root,
                By.xpath(".//a[contains(@class, 'ProductCardHorizontal__title')]")))
            .getText();
    }
}
