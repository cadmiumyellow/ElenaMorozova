package ru.training.at.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseSeleniumTestsSetup {
    protected WebDriver webDriver;
    protected static final String testPageUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final String diffElementsPageUrl = "https://jdi-testing.github.io/jdi-light/different-elements.html";
    protected static final String userName = "Roman";
    protected static final String password = "Jdi1234";

    @BeforeMethod(alwaysRun = true)
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void clear() {
        webDriver.quit();
    }

}