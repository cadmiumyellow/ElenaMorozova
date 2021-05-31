package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.training.at.hw4.page.DifferentElementsPage;
import ru.training.at.hw4.page.HomePage;


public class CommonSteps extends BaseSteps {

    public CommonSteps(WebDriver webDriver) {
        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
    }


    @Step("navigating to Home Page URL")
    public void openHomePage() {
        homePage.goToHomePage();
    }

    @Step("assert Home page is loaded")
    public void assertHomePageIsLoaded() {
        Assert.assertEquals(homePage.getCurrentUrl(), testPageUrl);
    }

    @Step("assert browser title")
    public void assertBrowserTitle() {
        String actualBrowserTitle = homePage.getBrowserTitle();
        Assert.assertEquals(actualBrowserTitle, browserTitle);
    }

    @Step("assert user login")
    public void assertUserLogin() {
        homePage.login();
        Assert.assertTrue(homePage.isLogoutEnabled());
    }

    @Step("assert user name")
    public void assertUserName() {
        Assert.assertTrue(homePage.isLoggedNameDisplayed());
        Assert.assertEquals(homePage.getLoggedUserName(), loggedName);
    }
}
