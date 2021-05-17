package ru.training.at.hw4.page;

import io.qameta.allure.Step;
import ru.training.at.hw4.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;
import java.util.List;

import static io.qameta.allure.Allure.step;

public class DifferentElementsPage extends BasePage {

    @FindBy(css = ".label-checkbox:first-child > input")
    private WebElement waterCheckbox;

    @FindBy(css = ".label-checkbox:nth-last-child(2) > input")
    private WebElement windCheckbox;

    @FindBy(css = ".label-radio:last-child > input")
    private WebElement selenRadio;

    @FindBy(css = ".colors")
    private WebElement colorsDropDown;

    @FindBy(xpath = "//*[text()='Yellow']")
    private WebElement yellow;

    @FindBy(css = "ul.panel-body-list > li")
    private List<WebElement> logs;


    @Inject
    public DifferentElementsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        waitActions = new WaitActions(webDriver);
    }

    @Step("getting current URL")
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    @Step("checking if Water and Wind checkboxes are selected")
    public Boolean areCheckboxesSelected() {
        step("tick Water checkbox");
        waterCheckbox.click();
        step("tick Wind checkbox");
        windCheckbox.click();
        step("check if both Water and Wind are selected");
        return ((waterCheckbox.isSelected()) && (windCheckbox.isSelected()));
    }

    @Step("checking if radio Selen is selected")
    public Boolean isSelenRadioSelected() {
        selenRadio.click();
        return selenRadio.isSelected();
    }

    @Step("checking if Yellow is selected")
    public Boolean isYellowSelected() {
        colorsDropDown.click();
        yellow.click();
        return yellow.isSelected();
    }

    @Step("getting list of logs")
    public List<WebElement> getLogs() {
        return logs;
    }
}
