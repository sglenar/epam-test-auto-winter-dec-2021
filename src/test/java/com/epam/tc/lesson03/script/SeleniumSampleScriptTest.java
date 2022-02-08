package com.epam.tc.lesson03.script;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.lesson03.SeleniumBaseTest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SeleniumSampleScriptTest extends SeleniumBaseTest {

    @Test
    public void searchTest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.MainHeader__search input.js--InstantSearch__input")))
            .sendKeys("iPhone");
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div.MainHeader__search button.InputSearch__button_search")))
            .click();

        List<WebElement> productList = wait.until(ExpectedConditions
            .numberOfElementsToBeMoreThan(
                By.xpath("//div[contains(@class, 'product_data')]//a[contains(@class, 'ProductCardVertical__name')]"),
                5));
        List<String> productTitles = productList.stream()
                                                .map(WebElement::getText)
                                                .collect(Collectors.toList());

        SoftAssertions softAssertions = new SoftAssertions();
        productTitles.forEach(title -> softAssertions.assertThat(title)
                                                     .as("Does not contain iPhone")
                                                     .contains("iPhone"));
    }

    @Test
    public void addToCompareTest() {
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@class='MainHeader__catalog']//span[contains(text(), 'Каталог')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Смартфоны и гаджеты"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Смартфоны"))).click();

        List<WebElement> productList =
            wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[contains(@class, 'product_data')]"),
                    5));

        var expectedProductTitle = new ArrayList<String>();

        var productTitle =
            productList.get(0).findElement(By.xpath(".//a[contains(@class, 'ProductCardHorizontal__title')]"))
                       .getText();
        expectedProductTitle.add(productTitle);
        productList.get(0).findElement(By.xpath(".//span[contains(@class, 'ProductCardButton__icon')]")).click();

        productTitle =
            productList.get(1).findElement(By.xpath(".//a[contains(@class, 'ProductCardHorizontal__title')]"))
                       .getText();
        expectedProductTitle.add(productTitle);
        productList.get(1).findElement(By.xpath(".//span[contains(@class, 'ProductCardButton__icon')]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[contains(@class, 'HeaderMenu')]//div[@data-name='compare']"))).click();

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
