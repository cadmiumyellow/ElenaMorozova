package ru.training.at.hw4.listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.training.at.hw4.test.BaseTest;


public class ScreenshotListener implements ITestListener {

    private static String getTestMethodName(ITestResult testResult) {
        return testResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPng(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult testResult) {

        Object testClass = testResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).webDriver;

        if (driver != null) {
            System.out.println("Screenshot captured for test case:"
                    + getTestMethodName(testResult));
            saveScreenshotPng(driver);
        }
    }
}

