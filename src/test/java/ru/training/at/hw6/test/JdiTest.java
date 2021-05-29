package ru.training.at.hw6.test;

import org.testng.annotations.Test;
import ru.training.at.hw6.entities.MetalsAndColorsData;
import ru.training.at.hw6.entities.User;
import ru.training.at.hw6.forms.HeaderMenuItems;
import ru.training.at.hw6.utils.JsonDataProvider;

import static org.testng.AssertJUnit.assertTrue;
import static ru.training.at.hw6.JdiSite.*;


public class JdiTest implements JdiTestInit {

    @Test (dataProvider = "data", dataProviderClass = JsonDataProvider.class)
    public void jdiTest(MetalsAndColorsData set) {
        jdiHomePage.open();
        jdiHomePage.userIcon.click();
        loginForm.loginAs(User.ROMAN);
        jdiHomePage.logoutButton.isDisplayed();
        jdiHomePage.loggedIn.getValue().contentEquals(User.ROMAN.getFullName());

        jdiHomePage.headerMenu.select(HeaderMenuItems.METALS_COLORS);
        metalsAndColorsPage.checkOpened();

        metalsAndColorsForm.submitForm(set);
        for (int i = 0; i < metalsAndColorsPage.results.size(); i++) {
            assertTrue(metalsAndColorsPage.resultsContainData(set, i));
        }

    }

}
