package com.epam.tc.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TaxCalculationUnitTest {

    @Test(
        dataProviderClass = DataProviderForCalculator.class,
        dataProvider = "correct data"
    )
    public void additionTest(int a, int b, int expected) {
        int actual = a + b;
        Assert.assertEquals(actual, expected);
    }
}
