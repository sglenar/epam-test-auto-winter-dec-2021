/*
package com.epam.tc.utils;

import java.util.List;

public class FrameworkDemo {
    public List<?> getTestList() {
        return null;
    }

    public void printTestReport() {
    }

    public void runSpecificTest(Object testMethod) {
        before();
        try {
            testMethod.getMethod.run();
            markPassed();
        } catch (AssertionError assertionError) {
            markFailed(assertionError);
        } catch (Exception exception) {
            markBroken(exception);
        }
        after();
    }

    public void runTests() {
        List<?> testMethods = getTestList();
        for (Object i : testMethods) {
            runSpecificTest(i);
        }
        printTestReport();
    }
}
*/
