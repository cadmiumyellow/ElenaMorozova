package ru.training.at.hw3.page;

import ru.training.at.hw3.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;
import java.util.List;

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

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public Boolean areCheckboxesSelected() {
        waterCheckbox.click();
        windCheckbox.click();
        return ((waterCheckbox.isSelected()) && (windCheckbox.isSelected()));
    }

    public Boolean isSelenRadioSelected() {
        selenRadio.click();
        return selenRadio.isSelected();
    }

    public Boolean isYellowSelected() {
        colorsDropDown.click();
        yellow.click();
        return yellow.isSelected();
    }

    public List<WebElement> getLogs() {
        return logs;
    }
}
