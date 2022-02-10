package com.epam.tc.lesson04.utils;

import com.epam.tc.lesson04.storynames.Tags;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic(Tags.FIRST_BIG_EPIC)
@Feature(Tags.LOGIN_FEATURE)
public class LoginUtilsTest {

    @BeforeMethod
    public void setUp(ITestContext context) {
        WebDriver driver = null; // some driver initialization
        context.setAttribute("driver", driver);
    }

    @Test
    public void nullUserExceptionExpected() {
        Assertions.assertThatThrownBy(() -> LoginUtils.login(null))
                  .isInstanceOf(NullPointerException.class);
    }

    @Test
    @Description("Lets try to use wrong exception")
    public void emptyUserTest() {
        Assertions.assertThatThrownBy(() -> LoginUtils.login(LoginUtils.EMPTY_USER))
                  .isInstanceOf(NullPointerException.class);
    }

    @Test
    @Story(Tags.DEFAULT_USER_LOGIN)
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Bob Ivanovich")
    public void defaultUserLogin() {
        Assertions.assertThatCode(() -> LoginUtils.login(LoginUtils.DEFAULT_USER))
                  .doesNotThrowAnyException();
    }
}
