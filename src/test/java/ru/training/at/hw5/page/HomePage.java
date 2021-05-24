package ru.training.at.hw5.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.training.at.hw5.component.BaseComponent;
import ru.training.at.hw5.utils.Prop;


public class HomePage extends BaseComponent {
    private static final String BASE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "profile-photo")
    private WebElement loginDropdown;

    @FindBy(css = "input#name")
    private WebElement userName;

    @FindBy(css = "input#password")
    private WebElement password;

    @FindBy(css = "button#login-button")
    private WebElement loginButton;

    @FindBy(css = "a.dropdown-toggle > span.caret:first-child")
    private WebElement serviceDropDown;

    @FindBy(css = "header ul.dropdown-menu a[href='different-elements.html']")
    private WebElement diffElementsPage;

    @FindBy(css = "header ul.dropdown-menu a[href='user-table.html']")
    private WebElement userTablePage;


    public void goToHomePage() {
        driver.navigate().to(new Prop().getPropertyValue("testPageUrl"));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public void login() {
        loginDropdown.click();
        userName.sendKeys(new Prop().getPropertyValue("userName"));
        password.sendKeys(new Prop().getPropertyValue("password"));
        loginButton.click();
    }

    public void goToServiceDiffElementsPage() {
        diffElementsPage.click();
    }

    public void clickServiceHeaderElement() {
        serviceDropDown.click();
    }

    public void goToUserTablePage() {
        userTablePage.click();
    }
}
