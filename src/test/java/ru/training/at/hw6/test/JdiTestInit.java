package ru.training.at.hw6.test;

import com.epam.jdi.light.driver.WebDriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hw6.JdiSite;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;

public interface JdiTestInit {
    @BeforeSuite(alwaysRun = true)
    public default void beforeSuite() {
        initElements(JdiSite.class);
    }

    @AfterMethod(alwaysRun = true)
    public default void resetBetweenDataSets() {
        JdiSite.signOut();
    }

    @AfterSuite(alwaysRun = true)
    public default void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

}
