package com.epam.tc.lesson03.userbugred;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.lesson03.SeleniumBaseTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserBugRedRegisterUserTest extends SeleniumBaseTest {

    private static final Faker FAKER = new Faker();

    @BeforeMethod
    @Override
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void registerUserTest() {
        String expectedUsername = FAKER.name().username();

        var userBugRedHomePage = new UserBugRedLoginRegistrationPage(driver)
            .open()
            .inputTextToUsernameTextField(expectedUsername)
            .inputTextToUserEmailTextField(FAKER.internet().emailAddress())
            .inputTextToUserPasswordTextField(FAKER.internet().password())
            .successClickToRegisterButton();

        String actualUsername = userBugRedHomePage.getTextFromUsernameDropdown();

        assertThat(actualUsername)
            .as("Username was incorrect")
            .isEqualToIgnoringCase(expectedUsername);
    }

    @Test
    public void registerUserNegativeTest() {
        String expectedUsername = FAKER.name().username();

        var actualErrorText = new UserBugRedLoginRegistrationPage(driver)
            .open()
            .inputTextToUsernameTextField(expectedUsername)
            .inputTextToUserEmailTextField(FAKER.internet().domainSuffix())
            .inputTextToUserPasswordTextField(FAKER.internet().password())
            .failedClickToRegisterButton()
            .getTextFromErrorMessageLabel();

        assertThat(actualErrorText)
            .as("Error message was incorrect")
            .isEqualToIgnoringCase("register_not_correct_field (email)");
    }
}
