package ru.training.at.hw5.step;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.page.DifferentElementsPage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CucumberDifferentElementsPageSteps {
    private final WebDriver driver = TestContext.getInstance()
            .getTestObject(TestContext.WEB_DRIVER);

    @When("I select 'Water' and 'Wind' checkboxes on Different Elements Page")
    public void selectWaterAndWindCheckboxes() {
        new DifferentElementsPage(driver).checkWaterAndWindCheckboxes();
    }

    @When("I select radio button 'Selen' on on Different Elements Page")
    public void selectRadioButton() {
        new DifferentElementsPage(driver).selectSelenRadioButton();
    }

    @When("I select 'Yellow' from the dropdown menu")
    public void selectYellowFromColorsDropdown() {
        new DifferentElementsPage(driver).selectYellow();
    }

    @Then("logs for every selected element should be displayed in Log section "
            + "on Different Elements Page")
    public void assertAllLogs() {
        List<String> expectedLogsTexts = Arrays.asList(
                "Colors: value changed to Yellow",
                "metal: value changed to Selen",
                "Wind: condition changed to true",
                "Water: condition changed to true");
        List<String> actualLogsTexts =
                new DifferentElementsPage(driver)
                        .getLogsTexts();

        for (int i = 0; i < actualLogsTexts.size(); i++) {
            assertThat(actualLogsTexts.get(i).substring(9))
                    .as("Logs for checked elements don't correspond to expected")
                    .contains(expectedLogsTexts.get(i));
        }
    }
}

