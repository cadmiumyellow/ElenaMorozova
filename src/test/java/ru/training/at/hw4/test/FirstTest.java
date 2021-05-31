package ru.training.at.hw4.test;

import org.testng.annotations.Test;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import ru.training.at.hw4.steps.CommonSteps;
import ru.training.at.hw4.steps.HomePageSteps;

import javax.inject.Inject;

public class FirstTest extends BaseTest {

    @Test
    @Feature(value = "testing Home Page elements")
    @Story(value = "user can open and log in to Home Page, and there will be 4 items "
            + "on the header, 4 images, 4 texts, an iframe and he can switch to iframe, "
            + "check if there is an iframe button and get back to Home Page")
    public void testHomePage() {
        commonSteps = new CommonSteps(webDriver);
        homePageSteps = new HomePageSteps(webDriver);

        // 1. Assert that test site page is loaded
        commonSteps.openHomePage();
        commonSteps.assertHomePageIsLoaded();

        //2. Assert that browser title is "Home page"
        commonSteps.assertBrowserTitle();

        //3. Assert that user is logged
        commonSteps.assertUserLogin();

        //4.Assert that user name is displayed and is equal to expected
        commonSteps.assertUserName();

        //5. Assert that there are 4 items on the header and they correspond to expected
        homePageSteps.assertNoOfHeaderElements();
        homePageSteps.assertHeaderElementsContent();

        //6. Assert that there are 4 images on the Index Page and they are displayed
        homePageSteps.assertImages();

        //7. Assert that there are 4 texts on the Index Page and they have proper texts
        homePageSteps.assertImagesTexts();

        //8. Assert an iframe
        homePageSteps.assertIframe();

        //9. Assert "Frame button" at iframe
        homePageSteps.assertIframeButton();

        //10. Assert switch to the original window
        homePageSteps.assertSwitchBackToHomePage();

        //11. Assert that there is Left Section and elements in it
        homePageSteps.assertLeftSection();
        homePageSteps.assertLeftSectionElements();

    }
}


