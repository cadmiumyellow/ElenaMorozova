package ru.training.at.hw4.test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.steps.CommonSteps;
import ru.training.at.hw4.steps.DifferentElementPageSteps;
import ru.training.at.hw4.steps.HomePageSteps;


public class SecondTest extends BaseTest {

    @Test
    @Feature(value = "testing elements on Different Elements Page and their logs")
    @Story(value = "user can log in to Home Page, open Different Elements Page, "
            + "check necessary checkboxes, radios and dropdown and have "
            + "a correct log of his actions in Logs section")
    public void testDifferentElementsPage() {
        commonSteps = new CommonSteps(webDriver);
        homePageSteps = new HomePageSteps(webDriver);
        differentElementPageSteps = new DifferentElementPageSteps(webDriver);

        // 1. Assert that test site page is loaded
        commonSteps.openHomePage();
        commonSteps.assertHomePageIsLoaded();

        //2. Assert that browser title is "Home page"
        commonSteps.assertBrowserTitle();

        //3. Assert that user is logged
        commonSteps.assertUserLogin();

        //4.Assert that user name is displayed and is equal to expected
        commonSteps.assertUserName();

        //5.Assert that Service -> Different Elements Page is opened
        homePageSteps.goToDifferentElementsPage();
        differentElementPageSteps.assertDifferentElementPageUrl();

        //6.Assert checkboxes Water, Wind are checked
        differentElementPageSteps.assertCheckboxesAreSelected();

        //7. Assert radio Selen selection
        differentElementPageSteps.assertSelenIsSelected();

        //8. Assert Yellow dropdown selected
        differentElementPageSteps.assertYellowIsSelected();

        //9. Assert logs for Water, Wind, Selen and Yellow
        differentElementPageSteps.assertLogs();


    }
}

