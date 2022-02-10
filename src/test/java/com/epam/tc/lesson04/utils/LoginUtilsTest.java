package com.epam.tc.lesson04.utils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("first big epic")
@Epic("Login")
public class LoginUtilsTest {

    @BeforeMethod
    public void setUp(ITestContext context) {
        WebDriver driver = null; // some driver initialization
        context.setAttribute("driver", driver);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void nullUserExceptionExpected() {
        LoginUtils.login(null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    @Description("Lets try to use wrong exception")
    @Story("Default login")
    public void emptyUserTest() {
        LoginUtils.login(LoginUtils.EMPTY_USER);
    }

    //TODO: remove this test
    @Test
    public void defaultUserLogin() {
        LoginUtils.login(LoginUtils.DEFAULT_USER);
    }
}
