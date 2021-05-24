package ru.training.at.hw5.step;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.page.UserTablePage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CucumberUserTableSteps {

    private final WebDriver driver = TestContext.getInstance()
            .getTestObject(TestContext.WEB_DRIVER);

    private List<WebElement> numberTypeDropdowns;

    @Given("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectVipCheckboxForSergeiIvan() {
        new UserTablePage(driver).selectSergeiCheckbox();
    }

    @Then("1 log row has {string} text in log section")
    public void assertSergeiCheckboxLog(String expected) {
        Assert.assertTrue(new UserTablePage(driver)
                .getSergeiLog()
                .contains(expected), "wrong Sergei log");
    }

    @Then("{string} page should be opened")
    public void assertPageTitle(String expectedTitle) {
        assertThat(new UserTablePage(driver).getUserTableTitle()
                .contains(expectedTitle));
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assert6NumberTypeDropdown(int expectedNoOfNumberTypeDropdowns) {
        Assert.assertEquals(new UserTablePage(driver)
                .getNumberTypeDropdowns().size(),
                expectedNoOfNumberTypeDropdowns);
        Assert.assertTrue(new UserTablePage(driver)
                .areElementsDisplayed(new UserTablePage(driver)
                .getNumberTypeDropdowns()));
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void assert6Usernames(int expectedNoOfUserNames) {
        Assert.assertEquals(new UserTablePage(driver)
                .getUserNames().size(),
                expectedNoOfUserNames);
        Assert.assertTrue(new UserTablePage(driver)
                .areElementsDisplayed(new UserTablePage(driver)
                .getUserNames()));
    }

    @Then("{int} Description texts under images should be displayed on Users Table "
            + "on User Table Page")
    public void assert6DescriptionTexts(int expectedNoOfDescriptionTexts) {
        Assert.assertEquals(new UserTablePage(driver)
                .getImagesDescription().size(), expectedNoOfDescriptionTexts);
        Assert.assertTrue(new UserTablePage(driver)
                .areElementsDisplayed(new UserTablePage(driver)
                .getImagesDescription()));
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void assert6UserTableCheckboxes(int expectedNoOfUserTableCheckboxes) {

        Assert.assertEquals(new UserTablePage(driver)
                .getUserTableCheckBoxes().size(), expectedNoOfUserTableCheckboxes);
        Assert.assertTrue(new UserTablePage(driver)
                .areElementsDisplayed(new UserTablePage(driver)
                .getUserTableCheckBoxes()));
    }

    @Then("User table should contain following values:")
    public void assertUserTableContents(DataTable dataTable) {
        UserTablePage userTablePage = new UserTablePage(driver);
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i < table.size(); i++) {
            Assert.assertEquals(userTablePage.getRowNumbers().get(i).getText(),
                    table.get(i).get("Number"));
            Assert.assertEquals(userTablePage.getUserNames().get(i).getText(),
                    table.get(i).get("User"));
            assertThat(userTablePage.getImagesDescription().get(i).getText()
                    .contains(table.get(i).get("Description")));
        }
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void assertUserRolesForUserRoman(List<String> expectedRoles) {
        for (int i = 0; i < expectedRoles.size() - 1; i++) {
            Assert.assertEquals(new UserTablePage(driver)
                            .getUserRomanRolesElements()
                            .get(i).getText(),
                    expectedRoles
                            .stream()
                            .skip(1)
                            .collect(Collectors.toList())
                            .get(i));
        }
    }

}

