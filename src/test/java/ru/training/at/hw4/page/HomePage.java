package ru.training.at.hw4.page;

import io.qameta.allure.Step;
import ru.training.at.hw4.utils.Prop;
import ru.training.at.hw4.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.inject.Inject;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(className = "profile-photo")
    private WebElement loginDropdown;

    @FindBy(css = "input#name")
    private WebElement userName;

    @FindBy(css = "input#password")
    private WebElement password;

    @FindBy(css = "button#login-button")
    private WebElement loginButton;

    @FindBy(css = "div[class='logout'] button")
    private WebElement logoutButton;

    @FindBy(css = "span#user-name")
    private WebElement logged;

    @FindBy(xpath = "//*[@class='uui-navigation nav navbar-nav m-l8']/child::li")
    private List<WebElement> headerElements;

    @FindBy(css = "div.benefit-icon")
    private List<WebElement> icons;

    @FindBy(css = "span.benefit-txt")
    private List<WebElement> iconsTexts;

    @FindBy(css = "div.main-content iframe[id='frame']")
    private WebElement iframe;

    @FindBy(id = "button-frame")
    private WebElement iframeButton;

    @FindBy(css = "div[name='navigation-sidebar'] > div#mCSB_1:first-child")
    private WebElement leftSection;

    @FindBy(css = "#mCSB_1_container > ul > li")
    private List<WebElement> leftMenuItems;

    @FindBy(css = "a.dropdown-toggle > span.caret:first-child")
    private WebElement serviceDropDown;

    @FindBy(css = "header ul.dropdown-menu a[href='different-elements.html']")
    private WebElement diffElementsPage;


    @Inject
    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        waitActions = new WaitActions(webDriver);
    }

    @Step ("navigating to Home Page URL")
    public void goToHomePage() {
        webDriver.navigate().to(new Prop().getPropertyValue("testPageUrl"));
    }

    @Step ("getting current page URL")
    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    @Step ("getting browser title")
    public String getBrowserTitle() {
        return webDriver.getTitle();
    }

    @Step ("logging user in")
    public void login() {
        loginDropdown.click();
        userName.sendKeys(new Prop().getPropertyValue("userName"));
        password.sendKeys(new Prop().getPropertyValue("password"));
        loginButton.click();
    }

    @Step("checking if Logout button is enabled")
    public Boolean isLogoutEnabled() {
        return logoutButton.isEnabled();
    }

    @Step("checking if logged in username is displayed")
    public Boolean isLoggedNameDisplayed() {
        return logged.isDisplayed();
    }

    @Step("getting logged in username")
    public String getLoggedUserName() {
        return logged.getText();
    }

    @Step("getting list of header elements")
    public List<WebElement> getHeaderElements() {
        return headerElements;
    }

    @Step("getting list of icons")
    public List<WebElement> getIcons() {
        return icons;
    }

    @Step("getting list of icons' texts")
    public List<WebElement> getIconsTexts() {
        return iconsTexts;
    }

    @Step("checking if iframe is displayed")
    public Boolean isIframeDisplayed() {
        return iframe.isDisplayed();
    }

    @Step("switching from Home Page to iframe")
    public void switchToIframe() {
        String windowHandler = webDriver.getWindowHandle();
        webDriver.switchTo().frame(iframe);
        //return windowHandler;
    }

    @Step("checking if iframe button is displayed")
    public Boolean isIframeButtonDisplayed() {
        return iframeButton.isDisplayed();
    }

    @Step("navigating back from iframe to Home Page")
    public void switchBackToHomePage() {
        webDriver.switchTo().parentFrame();
    }

    @Step("checking if there is Left section on page")
    public Boolean isLeftSectionDisplayed() {
        return leftSection.isDisplayed();
    }

    @Step("getting list of Left menu items")
    public List<WebElement> getLeftMenuItems() {
        return leftMenuItems;
    }

    @Step("navigating to Different Elements Page")
    public void goToServiceDiffElementsPage() {
        serviceDropDown.click();
        diffElementsPage.click();
    }
}
