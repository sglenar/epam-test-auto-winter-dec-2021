package com.epam.tc.lesson04.utils;

import com.epam.tc.lesson04.entities.User;
import io.qameta.allure.Step;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LoginUtils {
    public static final User DEFAULT_USER = new User("Alice", "pRetTyGooDp@ssW0rt");
    public static final User EMPTY_USER = new User("", "");

    @Step("Typing in username")
    public void typeLogin(@NonNull final String username) {
        // nop
    }

    @Step
    public void typePassword(@NonNull final String password) {
        // nop
    }

    @Step("Logging in using '{user.name}' : '{user.password}'")
    public void login(@NonNull final User user) {
        if (EMPTY_USER.equals(user)) {
            throw new IllegalArgumentException("Empty user is passed");
        }
        typeLogin(user.getName());
        typePassword(user.getPassword());
    }
}
