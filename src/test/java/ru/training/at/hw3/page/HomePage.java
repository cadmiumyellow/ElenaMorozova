package ru.training.at.hw3.page;

import ru.training.at.hw3.utils.Prop;
import ru.training.at.hw3.utils.WaitActions;
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

    public void goToHomePage() {
        webDriver.navigate().to(new Prop().getPropertyValue("testPageUrl"));
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getBrowserTitle() {
        return webDriver.getTitle();
    }

    public void login() {
        loginDropdown.click();
        userName.sendKeys(new Prop().getPropertyValue("userName"));
        password.sendKeys(new Prop().getPropertyValue("password"));
        loginButton.click();
    }

    public Boolean isLogoutEnabled() {
        return logoutButton.isEnabled();
    }

    public Boolean isLoggedNameDisplayed() {
        return logged.isDisplayed();
    }

    public String getLoggedUserName() {
        return logged.getText();
    }

    public List<WebElement> getHeaderElements() {
        return headerElements;
    }

    public List<WebElement> getIcons() {
        return icons;
    }

    public List<WebElement> getIconsTexts() {
        return iconsTexts;
    }

    public Boolean isIframeDisplayed() {
        return iframe.isDisplayed();
    }

    public void switchToIframe() {
        String windowHandler = webDriver.getWindowHandle();
        webDriver.switchTo().frame(iframe);
        //return windowHandler;
    }

    public Boolean isIframeButtonDisplayed() {
        return iframeButton.isDisplayed();
    }

    public void switchBackToHomePage() {
        webDriver.switchTo().parentFrame();
    }

    public Boolean isLeftSectionDisplayed() {
        return leftSection.isDisplayed();
    }

    public List<WebElement> getLeftMenuItems() {
        return leftMenuItems;
    }

    public void goToServiceDiffElementsPage() {
        serviceDropDown.click();
        diffElementsPage.click();
    }
}
