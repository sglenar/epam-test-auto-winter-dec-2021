package com.epam.tc.lesson04.listeners;

import com.epam.tc.lesson04.utils.AttachmentUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        log.info(result.getName());
        Object driver = result.getTestContext().getAttribute("driver");
        if (driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            AttachmentUtils.attachPngImage("Screenshot on failure", screenshot);
        } else {
            log.warn("No driver is found");
        }
    }
}
