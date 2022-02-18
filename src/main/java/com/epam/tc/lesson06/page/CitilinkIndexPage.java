package com.epam.tc.lesson06.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CitilinkIndexPage extends AbstractCitilinkBasePage {

    @FindBy(css = "div.MainHeader__search input.js--InstantSearch__input")
    private WebElement searchInput;

    @FindBy(css = "div.MainHeader__search button.InputSearch__button_search")
    private WebElement searchButton;

    public CitilinkIndexPage(WebDriver driver) {
        super(driver);
    }

    public void sendKeysToSearchInput(final String searchText) {
        searchInput.sendKeys(searchText);
    }

    public void clickToSearchButton() {
        searchButton.click();
    }

    public void open() {
        open("");
    }
}
