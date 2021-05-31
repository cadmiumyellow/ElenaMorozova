package ru.training.at.hw6.test;

import org.testng.annotations.Test;
import ru.training.at.hw6.entities.MetalsAndColorsData;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.forms.HeaderMenuItems;
import ru.training.at.hw6.utils.JsonDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.training.at.hw6.JdiSite;
import com.epam.jdi.light.driver.WebDriverUtils;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static org.testng.AssertJUnit.assertTrue;
import static ru.training.at.hw6.JdiSite.*;


public class JdiTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        initElements(JdiSite.class);
    }

    @AfterMethod(alwaysRun = true)
    public void resetBetweenDataSets() {
        JdiSite.signOut();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }


    @Test (dataProvider = "data", dataProviderClass = JsonDataProvider.class)
    public void jdiTest(MetalsAndColorsData set) {
        jdiHomePage.open();
        jdiHomePage.userIcon.click();
        loginForm.loginAs(User.ROMAN);
        jdiHomePage.logoutButton.isDisplayed();
        jdiHomePage.loggedIn.getValue().contentEquals(User.ROMAN.getFullName());

        jdiHomePage.headerMenu.select(HeaderMenuItems.METALS_COLORS);
        metalsAndColorsPage.checkOpened();

        metalsAndColorsForm.submit(set);
        for (int i = 0; i < metalsAndColorsPage.results.size(); i++) {
            assertTrue(metalsAndColorsPage.resultsContainData(set, i));
        }

    }

}

