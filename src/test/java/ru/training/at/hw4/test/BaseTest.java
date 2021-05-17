package ru.training.at.hw4.test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ru.training.at.hw4.listener.ScreenshotListener;
import ru.training.at.hw4.utils.GuiceDriverManager;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners({ScreenshotListener.class})
public class BaseTest {
    private final Injector injector = Guice.createInjector(new GuiceDriverManager());
    protected static final String testPageUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static final String diffElementsPageUrl = "https://jdi-testing.github.io/jdi-light/different-elements.html";
    protected static final String browserTitle = "Home Page";
    protected static final String loggedName = "ROMAN IOVLEV";
    protected static final List<String> expectedHeaderFields =
            Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    protected static final List<String> expectedTexts = Arrays.asList(
            "To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),"
                    + "\nwish to get more…");
    protected static final List<String> expectedMenuTexts = Arrays.asList(
            "Home",
            "Contact form",
            "Service",
            "Metals & Colors",
            "Elements packs");
    protected static final List<String> expectedLogsTexts = Arrays.asList(
            "Colors: value changed to Yellow",
            "metal: value changed to Selen",
            "Wind: condition changed to true",
            "Water: condition changed to true");

    @Inject
    public WebDriver webDriver;

    @BeforeMethod(alwaysRun = true)
    public void prepareToTest() {
        injector.injectMembers(this);
        //webDriver = new DriverManager().setupDriver();
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