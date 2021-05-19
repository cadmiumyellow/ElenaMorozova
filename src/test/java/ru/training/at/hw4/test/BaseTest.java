package ru.training.at.hw4.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import ru.training.at.hw4.listener.ScreenshotListener;
import ru.training.at.hw4.steps.CommonSteps;
import ru.training.at.hw4.steps.DifferentElementPageSteps;
import ru.training.at.hw4.steps.HomePageSteps;
import ru.training.at.hw4.utils.GuiceDriverManager;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

@Listeners({ScreenshotListener.class})
public class BaseTest {
    private final Injector injector = Guice.createInjector(new GuiceDriverManager());
    protected CommonSteps commonSteps;
    protected HomePageSteps homePageSteps;
    protected DifferentElementPageSteps differentElementPageSteps;

    @Inject
    public WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void prepareToTest(ITestContext context) {
        injector.injectMembers(this);
        context.setAttribute("WebDriver", webDriver);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
    }

    @AfterClass(alwaysRun = true)
    public void resetBetweenTests() {
        webDriver.manage().deleteAllCookies();
        webDriver.navigate().refresh();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

}