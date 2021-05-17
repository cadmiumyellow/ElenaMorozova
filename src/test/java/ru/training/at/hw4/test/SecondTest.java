package ru.training.at.hw4.test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.page.DifferentElementsPage;
import ru.training.at.hw4.page.HomePage;

import javax.inject.Inject;

//@Listeners({ScreenshotListener.class})
public class SecondTest extends BaseTest {

    @Inject
    private HomePage homePage;
    @Inject
    private DifferentElementsPage differentElementsPage;

    @Test
    @Feature(value = "testing elements on Different Elements Page and their logs")
    @Story(value = "user can log in to Home Page, open Different Elements Page, "
            + "check necessary checkboxes, radios and dropdown and have "
            + "a correct log of his actions in Logs section")
    public void testDifferentElementsPage() {
        SoftAssert softAssert = new SoftAssert();
        // 1. Assert that test site page is loaded
        homePage.goToHomePage();
        softAssert.assertEquals(homePage.getCurrentUrl(), testPageUrl);

        //2. Assert that browser title is "Home page"
        String actualBrowserTitle = homePage.getBrowserTitle();
        softAssert.assertEquals(actualBrowserTitle, browserTitle);

        //3. Assert that user is logged
        homePage.login();
        softAssert.assertTrue(homePage.isLogoutEnabled());

        //4.Assert that user name is displayed and is equal to expected
        softAssert.assertTrue(homePage.isLoggedNameDisplayed());
        softAssert.assertEquals(homePage.getLoggedUserName(), loggedName);

        //5.Assert that Service -> Different Elements Page is opened
        homePage.goToServiceDiffElementsPage();
        softAssert.assertEquals(differentElementsPage.getCurrentUrl(), diffElementsPageUrl);

        //6.Assert checkboxes Water, Wind are checked
        softAssert.assertTrue(differentElementsPage.areCheckboxesSelected());

        //7. Assert radio Selen selection
        softAssert.assertTrue(differentElementsPage.isSelenRadioSelected());

        //8. Assert Yellow dropdown selected
        softAssert.assertTrue(differentElementsPage.isYellowSelected());

        //9. Assert logs for Water, Wind, Selen and Yellow
        int expectedNoOfLogs = 4;
        int actualNoOfLogs = differentElementsPage.getLogs().size();
        softAssert.assertTrue(actualNoOfLogs == expectedNoOfLogs);
        for (int h = 0; h < actualNoOfLogs; h++) {
            softAssert.assertEquals(differentElementsPage.getLogs().get(h).getText().substring(9),
                    expectedLogsTexts.get(h));
        }
        softAssert.assertAll();
    }
}
