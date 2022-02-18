package com.epam.tc.lesson06.tests;

import com.epam.tc.lesson06.service.webdriver.WebDriverProvider;
import com.epam.tc.lesson06.step.ActionStep;
import com.epam.tc.lesson06.step.AssertionStep;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractBaseSeleniumTest {

    protected WebDriver driver;

    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverProvider.getDriver();

        driver.manage().window().maximize();

        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
