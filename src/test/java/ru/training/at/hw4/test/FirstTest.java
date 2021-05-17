package ru.training.at.hw4.test;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw4.page.HomePage;

import javax.inject.Inject;

//@Listeners({ScreenshotListener.class})
public class FirstTest extends BaseTest {

    @Inject
    private HomePage homePage;

    @Test
    @Feature(value = "testing Home Page elements")
    @Story(value = "user can open and log in to Home Page, and there will be 4 items "
            + "on the header, 4 images, 4 texts, an iframe and he can switch to iframe, "
            + "check if there is an iframe button and get back to Home Page")
    public void testHomePage() {
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

        //5. Assert that there are 4 items on the header and they correspond to expected
        int expectedNoOfItems = 4;
        softAssert.assertEquals(homePage.getHeaderElements().size(), expectedNoOfItems);
        for (int i = 0; i < homePage.getHeaderElements().size(); i++) {
            softAssert.assertEquals(homePage.getHeaderElements().get(i).getText(),
                    expectedHeaderFields.get(i));
        }

        //6. Assert that there are 4 images on the Index Page and they are displayed
        int expectedNoOfIcons = 4;
        softAssert.assertEquals(homePage.getIcons().size(), expectedNoOfIcons);
        for (WebElement e : homePage.getIcons()) {
            softAssert.assertTrue(e.isDisplayed());
        }

        //7. Assert that there are 4 texts on the Index Page and they have proper texts
        int expectedNoOfTexts = 4;
        int actualNoOfTexts = homePage.getIconsTexts().size();
        softAssert.assertEquals(actualNoOfTexts, expectedNoOfTexts);
        for (int i = 0; i < actualNoOfTexts; i++) {
            softAssert.assertTrue(homePage.getIconsTexts().get(i).isDisplayed());
            softAssert.assertEquals(homePage.getIconsTexts().get(i).getText(),
                    expectedTexts.get(i));
        }

        //8. Assert an iframe
        softAssert.assertTrue(homePage.isIframeDisplayed());

        //9. Assert "Frame button" at iframe
        homePage.switchToIframe();
        softAssert.assertTrue(homePage.isIframeButtonDisplayed());

        //10. Assert switch to the original window
        homePage.switchBackToHomePage();
        softAssert.assertEquals(homePage.getCurrentUrl(), testPageUrl);

        //11. Assert that there is Left Section and elements in it
        softAssert.assertTrue(homePage.isLeftSectionDisplayed());
        int expectedNoOfMenuItems = 5;
        int actualNoOfMenuItems = homePage.getLeftMenuItems().size();
        softAssert.assertEquals(actualNoOfMenuItems, expectedNoOfMenuItems);
        for (int i = 0; i < actualNoOfMenuItems; i++) {
            softAssert.assertTrue(homePage.getLeftMenuItems().get(i).isDisplayed());
            softAssert.assertEquals(homePage.getLeftMenuItems().get(i).getText(),
                    expectedMenuTexts.get(i));
        }
        softAssert.assertAll();
    }

}
