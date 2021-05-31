package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.training.at.hw4.page.DifferentElementsPage;
import ru.training.at.hw4.page.HomePage;


public class DifferentElementPageSteps extends BaseSteps {

    public DifferentElementPageSteps(WebDriver webDriver) {
        homePage = new HomePage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
    }

    @Step("assert navigation to Different Elements Page")
        public void assertNavigationToDifferentElementsPage(){

    }

    @Step("assert checkboxes are selected")
    public void assertCheckboxesAreSelected() {
        Assert.assertTrue(differentElementsPage.areCheckboxesSelected());
    }

    @Step("assert radio Selen is selected")
    public void assertSelenIsSelected() {
        Assert.assertTrue(differentElementsPage.isSelenRadioSelected());
    }

    @Step("assert Yellow is selected")
    public void assertYellowIsSelected() {
        Assert.assertTrue(differentElementsPage.isYellowSelected());
    }

    @Step("assert Logs")
        public void assertLogs() {
        int expectedNoOfLogs = 4;
        int actualNoOfLogs = differentElementsPage.getLogs().size();
        Assert.assertTrue(actualNoOfLogs == expectedNoOfLogs);
        for (int h = 0; h < actualNoOfLogs; h++) {
            Assert.assertEquals(differentElementsPage.getLogs().get(h).getText().substring(9),
                    expectedLogsTexts.get(h));
        }
    }

    @Step("assert Different Elements Page URL")
    public void assertDifferentElementPageUrl() {
        Assert.assertEquals(differentElementsPage.getCurrentUrl(), diffElementsPageUrl);
    }

}
