package ru.training.at.hw5.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class DifferentElementsPage extends HomePage {
    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

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


    public void checkWaterAndWindCheckboxes() {
        wait.until(elementToBeClickable(waterCheckbox)).click();
        wait.until(elementToBeClickable(windCheckbox)).click();
    }

    public void selectSelenRadioButton() {
        wait.until(elementToBeClickable(selenRadio)).click();
    }

    public void selectYellow() {
        wait.until(elementToBeClickable(colorsDropDown)).click();
        wait.until(elementToBeClickable(yellow)).click();
    }

    public List<String> getLogsTexts() {
        return logs
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<WebElement> getLogs() {
        return logs;
    }
}
