package com.epam.tc.lesson03.userbugred;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserBugRedLoginRegistrationPage extends UserBugRedBasePage {

    private static final String PAGE_RELATIVE_URL = "/user/login/index.html";

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='name']")
    private WebElement usernameTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='email']")
    private WebElement userEmailTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='password']")
    private WebElement userPasswordTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='act_register_now']")
    private WebElement registerButton;

    @FindBy(xpath = "//form[contains(@action, 'register')]//p")
    private WebElement errorMessageLabel;

    public UserBugRedLoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public UserBugRedLoginRegistrationPage open() {
        open(PAGE_RELATIVE_URL);
        return new UserBugRedLoginRegistrationPage(driver);
    }

    public UserBugRedLoginRegistrationPage inputTextToUsernameTextField(String username) {
        sendKeysToWebElement(usernameTextField, username);
        return new UserBugRedLoginRegistrationPage(driver);
    }

    public UserBugRedLoginRegistrationPage inputTextToUserEmailTextField(String email) {
        sendKeysToWebElement(userEmailTextField, email);
        return new UserBugRedLoginRegistrationPage(driver);
    }

    public UserBugRedLoginRegistrationPage inputTextToUserPasswordTextField(String password) {
        sendKeysToWebElement(userPasswordTextField, password);
        return new UserBugRedLoginRegistrationPage(driver);
    }

    public UserBugRedHomePage clickToRegisterButton() {
        clickToWebElement(registerButton);
        return new UserBugRedHomePage(driver);
    }

    public UserBugRedHomePage successClickToRegisterButton() {
        clickToWebElement(registerButton);
        return new UserBugRedHomePage(driver);
    }

    public UserBugRedLoginRegistrationPage failedClickToRegisterButton() {
        clickToWebElement(registerButton);
        return this;
    }

    public String getTextFromErrorMessageLabel() {
        return getTextFromWebElement(errorMessageLabel);
    }
}
