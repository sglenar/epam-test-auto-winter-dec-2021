package com.epam.tc.lesson03.page.objects.fluent;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractCitilinkBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected AbstractCitilinkBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(this.driver, this);
    }
}
