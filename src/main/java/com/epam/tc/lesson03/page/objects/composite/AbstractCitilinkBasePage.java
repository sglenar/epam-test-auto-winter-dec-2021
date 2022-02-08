package com.epam.tc.lesson03.page.objects.composite;

import com.epam.tc.lesson03.page.objects.composite.component.MenuComponent;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractCitilinkBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected MenuComponent menu;

    @FindBy(xpath = "//div[@class='MainHeader__catalog']//span[contains(text(), 'Каталог')]")
    private WebElement catalogButton;

    @FindBy(xpath = "//div[contains(@class, 'HeaderMenu')]//div[@data-name='compare']")
    private WebElement compareButton;

    protected AbstractCitilinkBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(this.driver, this);
        menu = new MenuComponent(driver);
    }

    public MenuComponent menu() {
        return this.menu;
    }

    public void clickCatalogButton() {
        catalogButton.click();
    }

    public void clickCompareButton() {
        compareButton.click();
    }
}
