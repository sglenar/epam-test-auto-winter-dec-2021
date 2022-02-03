package com.epam.tc.lesson01.utils;

import org.testng.annotations.DataProvider;

public class DataProviderForCalculator {

    @DataProvider(name = "correct data")
    public static Object[][] getTestDataForAddition() {
        return new Object[][] {
            {2, 2, 4},
            {1, 2, 5},
            {0, 6, 6}
        };
    }
}
