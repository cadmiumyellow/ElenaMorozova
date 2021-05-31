package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.training.at.hw4.page.HomePage;

public class HomePageSteps extends BaseSteps {

    public HomePageSteps(WebDriver webDriver) {
        homePage = new HomePage(webDriver);
    }

    @Step("assert 4 Header elements")
    public void assertNoOfHeaderElements() {
        int expectedNoOfItems = 4;
        Assert.assertEquals(homePage.getHeaderElements().size(), expectedNoOfItems);
    }

    @Step("assert 4 Header elements")
    public void assertFakeNoOfHeaderElements() {
        int expectedNoOfItems = 10;
        Assert.assertEquals(homePage.getHeaderElements().size(), expectedNoOfItems);
    }

    @Step("assert contents of Header elements")
    public void assertHeaderElementsContent() {
        for (int i = 0; i < homePage.getHeaderElements().size(); i++) {
            Assert.assertEquals(homePage.getHeaderElements().get(i).getText(),
                    expectedHeaderFields.get(i));
        }
    }

    @Step("assert 4 images")
    public void assertImages() {
        int expectedNoOfIcons = 4;
        Assert.assertEquals(homePage.getIcons().size(), expectedNoOfIcons);
        for (WebElement e : homePage.getIcons()) {
            Assert.assertTrue(e.isDisplayed());
        }
    }

    @Step("assert 4 images texts")
    public void assertImagesTexts() {
        int expectedNoOfTexts = 4;
        int actualNoOfTexts = homePage.getIconsTexts().size();
        Assert.assertEquals(actualNoOfTexts, expectedNoOfTexts);
        for (int i = 0; i < actualNoOfTexts; i++) {
            Assert.assertTrue(homePage.getIconsTexts().get(i).isDisplayed());
            Assert.assertEquals(homePage.getIconsTexts().get(i).getText(),
                    expectedTexts.get(i));
        }
    }

    @Step("assert iframe")
    public void assertIframe() {
        Assert.assertTrue(homePage.isIframeDisplayed());
    }

    @Step("assert iframe button")
    public void assertIframeButton() {
        homePage.switchToIframe();
        Assert.assertTrue(homePage.isIframeButtonDisplayed());
    }

    @Step("assert switch back to Home Page")
    public void assertSwitchBackToHomePage() {
        homePage.switchBackToHomePage();
        Assert.assertEquals(homePage.getCurrentUrl(), testPageUrl);

    }

    @Step("assert Left section on Home page")
    public void assertLeftSection() {
        Assert.assertTrue(homePage.isLeftSectionDisplayed());
    }

    @Step("assert Left section elements")
    public void assertLeftSectionElements() {
        int expectedNoOfMenuItems = 5;
        int actualNoOfMenuItems = homePage.getLeftMenuItems().size();
        Assert.assertEquals(actualNoOfMenuItems, expectedNoOfMenuItems);
        for (int i = 0; i < actualNoOfMenuItems; i++) {
            Assert.assertTrue(homePage.getLeftMenuItems().get(i).isDisplayed());
            Assert.assertEquals(homePage.getLeftMenuItems().get(i).getText(),
                    expectedMenuTexts.get(i));
        }
    }

    @Step("navigate to Different Elements Page")
    public void goToDifferentElementsPage() {
        homePage.goToServiceDiffElementsPage();
    }

}
