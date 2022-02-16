package com.epam.tc.lesson05.page;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CitilinkComparePage extends AbstractCitilinkBasePage {

    @FindBy(xpath = "//div[contains(@class, 'Compare__product-name-render')]//div[contains(@class, 'Compare__product-cell')]/a")
    private List<WebElement> productTitles;

    public CitilinkComparePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductTitles() {
        return productTitles
            .stream()
            .map(WebElement::getText)
            .collect(Collectors.toList());
    }
}
