package ru.training.at.hw4.listener;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ScreenshotListener implements ITestListener {
    WebDriver webDriver = null;

    private static String getTestMethodName(ITestResult testResult) {
        return testResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPng(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        ITestContext context = testResult.getTestContext();
        webDriver = (WebDriver) context.getAttribute("WebDriver");

        if (webDriver != null) {
            System.out.println("Screenshot captured for test case: "
                    + getTestMethodName(testResult));
            saveScreenshotPng(webDriver);
        }
    }
}

