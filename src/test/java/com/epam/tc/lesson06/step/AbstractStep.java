package com.epam.tc.lesson06.step;

import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected WebDriver driver;

    protected AbstractStep(WebDriver driver) {
        this.driver = driver;
    }
}
