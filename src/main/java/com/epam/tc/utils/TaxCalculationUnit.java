package com.epam.tc.utils;

public class TaxCalculationUnit {

    public static final double INCOME_TAX_RATE = 0.13d;

    private TaxCalculationUnit() {
    }

    public static double getIncomeTaxRate() {
        return INCOME_TAX_RATE;
    }

    public static double calculateIncomeTaxValue(double income) {
        return income * getIncomeTaxRate();
    }
}
