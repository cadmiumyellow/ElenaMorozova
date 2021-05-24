package ru.training.at.hw5.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw5.component.BaseComponent;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class UserTablePage extends BaseComponent {

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ivan")
    WebElement sergeiCheckbox;

    @FindBy(css = "ul.panel-body-list > li")
    private WebElement sergeiLog;

    @FindBy(css = "#user-table > tbody > tr > td:first-child")
    private List<WebElement> rowNumbers;

    @FindBy(css = "#user-table > tbody > tr > td > select")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(css = "#user-table > tbody > tr:first-child > td > select > option")
    private List<WebElement> userRomanTypeDroplistElements;

    @FindBy(css = "#user-table > tbody > tr > td > a")
    private List<WebElement> userNames;

    @FindBy(css = ".user-descr > span")
    private List<WebElement> imagesDescription;

    @FindBy(css = ".user-descr > input")
    private List<WebElement> userTableCheckBoxes;

    public void selectSergeiCheckbox() {
        wait.until(elementToBeClickable(sergeiCheckbox)).click();
    }

    public String getSergeiLog() {
        return sergeiLog.getText().substring(9);
    }

    public String getUserTableTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getNumberTypeDropdowns() {
        return numberTypeDropdowns;
    }

    public List<WebElement> getImagesDescription() {
        return imagesDescription;
    }

    public List<WebElement> getUserRomanRolesElements() {
        return userRomanTypeDroplistElements;
    }

    public List<WebElement> getRowNumbers() {
        return rowNumbers;
    }

    public List<WebElement> getUserNames() {
        return userNames;
    }

    public List<WebElement> getUserTableCheckBoxes() {
        return userTableCheckBoxes;
    }

    public boolean areElementsDisplayed(List<WebElement> a) {
        boolean flag = false;
        for (WebElement e : a) {
            if (e.isDisplayed()) {
                flag = true;
            }
        }
        return flag;
    }

}
